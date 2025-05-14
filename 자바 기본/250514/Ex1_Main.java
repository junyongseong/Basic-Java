package am;

public class Ex1_Main {

	public static void main(String[] args) {
		
		// 자동차 객체를 만들어보자
		Ex1_Car c1=new Ex1_Car();
		
		System.out.println(c1.getModel()); //객체에서 저장한 자동차 모델명
		c1.setModel("CLS");//set모델로 값을 넣어줌
		
		System.out.println(c1.getModel());
		
		//새로운 자동차 생성 c1 != c2
		Ex1_Car c2= new Ex1_Car();
		c2.setModel("군두운");
		System.out.println(c2.getModel());
	}

}
