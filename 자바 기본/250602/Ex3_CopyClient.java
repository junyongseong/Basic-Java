package pm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Ex3_CopyClient extends Thread {

	Socket s;
	Ex3_ChatServer server;
	
	//통신을 위한 스트림들
	ObjectOutputStream out;
	ObjectInputStream in;
	
	String ip,NickName;
	
	public Ex3_CopyClient(Socket s,Ex3_ChatServer ex3_ChatServer){
		this.s=s;
		this.server = ex3_ChatServer;
		// in/out 스트림들 생성 ip도 얻어내야 한다.
		try {
			in= new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			
			ip=s.getInetAddress().getHostAddress();//접속자 IP
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//생성자의 끝

	@Override
	public void run() {
		//현재 스레드는 서버에서 실제 클라이언트를 대신하면서 
		//언제, 어느때에 원격에 있는 클라이언트가 서버로 메세지를 보낼지 모르므로
		//항상 inputstream을 read를 수행하여 메세지가 올 때까지 기다려야 한다. 
		bk:while(true) {
			try {
				//스트림으로부터 객체를 읽어낸다.
				Object obj= in.readObject();
				if(obj !=null) {
					Ex3_Protocol protocol = (Ex3_Protocol) obj;
					//protocol의 cmd값이 뭐냐에 따라 작업의 구분을 구현한다.
					switch (protocol.getCmd()) {
					case 3: 
						//원격의 클라이언트에 있는 스레드를 소멸시키기 위해 메세지를 보내온것이다.
						out.writeObject(protocol);
						break bk;//while문을 빠져나가야하니 bk
					case 1:
						//서버에 접속 한 경우
						//사용자가 입력한 대화명을 얻어내어 NickName에 저장한다.
						this.NickName =protocol.getMsg();
						
						//환영 메세지를 보내기 위해 EX3_Protocol객체 생성
						Ex3_Protocol p= new Ex3_Protocol();
						p.cmd=2;
						p.msg="***"+NickName+"님 입장***";
						server.sendProtocol(p);//접속자 모두에게 전달
						break;
					case 2:
						//채팅 메세지
						//메세지 앞에 NickName을 붙여서 msg에 다시 저장하자!
						protocol.setMsg(NickName+":"+protocol.getMsg());
						
						server.sendProtocol(protocol);//접속자 모두에게 전달
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//무한반복문의 끝
		try {
			if(out!=null)
				out.close();
			if(in!=null)
				in.close();
			if(s!=null)
				s.close();
			
			//서버의 ArrayList에서 현재 객체를 삭제한다.
			server.removeClient(this);
			
			//서버의 다른 접속자들에게 현재객체가 접속해제한다는 메세지를 보낸다.
			Ex3_Protocol p = new Ex3_Protocol();
			p.cmd=2;
			p.msg="***"+NickName+"님 퇴장***";
			server.sendProtocol(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
