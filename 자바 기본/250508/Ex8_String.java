package pm;

public class Ex8_String {

	public static void main(String[] args) {
		//자바의 String 객체는 불변적 특징을 가졌다.
		
		String str ="SiST";
		String str2 ="SiST"; //객체는 한개 만들어진것= 암시적객체이기 때문
		
		
		//str3 = str.concat("1234"); 이건 변하지 않음 String은 불변의법칙
		
		String str3 = str.concat("1234");//기존의 str이 기억하고 있는 값 뒤에
							//"1234"를 붙여준다. concat은 문자열을 연결
		
		System.out.println(str);
		System.out.println(str3);
		
		if(str==str3)
			System.out.println("주소가 같다.");
		else
			System.out.println("주소가 다르다.");
	}
}
