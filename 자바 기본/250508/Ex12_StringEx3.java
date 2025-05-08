package pm;

public class Ex12_StringEx3 {

	public static void main(String[] args) {
		int count=0;
		String msg = ++count +"little, "+ ++count +  //암시적 객체 생성이 반복적으로 일어남
				"little, " + ++count + "little Indian";
		System.out.println(msg);
	}

}
