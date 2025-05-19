package pm;
import am.Ex7_Car;
import am.Ex7_Sedan;

public class Ex8_Main {
	 public void test(Ex7_Car n) {
		System.out.println(n.getMin_price());	
		
		//인자로 넘어온 n이 가리키는 인스턴스 안에 Ex8_Suv가 있는지 검증은가능
		//사용은 불가능
		if(n instanceof Ex8_Suv) {
			//여긴 n이 가르키는 인스턴스 안에 Ex8_Suv가 있을때만 수행
			Ex8_Suv suv =(Ex8_Suv)n;//형변환
			System.out.println(suv.isHud());
		}
		else if(n instanceof Ex7_Sedan) {
			//Ex7_Sedan sedan=n; 오류남 형변환 해야함
			Ex7_Sedan sedan=(Ex7_Sedan) n;
			System.out.println(sedan.isSunroof());
		}
	}
	
	public static void main(String[] args) {
		
		// 원하는 객체 생성
		Ex8_Suv gv90=new Ex8_Suv(); //Ex8_Suv가 Ex7_Car로부터 상속받아서 가능
		gv90.setModel("GV90");
		gv90.setMin_price(10000);
		gv90.setHud(true);
		
		Ex7_Sedan g90=new Ex7_Sedan();
		g90.setModel("G90");
		g90.setMin_price(9000);
		g90.setSunroof(true);

		/////////////////////////////////
		//test(gv90);//같은 static 공간이 아니면 호출 불가능 
					//같은 static 공간으로 만들면 가능
		Ex8_Main main= new Ex8_Main();
		main.test(gv90);//test의 Ex8_Car로 바꾸면 오류남 n이 호출 X
		main.test(g90); //지금 오류나는 이유는 EX7_Car, Ex7_Sedan 안에만 있지 Ex8_Suv 에는 존재 X
		//그것을 해결하기 위해서는 부모인 Ex7_Car을 불러오면 됨
	}
}