package pm;

public class Ex4_Oper {

	public static void main(String[] args) {
		/*프로그램 시작
		 * 정수 10을 기억하는 v1이라는 변수를 만들자!
		 * 정수 7을 기어하는 v2라는 변수를 만들자! */
		long v1 = 10L;
		long v2 = 7L;
		
		long res = v1+v2;
		System.out.println("v1+v2 = "+ res); /*v1 + v2 = 17 
		더하기 연산이 아니라 문자열끼리 연결 
		+연산자는 피연산자들 중 하나라도 문자열이 있다면
		다른 피연산자 또한 복사하여 문자열로 변환되어 처리된다.*/
		System.out.printf("v1+v2 = %d\n", res); //v1 + v2 = 17
		
		
		/* 실수형 : float, double
		 * 자바에서는 소수점을 가지는 값들은
		기본적으로 double로 인식한다.
		그래서 float으로 인식시키기 위래 값뒤에 f,F를 붙인다.*/
		float f1 =3.14f;
		
		double d1 =2.1;
		
		/*나머지 값 구하기 : % 연산자
		 * f1 3.14를 d1 2.1로 나눴을때 나머지를 변수d2에 저장한다.*/
		double d2 =f1%d1;
		System.out.println("f1%d1 = "+d2);
	}

}
