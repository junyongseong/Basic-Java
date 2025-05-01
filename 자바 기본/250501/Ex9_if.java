package am;

import java.util.Scanner;

public class Ex9_if {

	public static void main(String[] args) {
		/* 키보드로부터 점수(0~100)를 받아서
		 * 60점 이상이면 합격을 출력하고
		 * 그렇지 않으면 다시 도전을 출력하세요*/
		
		Scanner scan =new Scanner(System.in);
		System.out.println("점수를 입력하시오 : ");
		int score = scan.nextInt();
		/*
		if(score>=60 && score<=100)
			System.out.println("합격!");
		else if(score>100)
			System.out.println("범위를 초과하였습니다");
		else if(score>=50 && score<60)
			System.out.println("좀더 분발하세요");
		else
			System.out.println("다시 도전!");
		*/
		
		//먼저 score의 값이 100을 넘었는지? 확인하는 비교문
		if(score<=100) {
			//제어가 이 안에 들어오면 즉 score 의 최대값은 100이다.
			if(score>=60) {
				System.out.println("합격");
			}
			else
				System.out.println("다시 도전");
		}
		else
			System.out.println("범위를 초과하였습니다.");

		scan.close();
	}
}
