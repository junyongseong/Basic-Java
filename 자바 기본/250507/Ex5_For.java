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
		
		System.out.println("---------------");
		for(int i=0;i<=10;++i)//i++이랑 같음
			System.out.println(i);
		
		for(int i=0;i<=10;i+=2)//0 2 4 6 8 10출력
			System.out.println(i);
		
		for(double i=0;i<=10;i+=0.5)//0.5 1.0,1.5,....,10.0
			System.out.println(i);
		//이렇게 할거면 int형으로 20보다 작거나 같을때 까지 돌리는게
		//가독성에서 더 유리함
		
		for(int i=0;i<=10;i++)
			System.out.println(i); //0~9까지 총 10번
		System.out.println("----무한반복----");
		for(;;)//조건식이 참으로해도 무한반복
		{
			System.out.println("무한반복");

		}


	}	

}
