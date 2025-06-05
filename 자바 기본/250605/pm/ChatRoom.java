package pm;

import pm.ChatServer;
import pm.CopyClient;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRoom {
   ArrayList<CopyClient> ru_list; // 방에 참여한 사용자들
   String roomName;
   ChatServer server;
   
   public ChatRoom(String n, ChatServer server) {
      this.roomName = n;
      this.server = server; // 나중에 방 나가기를 할 때
      // 현재 ru_list에서 삭제가 된 후 다시 Chatserver에 있는
      // u_list에 CopyClient를 추가해야 하기 때문에 필요
      ru_list = new ArrayList<CopyClient>();
   }
   
   public void sendMsg(Protocol p) { // 현재 방에 접속한 모든 사용자에게 데이터를 전달
      
	   //for(int i = 0; i < ru_list.size(); i++) {
	   //CopyClient cc = ru_list.get(i);
      for(CopyClient cc : ru_list) { // 위의 주석처리한 두 행과 같은 역할을 함
      // 개선된 for --> for(뒤에 있는 배열에서 뽑아서 저장받을 변수 : 반복을 할 배열 혹은 리스트)
      // 알아서 배열 & 리스트의 첫 요소부터 마지막까지 반복한다
      
         try {
            cc.out.writeObject(p);
            cc.out.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      } // for 끝
   }
   
   public void getOut(CopyClient cc) { // 방 나가기
      ru_list.remove(cc);
      // 만약 지금 나가는 CopyClient가 마지막 접속자이면
      // 그냥 현재 방은 삭제되어야 한다
      if(ru_list.size()==0){
         //자신이 마지막으로 나가는 경우는
         //그냥 방을 삭제하면 된다.
         server.r_list.remove(this);

         server.addClient(cc);
         //대기실로 추가되어야한다. (CopyClient가 )
      }else{
         //아직 방에 남아있는 사람이 있는 경우
         //명단갱신과 메세지 전달을 해야한다.
         Protocol protocol = new Protocol();
         protocol.setMsg(" *** " + cc.nickName + "님 퇴장 ***\r\n ");
         protocol.setCmd(4);
         protocol.setUser_names(getJoinNames());

         sendMsg(protocol); // 참여자에게 전달
      }
      server.addClient(cc);
      
   }
   
   public void joinUser(CopyClient cc) { // 방 참여
      ru_list.add(cc);
      Protocol protocol = new Protocol();
      protocol.setMsg(" *** " + cc.nickName + "님 입장 ***\r\n ");
      protocol.setCmd(4);
      protocol.setUser_names(getJoinNames());
      
      sendMsg(protocol); // 참여자에게 전달

   }
   
   public String[] getJoinNames() { // 현재 방에 참여한 참여자명단 얻는 함수
      String[] names = new String[ru_list.size()];
      int i = 0;
      for(CopyClient cc : ru_list) {// 클라이언트의 복사본을 하나씩 얻어낸다
         names[i++] = cc.getNickname();
      }
      return names;
   }
}
