package am;

public class Ex1_Test {
	
	//멤버변수
	private String name;
	private int age;
	
	//생성자는 반드시 접근 제한자가 있어야하며, 반환형은 명시하지 않는다.
	//이름은 반드시 클래스명과 같아야한다.
	public Ex1_Test(String name,int age) { //필요한것을 인자로 정확하게 명시
		//받은 인자들을 멤버필드에 저장 -인자들은 모두 지역변수
		this.name=name;	//지역변수와 멤버필드의 이름이 같으면
		this.age=age;	//지역변수가 우선이니 멤버필드를 this로 지칭
		
	}//생성자의 끝
	
	public Ex1_Test(){//기본 생성자
		
	}
	
	//게터는 반환
	//세터는 값저장
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
