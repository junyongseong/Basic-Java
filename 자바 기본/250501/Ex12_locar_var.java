package pm;

import java.util.Scanner;

public class Ex12_locar_var {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("값 : ");
		int v1 = scan.nextInt();
		String str ="";
		/*
		if(v1>=60)
		{//if문의 영역,하나의 지역
			String str ="합격"; //if 문 영역의 지역변수
			System.out.println(str);
		}
		else {
			// str ="재도전" <-위에서 쓴 str 변수가 지역변수라 불가능
			String str = "재도전"; //이렇게 자료형을 넣어서 사용
			//else 영역의 지역변수 이런 지역변수는 해당 지역을 벗어나면 소멸
			System.out.println(str);
		}*/
		
		if(v1>=60)
		{
			str ="합격";
			System.out.println(str);
		}
		else {
			str = "재도전";
			System.out.println(str);
		}
		scan.close();
	}
}
