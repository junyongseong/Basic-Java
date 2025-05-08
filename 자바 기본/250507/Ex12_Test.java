package pm;

public class Ex12_Test {

	public static void main(String[] args) {
		/**[문제 1] 다음의 결과와 같은 모양을 출력하는 반복문을 구현하시오
		  	 [결과]
		 	* * * *
		 	* * *
		 	* *
		 	* 
		 	
		 	[문제 2] 다음의 결과와 같은 모양을 출력하는 반복문을 구현하시오
		 	 [결과]
		 	* * * *
		 	  * * *
		 	    * *
		 	      * 
		 	      
		 	[문제 3] 구구단을 다음과 같이 출력하는 반복문을 구현하시오
		 	 [결과]
		 	 2*1=2	3*1=3 	~~~~ 9*1=9
		 	 2*2=4	3*2=6 	~~~~ 9*2=18
		 	 ~~~~   ~~~~		 ~~~~
		 	 2*9=18	3*9=27	~~~~ 9*9=81	
		 * */
		//	[문제 1]
		System.out.println("----문제1----");

			for(int i=4;i>0;i--) {
				for(int j=0;j<i;j++) {
					System.out.printf("%-2c",'*');
				}
			System.out.println();
			}
			
			// 문제1 해설
			System.out.println("---문제1해설---");

			for(int k=0;k<4;k++)
			{
				for(int i=4; i>k;i--)
				{
					System.out.printf("%-2c",'*');
				}
				System.out.println();

			}
			
			System.out.println("----문제2----");

			//	[문제2]
			for(int i=0; i<4;i++)
			{
				for(int j=0; j<i; j++) {
					System.out.printf("%-2c",' ');
					}
				
				for(int j=4; j>i; j--) {
					System.out.printf("%-2c",'*');
					}
				System.out.println();
			}
			
			System.out.println("-----------------문제3-----------------");
			//문제 3
			for(int i=1;i<=9;i++)
			{
				for(int j=2;j<=9;j++)
				{
					System.out.printf("%d*%d=%2d ",j,i,j*i);
				}
				System.out.println();
			}
		}
	}

