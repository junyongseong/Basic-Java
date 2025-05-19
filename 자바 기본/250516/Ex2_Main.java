package am;

public class Ex2_Main {

	public static void main(String[] args) {
		// 원하는 객체 생성
		Ex2_Reference b =new Ex2_Reference();
		
		int[] ar= new int[3];
		ar[0]=100;
		ar[1]=200;
		ar[2]=300;

		//b객체가 가지는 test함수를 호출하면서
		//인자로 ar을 전달하자!
		
		b.test(ar);
		System.out.printf("%d, %d, %d",ar[0],ar[1],ar[2]);//101,200,300
	}

}
