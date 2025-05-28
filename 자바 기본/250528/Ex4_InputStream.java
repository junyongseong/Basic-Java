package pm;

import java.io.File;
import java.io.FileInputStream;

public class Ex4_InputStream {

	public static void main(String[] args) {
		// 특정파일과 연결된 스트림 생성
		String path= "C:/My_Study/io_test/inputTest.txt";
		
		File f = new File(path);//경로로 파일객체 생성
		FileInputStream fis=null;
		try {			
			fis = new FileInputStream(f);
			int code = -1;
			while((code = fis.read())!=-1)
				System.out.write(code);//숫자가 안나옴?
				//System.out.println((char)code);// 한글 안나옴
		} catch (Exception e) {
			System.out.println("예외 발생: 파일이 있는지 확인하세요");
		}finally {
			try {
				fis.close();//사용된 스트림 닫기(수도배관 생각 썼으면 닫아줘야함_
				// 엄청 중요 *****
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
