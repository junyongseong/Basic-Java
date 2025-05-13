package am;

import java.util.Scanner;

public class Ex1_Main {

	public static void main(String[] args) {

		//키보드로 부터 컬러 문자열을 받는다.
		System.out.println("색을 입력 : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		//Ex1_Color라는 객체가 필요하다고 가정하자. 그러면 가져와서 생성해야함
		//가져오는 방법 : 다 칠 필요 없이 대충 입력후 ctrl+space
		//우리가 만든 클래스 자료형 같은 느낌
		Ex1_Color c1 = new Ex1_Color();
		
		//생성된 객체가 가지는 color라는 변수를 출력하자
		//System.out.println(c1.color);//private 함수를 못가져와서 오류
		
		//c1이 가지고 있는 color의 값을 반환하는 동작을 호출하자!
		String s1 = c1.getColor();
		System.out.println(s1);//null 사용할수 없는값
		
		//키보드로 받은 색상 문자열을 setColor을 호출하면서 인자로 넣어준다.
		c1.set_Color(str); //color에 있는 null값이 없어지고 지금 들어가는값으로 대입
		System.out.println(str); //str의 값이 출력되어야 한다. 아래와 똑같음
		System.out.println(c1.getColor()); //c1.getColor()의 값이 출력되어야 한다.
		
	}

}
