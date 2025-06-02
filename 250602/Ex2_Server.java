package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex2_Server {

	public static void main(String[] args) throws IOException {
		//서버 준비는 서버소켓 생성하는것
		ServerSocket ss = new ServerSocket(5555);//서버 준비 및 예외처리 완료
		System.out.println("Server Start:"+ss.getLocalPort());
		
		Thread thread = new Thread() {

			@Override
			public void run() {
				//쓰레드가 해야할일은 접속자를 받고 메세지를 하나 받기 위해 스트림을 준비하여
				//읽기 한 후 화면에 출력
				Socket s= null;//socket s는 접속자의 정보
				BufferedInputStream bis=null;
				//BufferedOutputStream bos=null;
				try {
					s=ss.accept();//접속자가 올 때 까지 대기!!
					
					//접속자의 IP알아내기
					//InetAddress ip= s.getInetAddress();//접속자의 ip얻어내기
					//String clientIp= ip.getHostAddress();//접속자의 IP
					String clientIP= s.getInetAddress().getHostAddress();//위와 똑같음
					
					//접속자가 보내오는 메세지를 받기위해 스트림 얻기
					bis= new BufferedInputStream(s.getInputStream());//buffered인풋스트림이니
																//원하는걸 얻을때 끼워넣음
					//bos = new BufferedOutputStream(s.getOutputStream());
					byte[] buf= new byte[2408];
					int size=-1;
					
					//문자열 쓸때 스트링 버퍼 사용 그이유는 문자열 편집때문에 ex)너무 큼
					StringBuffer sb= new StringBuffer(clientIP);
					sb.append(":");
					
					while((size=bis.read(buf))!=-1) {
						String str  = new String(buf, 0,size);
						sb.append(str);
					}
					//서버 콘솔창에 출력
					System.out.println(sb.toString());
					
					//클라이언트에 보낸다.
					//bos.write(sb.toString().getBytes());
					//bos.flush();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
		};//thread의 끝
		thread.start();//스레드 시작

	}

}
