package am;

public class Ex3_Class implements Ex2_Inter, Ex3_Inter {

	private int value =100;
	
	@Override
	public void print() {
		System.out.println("Ex3_Class의 print");
	}

	@Override
	public void testValue() {
		System.out.println("Ex3_Class의 testValue");

	}

	@Override
	public int getValue() {
		return value;
	}
	//현재 객체가 가지는 독단적 기능들
	public void myTest() {
		System.out.println("Ex3_Class의 myTest");
	}
}
