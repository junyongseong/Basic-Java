package am;

public class Ex4_Array {

	public static void main(String[] args) {

		/*
	 	0 0 0 0			1 0 0 0
	 	0 0 0 0		=>	0 1 0 0
	 	0 0 0 0			0 0 1 0
	 	0 0 0 0			0 0 0 1
	  */
		
		
		int[][] ar=new int[4][4];
		for(int i=0;i<ar.length;i++) //2차원 배열의 길이를 반복수행(행)
		{
			for(int j=0;j<ar[i].length;j++){//각 1차원 배열을 반복하는 반복문
				if(ar[i]==ar[j]) {
					ar[i][j]=1; 
					System.out.printf("%-2d",ar[i][j]);
				}
				else
					System.out.printf("%-2d",ar[i][j]);

			}
			System.out.println();
		}
	}

}
