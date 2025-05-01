package am;

import java.util.Scanner;

public class Ex5_Oper {
	public static void main(String[] args) {
		
		/* 삼항 연산자(조건 연산자)
		 * [구성]
		 * (조건식) ? 참값:거짓값
		 * 조건이 맞으면 참값 반환, 거짓이면 거짓값 반환 */
		
		int a = 7;
		int b = 5;
		
		/*거짓값과 참값을 모두 저장할 수 있는 변수를 준비하고,
		 * 삼항 연산자는 반드시 조건을 수행하는 식이 존재해햐 함*/
		int res = (a>b)? 1: 0;
		System.out.println("res= " +res);
		
		Scanner scan =new Scanner(System.in);
		System.out.println("첫번째 값은:");
		a= scan.nextInt();
				
		System.out.println("두번째 값은:");
		b = scan.nextInt();
		
		String str =(a>=b)?"a가 크다":"b가 크다";
		System.out.println(str);
		
		//-------------------------------------//
		System.out.println("첫번째 값은:");
		int c= scan.nextInt();
		
		System.out.println("첫번째 값은:");
		int d= scan.nextInt();
		
		if(c>d)
			System.out.println("첫번째가 더커");
		else
			System.out.println("두번째가 더커");	}
}
