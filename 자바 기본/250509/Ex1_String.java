package am;

import java.util.Scanner;

public class Ex1_String {

	public static void main(String[] args) {
		//물류센터에서 각 제품의 제품 번호를 읽어온다.
		//이 상황을 키보드로 입력 받는 것으로 하자!
		
		System.out.println("코드 : ");
		Scanner scan =new Scanner(System.in);
		
		//제품 번호 형식 :  제조날짜-카테고리-유형코드
					//	250509-L-120
		String ItemNumber = scan.nextLine();
		
		//입력된 제품번호의 8번째 자리의 문자를 얻어내어
		//그것이 'L' 이면 "생활용품",'E'면 가전제품,
		//S면 스포츠용품으로 구분하자
				
		System.out.print("제품번호는 ");
		System.out.println(ItemNumber+".");
		
		if(ItemNumber.length()<8)
		{
			System.out.println("짧아");
			return;
		}
		
		char ch =ItemNumber.charAt(7);//8번째 문자 얻기

		switch(ch)
		{
		case 'L':
			System.out.print("생활용품입니다.");
			break;
		case 'E':
			System.out.print("가전제품입니다.");
			break;
		case 'S':
			System.out.print("스포츠용품입니다.");
			break;
		}
	}

}
