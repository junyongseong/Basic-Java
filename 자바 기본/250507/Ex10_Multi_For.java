package pm;

public class Ex10_Multi_For {

	public static void main(String[] args) {
		/*	  [문제 1]
		 * 	1  2  3  4
		 *	5  6  7  8
		 *	9 10 11 12
		 * */
		int num=0;
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=4;j++)
			{
				System.out.printf("%-3d",++num); //num을 1로 하고 num++ 가능
			}
			
		System.out.println();
		}
		System.out.println("----------------");
		/*	 [문제2]
		 	0 * * *
		  	* 0 * *
		  	* * 0 *
		  	* * * 0		 
		 */
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++)
			{
				if(i==j)
					System.out.printf("%-3d",0);
				else
					System.out.printf("%-3c",'*');
			}
			System.out.println();
		}
	}

}
