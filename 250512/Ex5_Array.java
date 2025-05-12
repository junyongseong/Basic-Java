package pm;

public class Ex5_Array {

	public static void main(String[] args) {
		//1차원 배열들 준비
		int[] ar1= {10,20,30,40};
		int[] ar2= new int[3];
		int[] ar3= new int[5];
		
		//위 3개의 1차원 배열들을 하나로 묶는 2차원배열을 만들자!
		int[][] ar4=new int[3][];
		ar4[0] =ar1;
		ar4[1] =ar2;
		ar4[2] =ar3;
		
		for(int i=0;i<ar4.length;i++)
		{
			for(int j=0;j<ar4[i].length;j++) {
				System.out.printf("%-3d",ar4[i][j]);
			}
			System.out.println();
		}	
	}
}
