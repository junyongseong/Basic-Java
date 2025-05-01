package am;

import java.util.Scanner;

public class Ex8_if {
	public static void main(String[] args) {
		int a;
		
		System.out.println("나이를 입력하시오 : ");
		Scanner scan = new Scanner(System.in);
		a= scan.nextInt();
		
		if(a>=20 && a<30)
				System.out.println("20대입니다.");
		else
			System.out.println("20대가 아닙니다.");
	}
}
