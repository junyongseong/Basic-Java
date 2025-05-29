package am;

import java.io.File;
import java.io.FileOutputStream;

public class Ex3_FileOutput {

	public static void main(String[] args) {
		// 파일에 저장할 문자열
		String str ="Test입니다.-파일에 저장할 문자열 12345";
		
		File f = new File("c:/my_study/test/abc.txt") ;
		
		FileOutputStream fos=null;
		
		try {
			fos = new FileOutputStream(f);
			
			byte[] ar = str.getBytes();
			
			fos.write(ar, 0, ar.length);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)
					fos.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			} 
		}
	}
}
