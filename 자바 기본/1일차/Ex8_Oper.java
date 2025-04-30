package pm;

public class Ex8_Oper {
	public static void main(String[] args) {
		int a = 10;
		int b = 7;
					//a=a+2				//b=b+2
		//boolean res = ((a+=2) > 10) && ((b+=2)>10);
		boolean res = ((a+=2) > 10) || ((b+=2)>10);
											//||, or일시
		System.out.println("a = "+a); //12	/12
		System.out.println("b = "+b); //9	/7
		System.out.println(res); //false
		System.out.println("-------------------------");
		
		//a가 15보다 작으므로 false 따라서 b는 실행하지 않음
		res = ((a+=2)>15)&&((b+=2)>15);		
		//res = ((a+=2)>15) || ((b+=2)>15);	//||, or일시
		System.out.println("a = "+a); //14	/14
		System.out.println("b = "+b); //9	/9
		System.out.println(res); //false
	}
}
