package am;

public class Ex4_Break {

	public static void main(String[] args) {
		//문자열(String)을 기억하는 str이라는 변수 선언
		
		String str="10023523";
		//str이 기억하는 문자열의 길이만큼 반복문을 수행하자.
		
		int i=0;
		while(i<str.length())
		{
			char ch = str.charAt(i);
			
			//얻어낸 값이 5 이상이면 탈출
			if(ch>='5') //ch는 문자이므로 5가 아니라 '5'이렇게 문자로 바꿔줌
				break;
			System.out.printf("%-2c",ch);
			i++;
		}
	}
}
