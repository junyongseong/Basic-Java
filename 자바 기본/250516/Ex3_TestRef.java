package am;

public class Ex3_TestRef {
	//테스트 함수를 호출 하기 위해서는 반드시 인자를
	//Ex3_Member 객체의 주소를 넣어야 한다.
	//기본자료형이 아니면 무조건 주소를 넣어야함
	public void test(Ex3_Member n) {
		n.setName("쌍용교육센터");
		
	}//함수의 끝을 만나면 호출한곳으로 돌아간다. 이떄 
	// 지역 변수인 n은 소멸 된다.	
}
