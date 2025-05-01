package am;

public class Ex3_Oper {
	public static void main(String[] args) {
		
		int a=3;
		int b=7;
		boolean res = (10>= a++) ||(++b > 7);
		//예측 a=4 b=7 따라서 true
		System.out.println(res);
		System.out.println("a = "+a);
		System.out.println("b = " +b);
		/*a++는 증감연산자가 변수 뒤에 존재하므로 연산이
		 * 줄바꾼 할때 수행한다. 그리고
		 * 먼저 10>=3을 수행하여 res에 결과 true가 저장
		 * ||논리 연산자에 의해 이미 true이므로 뒤에는 실행을
		 * 하지 않는다. 따라서 a++는 4가 되고 ++b는 실행하지
		 * 않았으므로 b= 7이 된다.*/
		
		/*만약 a가 10이면 a=11 b=7 true
		 * 그이유는 10>=a++를 실행할때 a++는 10이므로
		 * 10>=10 조건을 만족함 따라서 true 그 행이 끝난 이후에
		 * a++를 실행해서 a==11이 됨 논리연산자 ||은 앞이 이미 참이므로
		 * 뒤에는 실행할 필요 X 따라서 b는 그대로*/
	}
}
