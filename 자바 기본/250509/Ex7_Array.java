package pm;

import java.util.Scanner;

public class Ex7_Array {

	public static void main(String[] args) {
		//각 월의 마지막 날을 저장한 배열 - 선언 생성 초기화를 한번에 한것
		int[] month_array = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		//키보드로 월을 입력 받아 해당 월이 며칠까지 있는지 출력해보자
		Scanner scan = new Scanner(System.in);
		String cmd="n";

		do {
			//월 입력을 유도하자!
			System.out.println("월 입력(1~12) : ");
			int month=scan.nextInt();
			
			System.out.printf("%-2d월은 %d일까지입니다.\n",month,month_array[month-1]);
			//숫자는 month에 들어갔지만 아직 엔터값은 스캐너에 남아있음
			scan.nextLine();//엔터값 처리
			System.out.println("\n계속 하시겠습니까?(y/n) ");
			
			cmd=scan.nextLine();

		}while(!cmd.equalsIgnoreCase("n")); //n이 아닐 때 반복수행
		
		System.out.println("프로그램 종료 ");
	}

}
