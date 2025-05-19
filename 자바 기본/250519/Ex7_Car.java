package am;

//자동차를 의미하는 부모 클래스
public class Ex7_Car {
	private String model;//모델명
	int min_price;//최소가격
	private String type;//타입 : 소형세단, 중형세단,....,SUV,트럭
	
	//모델명을 변경하는 기능
	public void setModel(String n){
		this.model=n;
	}
	
	
	//최소가격을 반환하는 기능
	public int getMin_price() {
		return min_price;
	}

	//최소 가격을 변경하는 기능
	public void setMin_price(int m) {
		this.min_price=m;
	}
}
