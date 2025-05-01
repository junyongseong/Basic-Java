package am;

public class Ex4_Char {
	public static void main(String[] args) {
		char c= 'B';
		System.out.println("c = "+c);
		/*자바의 char형은 2byte이며 내부적으로는
		 * 유니코드값(숫자)로 처리된다. 즉 'B' =>66*/
		
		++c;
		System.out.println("c = "+c);
		
		int ch = 97;
		System.out.println("ch = "+ch);
		//형변환
		System.out.println("ch = "+(char)ch);


	}
}
