package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Ex3_Writer {

	public static void main(String[] args) {
		PrintWriter pw=null;
		
		File selectedFile = new File("c:/my_study/test123.txt");
		//문자 기반의 출력 스트림
		try {
			 //pw = new PrintWriter("c:/my_study/test123.txt");
			//pw = new PrintWriter(selectedFile); 셋다 모두 가능
			pw= new PrintWriter(new FileOutputStream(selectedFile));
			pw.write("와 금요일이다.");
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pw!= null)
				pw.close();
		}
	}
}
