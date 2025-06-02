package am;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex1_Server {

	public static void main(String[] args) throws IOException {
		//서버는 접속을 받기위해 반드시 ServerSocket에 있어야 한다.
		ServerSocket ss= new ServerSocket(5555);
		System.out.println("Server started: "+ss.getLocalPort());
		
		//Socket socket =ss.accept();//hold걸어놓기
		Thread thread = new Thread() {

			@Override
			public void run() {//재정의
				while(true) {
					//서버는 접속자를 받아들여야 한다. 그 기능이 다음과 같다.
					Socket s= null; //소켓 선언 , 접속자의 정보
					try {
						s=ss.accept();//접속자가 올때 까지 기다린다.(대기상태)
					} catch (Exception e) {	}
					//Socket은 외부에서 접속한 클라이언트의 소켓객체다.
					InetAddress ip= s.getInetAddress();//접속자의 ip얻어내기
					String clientIp= ip.getHostAddress();//접속자의 IP
					System.out.println("접속자의 ip: "+clientIp);
					System.out.println("weweㅁㄴㅇㅁㄴㅇㄴㅁe");
				}//무한반복문 While의 끝
			}
			
		};//이 쓰레드가 해야할 일은 except(홀드)만 하는 역할
		
		thread.start();
	}

}
