package am;

public class Ex7_Main {

	public static void main(String[] args) {
		//원하는 세단 클래스를 생성한다.
		Ex7_Sedan gr1 = new Ex7_Sedan();//그랜저 gr1의 2차주소는 EX7_Sedan
		gr1.setModel("그랜져300");//부모가 갖고 있는 함수 호출
		gr1.setMin_price(2700);
		gr1.setSunroof(true);
		
		
		Ex7_Sedan g80 = new Ex7_Sedan();
		gr1.setModel("G80");
		gr1.setMin_price(6000);
		gr1.setSunroof(false);
		
		System.out.println(gr1.getMin_price());

		if(gr1.equals(g80))
		{
			System.out.println("서로 내용이 같다.");
		}
		else
			System.out.println("서로 내용이 다르다.");
			
	}

}
