package am;

import java.util.Scanner;

public class Ex5_Break {

	public static void main(String[] args) {
		//문자열을 기억하는 변수 str을 선언하자!
		
		String str="";
		
		//키보드와 연결된 스캐너 준비
		Scanner scan = new Scanner(System.in);
		//기본자료형 정수형(int)문자형(char), 참 거짓(boolean), 실수(float,double)
		//String, Scanner 처럼 대문자로 시작하는 자료형은 객체 자료형
		
		System.out.println("문자열을 입력하시오 : ");
		//키보드로부터 문자열을 받아서 str에 저장하자!
		str=scan.nextLine();
		System.out.println("입력한 문자열 : "+str);
		
		//사용자가 키보드로 입력한 모든 값들이 하나의 문자열로 만들어져서 
		//변수str에 저장되어있는 상태 이때
		//str에 있는 문자열을 한자씩 얻어내어 출력하는 반복문을 만들자!
		
		int i=0;
		bk1:while(i<str.length()) //bk가 아니라 ab이런식으로 원하는대로
		{
			char ch = str.charAt(i);
			
			System.out.printf("%-2d 번째 문자열 : ",i+1);
			System.out.printf("%-2c",ch);
			//만약에 문자가 '0'과 같은 것을 만나면 반복문을 탈출하여라
			/*if(ch == '0'){
				break;
			}*/
			System.out.println();
			
		
			switch(ch) {
			case '0':
				System.out.println("0이네");
				break bk1;
			}//반복문을 탈출하지 못하고 switch 문만 탈출
			//하지만 레이블 기법으로 라인 27,41 bk1처럼 하면 탈출 가능
			
			i++;			
		}
	}
}
