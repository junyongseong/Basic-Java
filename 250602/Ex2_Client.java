package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Client {

	public static void main(String[] args) {
		//일단 서버로 보낼 메세지를 스캐너를 통해 받는다.
		Scanner scan = new Scanner(System.in);
		System.out.println("보낼 메세지:");
		String msg= scan.nextLine();
		try {
			//서버 접속
			Socket s = new Socket("192.168.10.114",5555);
			
			//서버로 메세지를 보내기 위한 스트림 생성(나의 분신과 연결됨) outputstream
			BufferedOutputStream bos= new BufferedOutputStream(s.getOutputStream());
			/*BufferedInputStream bis =new BufferedInputStream(s.getInputStream());
			
			//서버로 메세지를 보낸다.
			
			bis.read();
			int size= -1;
			byte[] buf= new byte[2048];
			StringBuffer sb= new StringBuffer();
			while((size=bis.read(buf))!=-1) {
				String str= new String(buf,0,size);
				sb.append(str);
			}
			System.out.println(sb.toString());*/
			bos.write(msg.getBytes());
			bos.flush();
			//접속을 끊을때는 스트림부터 닫는다.
			bos.close();
			s.close();//소켓 닫기
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

}
