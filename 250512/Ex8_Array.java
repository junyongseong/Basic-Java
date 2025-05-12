package pm;

import java.util.Random;
import java.util.Scanner;

public class Ex8_Array {

	public static void main(String[] args) {

		int[] computer =new int[3];
		int[] user=new int[3];
		
		int strike_count;//이 변수가 3이되면 프로그램 종료 및 3 strike 출력
		int ball_count; //볼카운트
		int count=1; //시도 횟수
		System.out.println("숫자 야구 게임 시작!!");
		
		Scanner scan =new Scanner(System.in);

		//컴퓨터가 가지는 수를 정하는 반복문 중복되면 안됨
		for(int i=0;i<computer.length;i++) {
			computer[i]=(int)(Math.random()*9+1);
			boolean check =true;//맞는지 아닌지 체크하는 불린 함수
			for(int j=0; j<i;j++)
			{
				if(computer[i]==computer[j]) {
					check=false;
					break;
				}
			}
			if(check)
				i++;
		}
		//사용자로부터 입력받기
		do {
			System.out.println("\n시도 횟수 : "+ count++);
			String str =scan.nextLine();
			for(int i=0;i<str.length();i++)
			{
				char ch=str.charAt(i);
				user[i] = ch-48;//1이 코드값으로 49이므로 48을 뺴면 1이 user[i]에 저장됨
			}
			
			strike_count = 0;
			ball_count = 0;

			//먼저 스트라이크카운트 하는 반복문
			for (int i = 0; i < 3; i++) {
				if (user[i] == computer[i]) {
					strike_count++;
				}
				//볼 카운트하는 반복문
				 else {
					for (int j = 0; j < 3; j++) {
						if (i!=j && user[i] == computer[j]) {
							ball_count++;
							break;
						}
					}
				}
			}
			System.out.printf("%d스트라이크 %d볼 입니다",strike_count,ball_count);
		}while(strike_count!=3);//스트라이크가 3이아닐때까지 실행 3이면 나가짐
		
		System.out.println("\n 축하합니다!! 정답입니다.");
	}
}
