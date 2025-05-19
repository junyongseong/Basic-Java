package am;

public class Ex5_Varargs {
	//Varargs의 개념
	public void test(int ...n) {
		System.out.println("Varargs 개념의 지역변수(n)는 배열개념이 된다.");
		System.out.println(n.length);//그냥 변수면 length사용 불가 
		
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
	}
}
