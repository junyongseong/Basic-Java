package am;

public interface Ex2_Inter {//class가 아닌 interface로 생성
	//상수와 추상메서드만 정의
	//final은 변수, 메서드, 클래스 앞에 붙일 수 있다. 
	final int MAX_value=100;//상수는 이름을 모두 대문자로 표기한다.
	
	//추상 메서드는 일반 메서드와 달리 body를 가지지 못한다.{ }이 부분이 바디
	public int getValue(); //일부로 미완성, 다음에 쓰는 사람이 재정의 해서 써라
	
}
