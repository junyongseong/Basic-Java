package am;

public class Ex6_For {

	public static void main(String[] args) {
		/**1~20까지 반복처리하는 반복문 구현
		 * 단, 3의배수만 출력해야한다.*/
		
		for(int su=1; su<=20;su++)
		{
			if(su%3==0)
				System.out.println(su+"*");
			else
				System.out.println(su);

		}
		
		/*System.out.println("--------");
		
		for(int su=3;su<=18;su+=3)
			System.out.println(su);
			실행은 되지만 20번 반복이 아님 6번
			*/
	}
}
