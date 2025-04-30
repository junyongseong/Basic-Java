package pm;

import java.util.Scanner;

public class Ex7_Oper {
	public static void main(String[] args) {
		
		//키보드로부터 정수를 받기 위해 필요한 객체
		Scanner scan = new Scanner(System.in);
		
		//정수를 받기전에 문자열 출력으로 표현
		System.out.println("정수 입력: ");
		
		//키보드와 연결된 스캐너로부터 정수를 하나 받아서 
		//변수 v1에 저장하자.
		long v1 = scan.nextLong();
		
		/*입력 받은 값이 10대(10~19)인지 맞다면 true 
		 * 그렇지 않다면 false
		 * 위와 같은 결과는 v1을 두번 비교해야 한다.
		 * v1이 10보다 크거나 같고 
		 * v1이 20보다 작다면 true! 이럴때 논리 연산자를 같이 써야함
		 * 논리 연산자 :
		 * -&& : AND의 의미
		 * - ||는 OR의 의미*/
		
		//&&연산자는 왼쪽(v1 >=10)이 맞아야 오른쪽도 수행함 틀리면 수행 X
		boolean res= (v1 >=10)&&(v1<20); 
		System.out.println("v1의 값이 10대 인가?\n"+res);
	}
}
