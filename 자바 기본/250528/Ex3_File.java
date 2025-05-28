package pm;

import java.io.File;

public class Ex3_File {

	public static void main(String[] args) {
		// 프로그램 시작
		String path="C:/my_study/io_test/sist";
		//현재 io_test와 sist폴더는 존재 X
		
		File f = new File(path);
		
		//파일 객체는 실제 존재하지 않아도 객체를 생성하는데 문제가 없다.
		//존재여부 확인
		if(!f.exists()) {
			f.mkdirs();//make directory 여러개일땐 s
			System.out.println("프로그램 종료");
		}

	}

}
