package am;

public class Ex1_Parent {
	
	int value;
	
	public Ex1_Parent(int n) {//생성자
		this.value=n;
	}	
	public void myData() {
		System.out.println("Parent myData");
		}
	
	public int getValue() {
		return value;
		}
	
}
