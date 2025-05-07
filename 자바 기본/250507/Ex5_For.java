package am;

public class Ex5_For {

	public static void main(String[] args) {
		/*1~10까지 반복하여 출력하는 for문!
		 * 
		 * [for문의 구성]
		 * for(초기식;조건식;증감식){ //세미콜론 2개는 필수
		 * 	조건식에 만족할 때 수행하는 문장;
		 * }
		 * */ 
		//int su=1;//밖에서 선언하면 실행 가능
		for(int su=1;su<=10;su++) {//su는 for문 안에서 만든거라 밖에선 실행 X
			System.out.println(su);
		}
		//System.out.println(su); 실행 X 
	}	

}
