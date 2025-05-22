package am;

public class EX1_Child extends Ex1_Abs {

	String msg="쌍용교육센터";
	
	@Override
	public void test() {
		// 부모 클래스인 추상클래스가 가지는 추상메서드를 재정의
		int v =getV100();
		System.out.printf("부모의 값: %d\r\n",v);
	}
	public String getMsg() {
		return msg;
	}

}
