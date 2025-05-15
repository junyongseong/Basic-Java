package am;

public class Ex1_Main {

	public static void main(String[] args) {
		// 원하는 객체 Ex1_Test를 생성하자
		Ex1_Test t1=new Ex1_Test();
		t1.setName("SiST");
		t1.setAge(30);
		
		Ex1_Test t2=new Ex1_Test("마루치", 17);
		t2.setName("아브라");//이런식으로도 가능
		Ex1_Test t3=new Ex1_Test("아바다", 19);
		
		System.out.printf("t1.name : %s t1.name : %d",t1.getName(),t1.getAge());
		System.out.println();
		System.out.printf("t2.name : %s t2.name : %d",t2.getName(),t2.getAge());
		System.out.println();

		System.out.printf("t3.name : %s t3.name : %d",t3.getName(),t3.getAge());
		
	}
}
