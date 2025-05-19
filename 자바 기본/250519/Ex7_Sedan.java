package am;
//Ex7_Car로 부터 상속받은자식 클래스
public class Ex7_Sedan extends Ex7_Car {//super class에서 EX7_Car누름
	
	private boolean sunroof=true;//true :설치 O,false :설치 X

	public boolean isSunroof() {//boolean형은 게터 세터 만들면 is가 붙음
		return sunroof;
	}

	public void setSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

}
