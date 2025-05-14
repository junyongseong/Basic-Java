package pm;

import java.util.Scanner;

public class Ex3_Main {

	public static void main(String[] args) {
		
		Ex3_Gugudan a1= new Ex3_Gugudan();
		

		System.out.println("단을 입력하시오 : ");
		Scanner scan =new Scanner(System.in);
		int dan = scan.nextInt();

		a1.setDan(dan);//키보드로 받은 값을 구구단 객체 멤버변수에 저장한다.
		 
		//해당 단을 출력하는 기능을 호출
		a1.Printgugudan();

	}

}


