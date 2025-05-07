package pm;

public class Ex9_Multi_For {

	public static void main(String[] args) {
		//화면에 1~5까지 출력하는 반복문
		/*	[결과]
		 * 1 2 3 4 5
		 * 1 2 3 4 5
		 * 1 2 3 4 5
		 * */
		for(int i=1;i<=5;i++)
			//System.out.print(i+" ");
			System.out.printf("%-2d ",i);//문자는 c,문자열 s
		
		System.out.println();
		System.out.println("--------------");
		
		for(int j=1;j<=3;j++) {
			for(int i=1;i<=5;i++) {
				System.out.printf("%-2d ",i);
			}//for문의 끝
			System.out.println();
		}//바깥쪽 for문의 끝
		System.out.println("--------------");

		for(int j=1;j<=4;j++) {
			for(int i=1;i<=4;i++) {
				System.out.printf("%-2c",'*');
			}
			System.out.println();
		}
	}
}
