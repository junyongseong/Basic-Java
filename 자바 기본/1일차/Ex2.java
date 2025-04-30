package am;

public class Ex2 {
	public static void main(String[] args)
	{
		/*변수 선언 
		 * 변수는 자료형을 알아야 한다.
		 * -자바에서는 자료형을 크게 2가지로 나눠진다.
		 * -1) 기본 자료형 , 2) 객체(참조) 자료형 
		 * boolean[참(true),거짓(false)]
		 */
		boolean b1 = true;// 변수 선언 true는 예약어 c언어와 다르게 숫자 불가
		boolean b2 = false;
		
		System.out.println(b1); // ln은 줄바꿈 c언어에서 \n과 같음
		System.out.println(b2);
		
		/* char : 하나의 문자를 기억하는 자료형 문자는 홑따옴표로 구분함
		 * cahr은 문자 자료형*/
		char b3 ='A';
		System.out.println(b3);
		b3 = 'B'; 
		/* 이미 위에서 문자 자료형 char가 b3변수 선언, 
		 * 따라서 한번더 선언할필요없이 b3= 로 진행*/
		System.out.println(b3);
		
		/* 정수형 변수 선언 : byte(127까지 가능 -도 가능),
		 * short(약 30,000 음수도 O), int(21억 음수도 O),
		 * long(제일 큼)*/
		
		byte b4 = 127;
		b4=-128;//-129면 오류
		// byte b5 = 128; 주석 지우면 오류
		
		short b5 =32767;
		
		int b6 = 2100000000;//2147383600
		System.out.println(b5+b6);// b5+b6 후 출력
		
		long b7 = 2100000000000L;//long 형은 뒤에 소문자 l 혹은 대문자 L을 붙인다.
	}
}
