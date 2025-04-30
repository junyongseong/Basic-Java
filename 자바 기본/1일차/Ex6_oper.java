package pm;
import java.util.Scanner;

public class Ex6_oper {
	public static void main(String[] args) {
		/*비교연산자
		 * > : 크다
		 * < : 작다
		 * >= : 크거나 같다
		 * <= : 작거나 같다
		 * != : 같지 않다
		 * == : 같다*/
		//키보드와 연결된 스캐너 객체를 만들자
		int a = 10;
		//자료형인것처럼 Scanner을 새롭게 만든다 system.in으로 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("값1 : ");
		a = scan.nextInt();//키보드로 부터 정수 하나를 받기 위해 대기한다.
		
		System.out.println("값2 : ");
		int b =scan.nextInt();
		
		System.out.println("당신이 입력한 값1 :"+a);		
		System.out.println("당신이 입력한 값2 :"+b);
		
		System.out.println(a>b);
		System.out.println(a != b); //같지 않다면 true
		System.out.println(a == b); //같다면 true
	}
}
