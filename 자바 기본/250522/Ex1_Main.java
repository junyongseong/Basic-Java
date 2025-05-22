package am;

public class Ex1_Main {

	public static void main(String[] args) {
		// 추상 클래스는 인터페이스와 같이 인스턴스를 직접 생성하지 못한다.
		//다시 말해서 추상클래스는 다른 클래스가 상속받아서 생성되는 것이다,
		//Ex1_Abs t1=new Ex1_Abs(); 오류
		EX1_Child c1= new EX1_Child();
		Ex1_Child2 c2= new Ex1_Child2();
		
		Ex1_Main m=new Ex1_Main();
		m.print(c1);
		m.print(c2);
	}
	
	public void print(Ex1_Abs n) {
		n.test();//test함수가 자식클래스에서 재정의가 반드시 되어있으므로
				//자식객체의 test가 호출된다.
	}

}
