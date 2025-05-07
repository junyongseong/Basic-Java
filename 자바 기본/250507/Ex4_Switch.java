package am;

public class Ex4_Switch {

	public static void main(String[] args) {
		/**문제) 1~20까지의 수들 중 난수를 받아 변수 su에 저장
		 * su의 값이 짝수인지 홀수인지를 판단하는 프로그램을
		 * switch문으로 구현하시오!*/
		
		int su=(int)(Math.random()*20+1);
		
		switch(su)
		{
		case 2,4,6,8,10,12,14,16,18,20:
			System.out.println(su+ "은 짝수입니다.");
			break;
		case 1,3,5,7,9,11,13,15,17,19:
			System.out.println(su+ "은 홀수입니다.");
			break;
		}
		
		switch(su%2)//su%2는 조건식이 아닌 조건값임 따라서 만족
		{
		case 0:
			System.out.println(su+ "은 짝수입니다.");
			break;
		case 1:
			System.out.println(su+ "은 홀수입니다.");
		}
	}
}
