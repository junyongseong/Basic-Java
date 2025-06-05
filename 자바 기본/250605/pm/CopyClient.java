package pm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread{
   Socket s;
   ChatServer Server;
   
   // 통신을 위한 스트림들
   ObjectOutputStream out;
   ObjectInputStream in;
   String ip, nickName;
   ChatRoom currentRoom; // 현재 참여하고 있는 방 만약 currentRoom이 null이라면
   						// 현재 사용자는 대기실에 있는 것이다
   
   public CopyClient(Socket s, ChatServer Server) {
      
      this.s = s; // 실제 접속자를 받아오면서 이제 실접속자가 해야할 일을 대신 처리할 것이다
      this.Server = Server;
      
      // in / out 스트림 생성, ip 얻기
      try {
         in = new ObjectInputStream(s.getInputStream());
         out = new ObjectOutputStream(s.getOutputStream());
         ip = s.getInetAddress().getHostAddress(); // 접속자 IP
      } catch (IOException e) {}
   } // 생성자의 끝

   @Override
   public void run() {
      // 현재 스레드는 서버에서 실제 클라이언트를 대신하면서
      // 언제, 어느 때에 원격에 있는 클라이언트가 서버로 메세지를 보낼지 모른다
      // 따라서 항상 inputstream을 수행하여 메세지를 받을 수 있도록 한다
      bk:while(true) {
         try {
            // 스트림으로부터 객체를 읽는다
            Object obj = in.readObject(); // 대기상태
            if(obj != null) {
               Protocol protocol = (Protocol) obj;
               
               // protocol의 cmd값이 뭐냐에 따라 작업을 구현
               switch (protocol.getCmd()) {
               case 3: {
                  // 원격의 클라이언트에 있는 스레드를 소멸시키기 위해
                  // 메세지를 보내온 것
                  out.writeObject(protocol);
                  out.flush();
                  break bk;
               }
               case 1:// 서버에 접속한 경우는
                   // 사용자가 입력한 대화명을 얻어내어 nickName에 저장한다
                  this.nickName = protocol.getMsg();
                  Protocol p = new Protocol();
                  p.setCmd(1);// 명단 수집
                  p.setUser_names(Server.getNames()); 
                  // chatserver에 있는 u_list(접속과 동시에 접속자의 정보가 알아서 추가되는 리스트)를
                  // 거쳐 이름을 최신화한다
                  p.setRoom_names(Server.getRoomNames());
                  Server.sendProtocol(p); // 접속자 모두에게 전달
                  break;
               case 2:  // 채팅 메세지
                  // 메세지 앞에 nickName을 붙여서 msg에 다시 저장하자
                  protocol.setMsg(nickName + ":" + protocol.getMsg());
                  Server.sendProtocol(protocol); // 접속자 모두에게 전달
                  break;
               case 4:// 방 만들기
                  currentRoom = new ChatRoom(protocol.msg, Server);
                  Server.r_list.add(currentRoom); // 방 목록(리스트)에 올림
                  // 대기실에서 현재 CopyClient를 삭제
                  Server.removeClient(this);
                  currentRoom.joinUser(this); // 현재 대기자 --> 방 참여자로 전직
                  break;
               case 5: //방 나가기
            	   // Protocol p2= new Protocol(); 
            	   //p2.setCmd(1);
                  if(currentRoom!=null){
                     //원격에 있는 클라이언트가 [방나가기]라는 버튼을
                     //클릭했을 때 수행!
                     currentRoom.getOut(this);
                     currentRoom= null;//***중요*** 대기실로 가는순간 currentRoom은 Null로 초기화
                     protocol.setUser_names(Server.getNames());
                     protocol.setRoom_names(Server.getRoomNames());
                     out.writeObject(protocol);
                     out.flush();
                  }
                  break;
               case 6:
                  int idx= protocol.index;
                  currentRoom = Server.r_list.get(idx);
                  Server.removeClient(this);//대기실에서 자신을 삭제
                  currentRoom.joinUser(this);
                  break;

               }
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      } // 무한반복의 끝
      
      // cmd가 3(해당 접속자가 종료를 눌렀을 경우) 수행할 부분
      try {
         if(out != null)
            out.close();
         if(in != null)
            in.close();
         if(s != null)
            s.close();
         
         if(currentRoom != null) { // 입장한 방이 있다면
            currentRoom.getOut(this);
         } else {
            // 서버의 ArrayList에서 현재 객체(접속자)를 삭제한다
            Server.removeClient(this);
            
            Protocol p = new Protocol();
            p.cmd = 1;
            p.setUser_names(Server.getNames()); 
            // chatserver에 있는 u_list(접속과 동시에 접속자의 정보가 알아서 추가되는 리스트)를
            // 거쳐 이름을 최신화한다
            Server.sendProtocol(p);
         }
      } catch (Exception e) {}
   }
   
   // 현재접속자의 이름을 반환해주는 기능
   public String getNickname() {
      return nickName;
   }
   
}
