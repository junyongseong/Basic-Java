package am;

import java.io.File;

public class Ex1_File {

	public static void main(String[] args) {
		// 프로그램 시작
		
		//자바에서 File 객체는
		//파일 뿐만 아니라 폴더(디렉토리)객체화 시키는 클래스다.
		//실제 존재하지 않는 파일과 폴더도 객체화 시킬 수 있다.
		//그래서 존재여부 확인을 exists()로 구분 할 수 있다.
		
		String path ="c:/mY_Study/test/util";//원하는 폴더의 경로 준비 대소문자 상관 X
		
		File f = new File(path);
		
		//현재 객체화 시킨 File객체가 실제 존재하는지 확인하자!
		if(f.exists()&&f.isDirectory()){//존재하고 디렉토리일때
			System.out.println("존재하는 폴더입니다.");
			
			//폴더일 경우에는 폴더안에 파일 또는 또다른 하위폴터가 있을 수 있다.
			//하위 목록들을 한번에 얻어낸다.
			/*String[] ar= f.list();//파일로부터 얻어야하니 f.
			for(int i=0;i<ar.length;i++)
				System.out.println(ar[i]);*/
			File[] ar=f.listFiles();
			System.out.println("하위 폴더들--------------------------");
			for(int i=0;i<ar.length;i++)
				if(ar[i].isDirectory()){//폴더만 출력
					//System.out.println(ar[i]);//문자열이 아니라 File객체다.
					System.out.println(ar[i].getName());//파일이름만 출력
				}
			
			System.out.println("하위 파일들--------------------------");
			for(int i=0;i<ar.length;i++)
				if(ar[i].isFile()){//파일만 출력
					System.out.printf("%s(%dkb)\n",ar[i].getName(),
							ar[i].length()/1024);
					//한번 1024로나누면 kb 두번 나누면 mb
					//System.out.println(ar[i].getName()+"("+ar[i].length()+")");//파일이름만 출력
				}
		}else
			System.out.println("존재 X Or 폴더 X");
	}

}
