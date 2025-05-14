package am;

public class Ex1_Car {
	//자동차 모델명, 제조사, 배기량(cc), 보험가입여부,마지막 정비일
	//여기서 모델명과 배기량은 값이 바뀌지 않으니 final 을 쓰고 값을 넣어줘야함
	private String model="BMW X7"; //모델명
	private String comp;//제조사
	private final int cc = 2998;//배기량
	private boolean insurance; //보험
	private String last_repair;//마지막 정비일
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	
	public String getLast_repair() {
		return last_repair;
	}
	public void setLast_repair(String last_repair) {
		this.last_repair = last_repair;
	}
	
	public String getModel() {
		return model;
	}
	public int getCc() {
		return cc;
	}
	
	
}
