package pm;

import java.util.Random;
import java.util.Scanner;

public class Ex8_Array {

	public static void main(String[] args) {

		int[] computer =new int[3];//컴퓨터가 가지는 배열
		int[] user=new int[3];//사용자가 입력하는 배열
		
		int strike_count;//이 변수가 3이되면 프로그램 종료 및 3 strike 출력
		int ball_count; //볼카운트
		int count=1; //시도 횟수
		System.out.println("숫자 야구 게임 시작!!");
		
		Scanner scan =new Scanner(System.in);//키보드 입력

		//로또에서 사용
		//컴퓨터가 저장하는 난수 3개, 중복 X
		for (int i = 0; i < computer.length; ) {
		    computer[i] = (int)(Math.random() * 9 + 1);
		    boolean duplicate = false;

		    for (int j = 0; j < i; j++) {
		        if (computer[i] == computer[j]) {
		            duplicate = true;
		            break;
		        }
		    }

		    if (!duplicate) {
		        i++; // 중복이 없을 때만 다음 인덱스로 이동
		    }
		}
		System.out.printf("%d %d %d",computer[0],computer[1],computer[2]);
		//사용자로부터 입력받기
		do {
			strike_count = 0;
			ball_count = 0;
			
			
			System.out.println("\n시도 횟수 : "+ count++);
			String str =scan.nextLine();
			for(int i=0;i<str.length();i++)
			{
				char ch=str.charAt(i);//입력받은값 ex)'1'-48=1 '5'-48=5
				user[i] = ch-48;//1이 코드값으로 49이므로 48을 뺴면 1이 user[i]에 저장됨
			}
			
			
			/*내가 한것
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
			}*/
			
			// 쌤이 한것
			//스트라이크 카운트 하는 반복문: 같은 자리의 값들만 반복
			for (int i = 0; i < computer.length; i++)
			{
				if(user[i]==computer[i])
					strike_count++;
			}
			//볼카운트하는 반복문
			for (int i = 0; i < computer.length; i++)
			{
				if(user[i]==computer[(i+1)%3])//한칸 뒤
					{ball_count++;
					}
				else if(user[i]==computer[(i+2)%3])//두칸 뒤
				{	ball_count++;
				}
					
			}
			System.out.printf("%d스트라이크 %d볼 입니다",strike_count,ball_count);
		}while(strike_count!=3);//스트라이크가 3이 아닐때까지 실행 3이면 나가짐
		
		System.out.println("\n 축하합니다!! 정답입니다.");
	}
}
