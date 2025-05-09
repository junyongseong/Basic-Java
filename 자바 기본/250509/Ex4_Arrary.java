package am;

public class Ex4_Arrary {

	public static void main(String[] args) {

		int[] ar1 =new int[5];
		
		//생성하면 초기값에 0
		System.out.printf("%-2d, %-2d,%-2d",ar1[0],ar1[1],ar1[2]);
		
		System.out.println("\n-------------");

		/*
		ar1[1]=10;
		ar1[2]=20;
		ar1[3]=30;
		 */
		System.out.println();
		for(int i=0;i<ar1.length;i++)
		{
			ar1[i]=(i+1)*10;
			System.out.println(ar1[i]);
		}
	}
}