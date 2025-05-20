package am;

public class Ex2_Calss implements Ex2_Inter{//implements는 구현

	private int v1=10;
	
	@Override
	public int getValue() {
		// 반드시 구현하겠다고 명시한 인터페이스의
		//추상메서드 모두를 재정의 해야한다.
		return MAX_value+v1;
	}
	
	public void test() {
		System.out.printf("구현 객체의 v1 : %d",v1);
	}

}
