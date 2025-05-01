package am;

public class Ex1_Oper {

	public static void main(String[] args) {
		/* 정수 13을 기억하는 변수 a를 만들자!*/
		
		int a= 13;
		// 정수 7을 기억하는 변수 b를 만들자!
		int b = 7;
		
		int c = a&b;//비트 연산자의 논리곱이다.
		/* a는 int형 4바이트 즉 32비트 -> 0000 .... 1101 = 13
		 * b도 int형 4바이트 즉 32비트 -> 0000 .... 0111 = 7
		 * 							--------------------
		 * 논리곱은 둘다 1일때만 ok 즉		 0000 .... 0101 = 5
		 * */
		
		//int c = a|b; 실행시 15
		System.out.println("c = "+c);
	}
}
