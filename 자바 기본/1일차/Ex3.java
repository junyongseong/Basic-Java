package pm;

public class Ex3 {

	public static void main(String[] args) {
		/* 프로그램 시작
		 * int형 미만(byte, short)- 32비트 미만들 끼리 연산하면
		 * 32비트로 자동 승격(promotion)이 일어남 무조건 int로 변함
		 */
		byte b1 = 10;
		byte b2 = 7;
		// b1과 b2를 더하여 새로운 변수 b3에 저장한다.
		// byte b3= b1 + b2;
		int b3 = b1 + b2;
		System.out.println(b3);
		
		/*승격된 자료형을 강제로 형변환 시키는법(CASTING)*/
		
		byte b4 =(byte)(b1+b2);
		
		int a1=2100000000;
		int a2=2000000000;
		System.out.println(b3);
		
		/*
		int a3 = a1+a2;
		System.out.println(a3);*/
		
		//long에서는 a1+a2에 괄호 필요 없음 넣으면 오류남
		long a3=(long)a1+a2;
		System.out.println(a3);
	}

}
