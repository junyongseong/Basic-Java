package am;

public class Ex1_Color {
	
	//속성 즉 색상을 저장하는 변수 ==멤버 필드(멤버 변수)
	private String color;
	
	//색을 구한다 set_color 사용, 만약 반대로 반환해야하면 get
	//외부에서 값을 구해서 color에 저장하는게 목적, color가 String형이니 괄호안은 String형
	
	//기능 : 멤버 메서드(함수)
	//색상을 의미하는 문자열을 하나 인자로 받아서 color라는
	//멤버 필드에 저장하는 기능 :set_Color
	public void set_Color(String args)//괄호 안에 있는게 인자 
	{
		//받은 인자를 color라는 변수에 저장한다.
		color =args;
	}
	//color의 값을 반환해주는게 목적
	public String getColor()
	{
		//호출한 곳으로 멤버필드 color의 값을 반환(return)한다.
		return color;
	}
}//클래스 영역