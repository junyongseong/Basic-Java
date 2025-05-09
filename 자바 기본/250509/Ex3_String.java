package am;

public class Ex3_String {

	public static void main(String[] args) {
		String str="안녕하세요! 금요일이군요.";
		
		int size =str.length();
		System.out.println("문자열의 길이 : "+size);
		
		//str이 기억하고 있는 문자열에서 "하"가있는 위치
		//index값(정수)를 알아내자
		int strindex = str.indexOf("하");
		System.out.println("str.indexOf(\"하\") : "+strindex);
		
		//"요"의 위치를 찾아보자!
		strindex = str.indexOf("요");
		System.out.println("str.indexOf(\"요\") : "+strindex);
		
		//찾은 "요"이후에 있는 "요"를 검색하자
		int strindex2 = str.indexOf("요",strindex+1);
		System.out.println("str.IndexOf(\"요\") : "+strindex2);
		
		//검색을 뒤에서부터 시작한다.
		int strindex4 = str.lastIndexOf("요");
		System.out.println("str.lastIndexOf(\"요\") : "+strindex4);
		
		System.out.println("==========================");
		
		String file_name =" Ex1.java ";//외부에서 인자를 받았다고 가정하고
							//내용은 모른다고 생각하자
							//받은 파일이 자바파일 또는 텍스트파일인지?판단하자
		
		if(file_name.trim().endsWith(".java")||file_name.trim().endsWith(".txt"))
		{
			System.out.println("자바 또는 텍스트 파일입니다.");
		}
		else
			System.out.println("처리할 수 없습니다.");
		
		//trim을 이용해 공백제거한 값
		String t_fname=file_name.trim();
		if(t_fname.endsWith(".java")||t_fname.endsWith(".txt"))
		{
			System.out.println("자바 또는 텍스트 파일입니다.");
		}
		else
			System.out.println("처리할 수 없습니다.");
		
		//a를 찾아서 *로 변경하자!
		String ss = t_fname.replaceAll("a", "*");
		System.out.println(ss);
	}
}
