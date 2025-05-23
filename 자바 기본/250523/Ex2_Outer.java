package am;

public class Ex2_Outer {

	private String msg = "쌍용교육센터";
	
	class Inner{//내부 클래스 : 장점은 바깥쪽 클래스의 멤버를 
				//자신의 것처럼 사용이 가능하다.
		int value=100;
		public void print() {
			System.out.println(msg+":"+value);
		}
	}
}
