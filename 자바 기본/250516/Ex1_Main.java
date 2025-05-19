package am;

public class Ex1_Main {

	public static void main(String[] args) {
		//원하는 객체 생성
		Ex1_Value a= new Ex1_Value();
		//인자로 전달할 값
		int value=100;
		
		System.out.println(value);
		a.test(value);//a객체에서 test가 호출되고 value값이 전달 받음
					//하지만 지역변수니 불러도 의미가 없음
		System.out.println(value);

	}

}
