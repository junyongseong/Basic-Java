package am;

import java.util.Scanner;

public class Ex8_For {

	public static void main(String[] args) {
		/** 문제 1) 키보드로부터 숫자를 하나 받아서 변수 v1에 저장한 후
		 * 1부터 v1인 만큼 반복하여 합을 구하는 프로그램 구현하기
		 * */
		
		System.out.println("숫자 하나를 입력하시오 : ");
		Scanner scan= new Scanner(System.in);
		int v1=scan.nextInt();
		int sum=0;
		for(int i=1;i<=v1;i++)
		{
			sum +=i;
		}
		
		System.out.println("숫자의 합은 : "+sum);
		
		
		/** 문제 2) 10~50까지의 수들 중 난수를 하나 발생하여
		 * 변수 su 에 저장한 후 1부터 su인 만큼 반복하여
		 * 합을 구하시오
		 * */
		int su=(int)(Math.random()*41+10);
		sum=0;
		for(int i=1;i<=su; i++)
		{
			sum+=i;
		}
		System.out.println("숫자는 : "+su);
		System.out.println("1부터"+su+ "까지의 합은 : "+sum);

	}

}
