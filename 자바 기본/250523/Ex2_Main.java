package am;

public class Ex2_Main {

	public static void main(String[] args) {
		// 내부클래스 생성 -반드시 바깥쪽 클래스를 거쳐야 한다.
		//Ex2_Outer.Inner inner =new Ex2_Outer().new Inner();
		
		Ex2_Outer outer= new Ex2_Outer();
		Ex2_Outer.Inner inner = outer.new Inner();
		
		inner.print();
	}

}
