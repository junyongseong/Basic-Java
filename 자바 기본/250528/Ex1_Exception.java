package am;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1_Exception {

	public static void main(String[] args) {
		// 프로그램 시작
		int v1=100;
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력:");
		
		int v2= scan.nextInt();
		try {
		int res =v1/v2;
		if(v2==1)
			return;
		System.out.printf("%d / %d = %d",v1,v2,res);
		}catch(ArithmeticException e){
			v2=1;
			int res=v1/v2;
			System.out.printf("%d / %d = %d",v1,v2,res);
		}catch(Exception e) {
			//혹시나 다른 예외가 발생할 경우를 우려한 영역
			System.out.println("혹시나");
			
			
		}finally {//예외발생 여부에 대해 상관없이 무조건 수행
			System.out.println("\nfinally");
		}
		System.out.println("프로그램 끝");
	}

}
