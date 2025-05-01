package pm;

import java.util.Scanner;

public class Ex13_if {
	public static void main(String[] args) {
		/* 키보드로부터 점수를 하나 받아 score에 저장한다.(0~100)
		   점수가 80~100이면 우수
		   60~79점이면 보통
		   40~59점이면 좀 걱정
		   그 이하는 나오지 마
		 */
		
		Scanner scan =new Scanner(System.in);
		System.out.println("점수를 하나 입력하시오 : ");
		int score =scan.nextInt();
		
		//유효하지 않은 값들 걸러내기
		if(score>100 || score<0)
		{
			System.out.println("범위를 벗어났습니다.");
			return;
		}
		//제어가 여기에 왔을 때는 score의 최대 값은 100이다.
		else if(score>=80)
		{
			System.out.println("우수");
		}
		else if(score>=60)
		{
			System.out.println("보통");
		}
		else if(score>=40)
		{
			System.out.println("좀 걱정");
		}
		else
			System.out.println("나오지마");
	}
}
