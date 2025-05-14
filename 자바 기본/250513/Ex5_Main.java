package pm;

import java.util.Scanner;

public class Ex5_Main {

	public static void main(String[] args) {

		Scanner scan =new Scanner(System.in);
		System.out.println("단 : ");
		int dan =scan.nextInt();//키보드로부터 정수 하나 받기
		
		//구구단의 값을 받기 위해 필요한 객체 생성
		Ex5_Gugudan gu = new Ex5_Gugudan();
		
		//키보드로부터 입력받은 단의 값을 Ex5_Gugudan에게 전달해야함
		gu.setDan(dan);
		
		//해당 구구단의 결과를 문자열로 받는다.
		String str = gu.result();//string형으로 받아야함
		System.out.println(str.replace("*", "X"));//데이터 가공
	}

}
