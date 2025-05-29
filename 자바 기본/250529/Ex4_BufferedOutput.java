package am;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex4_BufferedOutput {

	public static void main(String[] args) {
		// 파일 객체 준비
		File f = new File("c:/my_study/test/abc.txt") ;
		
		//파일이 존재하지 않을경우에는 그만하고 싶다면...
		if(!f.exists()) {
			return;
		}
		BufferedOutputStream bos=null;
		try {
			bos= new BufferedOutputStream(new FileOutputStream(f));
			
			Scanner scan = new Scanner(System.in);
			System.out.println("입력 :");
			String msg= scan.next();
			
			byte[] buf= msg.getBytes();
			
			bos.write(buf, 0, buf.length);
			bos.flush();//없애버림?
		} catch (Exception e) {
			e.printStackTrace();//예외 발생하면 안내
		}finally {
			try {
				if(bos !=null)
					bos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
