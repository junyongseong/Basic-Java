package pm;

public class Ex7_String {

	public static void main(String[] args) {
		//문자열 객체 생성
		String str = "SiST";//str 이라는 변수에 SiST라는 문자열이 저장
							//암시적 객체 생성
		
		String str2 = new String("SiST");//str2라는 변수에
						// "Sist"라는 문자열이 저장-명시적 객체 생성
		if(str == str2)
			System.out.println("서로 주소가 같다");
		else
			System.out.println("서로 주소가다르다");

		
		if(str.equals(str2))
			System.out.println("서로 내용이 같다");//대소문자 구별안하면 IgnoreCase
		else
			System.out.println("서로 내용이 다르다");
		
		String str3 ="SiST";
			if(str == str3)
				System.out.println("서로 주소가 같다");
			else
				System.out.println("서로 주소가다르다");
			
		//문자열 즉 String객체는 생성법이 2가지로 나뉜다.
		// -명시적객체 생성법: new라는 키워드로 생성하며 무조건
					//무조건 새로운 객체를 생성하고 주소할당한다.
		// -암시적 객체 생성법 : 그냥 ""로 된 문자열을 저장하며
						//이는 앞서 같은 암시적생성법으로 같은 내용을
						//만든것이 있다면 기존것을 재사용한다.
			
		//그리고 정말 특이한 것은
		//자바의 String 객체는 불변적 특징을 가진다는 것이다.
	}
}
