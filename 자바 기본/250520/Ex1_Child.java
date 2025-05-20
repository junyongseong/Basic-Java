package am;

public class Ex1_Child extends Ex1_Parent {

	public Ex1_Child() {
		super(10);//첫 라인에는 super가 숨겨져 있어서 parent 인트형으로 넣어줌
	}
	public Ex1_Child(int n) {
		super(n);
	}
	
	@Override//재정의 명시
	public void myData() {
		System.out.println("Child myData");
	}
	
}
