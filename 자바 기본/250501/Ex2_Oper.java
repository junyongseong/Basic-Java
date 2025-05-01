package am;

public class Ex2_Oper {
	public static void main(String[] args) {
		/* 증감연산자 : ++(1씩증가), --(1씩 감소)
		 * 정수 8을 기억하는 변수 a를 만들자! 	*/
		
		int a= 8;
		
		int b = ++a + 3; // a값은 9로변함 +3하기를 b에 저장 
		/*int a= 8;
		 *int b = a++ + 3;
		 *a=9, b=11*/
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		b= a++ +3;/* ++연산자가 변수 뒤에 있으면 우선순위가 가장 낮아서 
		제어가 다음행으로 이동할때 1 증가하게 된다. */
		
		System.out.println("a = "+a); //10
		System.out.println("b = "+b); //12
		
		System.out.println(a++);//10
		System.out.println(a); //11
	}
}
