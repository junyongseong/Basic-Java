package am;

import java.util.Scanner;

public class Ex3_Main {

	public static void main(String[] args) {

		Ex3_Library L1 =new Ex3_Library();
		L1.setAr();//배열에 책 5권이 생성되어 채워짐
		
		Scanner scan =new Scanner(System.in);
		System.out.println("검색할 책을 입력하십시오 : ");
		String input = scan.nextLine();
		
		String booksearch =L1.search(input);
		
		if(booksearch.trim().length()<1)//트림하면 공백 제거이고 그길이가 1보다 작으면 
			System.out.println("검색된 정보가 없습니다.");
		else
			System.out.println(booksearch);
	}
}