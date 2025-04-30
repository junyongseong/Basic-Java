package pm;

import java.util.Scanner;

public class Ex9_Oper {
	public static void main(String[] args) {
		/*키보드로 부터 정수를 하나 받아 변수 v1에 저장한다.
		 * v1의 값이 20대인지? 아닌지 판단하는 프로그램을  구현하시오.*/
		
		System.out.println("값을 입력하시오: ");
		Scanner scan = new Scanner(System.in);
		int v1=scan.nextInt();
		
		System.out.println("입력한 값은 20대 인가?");
		boolean res = ((v1>20)) && ((v1<30));
		System.out.println(res);
	}
}
