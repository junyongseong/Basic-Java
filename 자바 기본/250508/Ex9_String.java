package pm;

public class Ex9_String {

	public static void main(String[] args) {
		//"ABCDE"을 기억하는 변수 str을 만들자
		String str ="ABCDE";
		
		//문자열의 길이를 구하는 법
		int len=str.length();
		System.out.println("길이 : "+len);
		
		//str에서 특정 위치(index)에 있는 문자를 얻어내자
		
		char ch =str.charAt(1);//두번째 문자 얻기
		System.out.println("str.chatAt(1): "+ch);
		
		//str에서 "BC" 가 있는 위치(index)값을 알아내자
		int index = str.indexOf("BC");
		System.out.println("str.indexOf(\"BC\") : "+index);//  \(역슬래쉬는)뒤에 오는걸 문자화

		//str에서 앞서 얻어낸 indx로부터 3자를 추출하자!
		//str은 바꾸는게 아니라 새로 만들어줘야함
		String str2 = str.substring(index, index+3);
		System.out.println("str.substring(index, index+3): "+str2);

	}

}
