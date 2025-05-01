package am;

import java.util.Scanner;

public class Ex7_if {

	public static void main(String[] args) {
		int su =10 ;
		/* su의 값이 10 이상이면 화면에 "10점이상"
		 * 이라는 문자열을 출력하고자 한다.
		 * if문의 구성
		 * [구성]
		 * if(조건식)
		 * 	  조건식이 만족할 때 수행하는 문장
		 * */
		System.out.println("값을 입력하시오.");
		Scanner scan = new Scanner(System.in);
		su = scan.nextInt();
		if(su>=10) { //이 중괄호 = 브레이스 = 블럭
			System.out.println("10점이상");
			System.out.println("잘했어요");
		}//if의 끝
		else {
			System.out.println("10점 미만");
			System.out.println("못했어요");
		}
	}
}
