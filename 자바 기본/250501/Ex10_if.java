package am;

import java.util.Scanner;

public class Ex10_if {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("점수를 입력하시오 : ");
		int score = scan.nextInt();
		
		if(score>100 || score<0) {
			System.out.println("범위를 초과하였습니다.");
			return; /*제어권 반환(호출한 곳으로 돌아간다. 
			즉 jvm으로 돌아감 함수로 돌아가는데 여기선 main 함수고
			고로 프로그램이 끝난다. if는 함수가 아닌 제어문
			*/
		}
		//score의 값이 100이하인 경우만 수행하는 곳
		if(score>=60)
			System.out.println("합격!");
		else
			System.out.println("재도전");
	}
}
