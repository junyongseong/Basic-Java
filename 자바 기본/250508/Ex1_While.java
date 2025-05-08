package am;

public class Ex1_While {

	public static void main(String[] args) {
		/*	While문의 구성
			while(조건식){
				조건식 만족시 수행하는 문장1;
				조건식 만족시 수행하는 문장2;
		 	}
		 */
		
		int i=0; //변수 선언과 초기화
		while(i<10) {
			System.out.printf("%-2d",i);
			i++;//0,1,2,~~,9
		}
		/*while의 끝
		 * while문을 사용할때 조심해야할 것은
		 * 조건식을 언젠가는 불 만족시킬 수 있도록 증감 또는
		 * 다른 식으로 구현해야함*/
	}

}
