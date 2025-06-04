package pm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	ServerSocket ss;//서버 소켓
	ArrayList<CopyClient> u_list;// 대기 유저 리스트
	
	Thread thread = new Thread() {
		@Override
		public void run() {
			//////////스레드가 해야할 일
			//접속자가 발생할때까지 계속 대기해야하니 무한 반복
			while(true) {
				try {
					Socket s = ss.accept();//접속자가 올때까지 기다린다.
					CopyClient cc= new CopyClient(s, ChatServer.this);
					
					u_list.add(cc);
					cc.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//무한반복문의 끝
		}//run 함수의 끝
		
	};//thread의 끝
	
	//ArrayList<ChatRoom> r_list;// 채팅방 리스트
	
	public ChatServer() {
		//////////////////해야할것 
		u_list = new ArrayList<CopyClient>();//유저 대기자들을 저장할 멤버변수 초기화
		
		try {
			ss= new ServerSocket(5555);
			System.out.println("서버를 시작합니다.");
			
			thread.start();//서버 Thread 시작!
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자의 끝
	
	//list에서 copyClient객체를 삭제함
	//삭제 하려고하는 객체의 주소를 인자로 받아야함 (cc)
	public void removeClient(CopyClient cc) {
		u_list.remove(cc);
	}
	
	//대기 유저 모두에게 전달하는 기능
	public void sendProtocol(Protocol p) {
		for(int i=0;i<u_list.size();i++) {
			CopyClient cc= u_list.get(i);
			
			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//대기실 명단을 수집하여 반환하는 기능
	public String[] getNames() {
		//ArrayList에 있는 요소들에게 이름을 받아서 배열화 시킨다.
		String[] names = new String[u_list.size()];
		for(int i=0; i<u_list.size();i++) {
			//Client의  복사본을 하나씩 얻어낸다.
			CopyClient cc = u_list.get(i);
			names[i]=cc.getNickName();
		}
		return names;//for문이 끝나고 저장된 이름들을 반환
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new ChatServer();
	}
}
