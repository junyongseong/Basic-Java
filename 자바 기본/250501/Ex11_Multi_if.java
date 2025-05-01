package pm;

import java.util.Scanner;

public class Ex11_Multi_if {
	public static void main(String[] args) {
		
		System.out.println("값 : ");
		Scanner scan = new Scanner(System.in);
		
		int value =scan.nextInt();
		/* 변수 value의 값이 1, 아니면 2,아니면 3이 들어간다고
		 * 가정했을때 1일때는 "초보" 출력
		 * 2일때 "중급" 출력하고
		 * 3일때 "고급" 출력을 하자
		 * 그 외는 "잘못 입력" 이라고 출력
		 * 위를 해결하기 위해서는 다중 if문을 구현해야 한다.
		 * [구성]
		 * if(조건식1)
		 * 		조건식 1을 만족하는 수행문;
		 * else if(조건식2)
		 * 		조선식 1에는 맞지않지만 조건식 2에는 만족하는 수행문
		 * else if(조건식3)
		 * 		조선식 1,2에는 맞지않지만 조건식 3에는 만족하는 수행문
		 * else 조건식 1,2,3 모두 만족하지 않는 경우
		 * */
		
		/*
		if(value==1) {
			System.out.println("초보");
		}
		else if(value==2) {
			System.out.println("중급");
			}
		else if(value==3) {
			System.out.println("고급");
		}
		else
			System.out.println("잘못 입력");
		*/
		
		String str = "";
		if(value == 1)
			str ="초급";
		else if(value == 2)
			str ="중급";
		else if(value == 3)
			str ="고급";
		else
			str ="잘못 입력";
		
		System.out.println(str);
		scan.close();
	}
}
