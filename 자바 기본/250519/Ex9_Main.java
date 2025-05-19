package pm;

public class Ex9_Main {
	
	public void test(Ex9_Parent p) {
		System.out.println(p.getValue());
	}

	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex9_Child1 c1 = new Ex9_Child1();
		Ex9_Child2 c2 = new Ex9_Child2();
		Ex9_Parent p =new Ex9_Parent();
		
		//5번행에 있는 test 함수를 호출하기 위해 현재 Ex9_Main 객체 생성
		Ex9_Main m =new Ex9_Main();
		m.test(c1);//child0 0
		m.test(c2);//child2 10
		//100이 아닌 0 10 이 호출되는 이유는 
		//자식 클래스에서 value 를 재정의 했기 때문에 부모껄 숨김
		m.test(p);//부모꺼 100
	}
}