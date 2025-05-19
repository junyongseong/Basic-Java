package pm;

public class Ex9_Child1 extends Ex9_Parent {
	
	private String msg = "Child1";
	//자식이 재정의 하면 부모건 숨겨버림 우선순위는 자식이가진 변수
	private int value;//0
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getValue() {
		return value;//부모의 value가 아닌 자신의 value를 반환
	}
	public void setValue(int value) {
		this.value = value;
	}
}
