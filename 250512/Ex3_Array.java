package am;

public class Ex3_Array {

	public static void main(String[] args) {
		//정수형 2차원 배열 생성
		int[][] ar=new int[3][4];//길이가 4인 배열 3개 생성
		/*
		 	11 12 13 14
		 	15 16 17 18
		 	19 20 21 22
		  */
		//첫번째 case
		/*ar[0][0]=11;
		ar[0][1]=12;
		ar[0][2]=13;
		ar[0][3]=14;
		
		ar[1][0]=15;
		ar[1][1]=16;
		ar[1][2]=17;
		ar[1][3]=18;
		
		ar[2][0]=19;
		ar[2][1]=20;
		ar[2][2]=21;
		ar[2][3]=22;
		*/
	
		//2번째 case 반복문 사용
		//ar[i:바깥쪽 for문][j:안쪽 for문]
		int num = 11;
		for(int i=0;i<ar.length;i++) //2차원 배열의 길이를 반복수행(행)
		{
			for(int j=0;j<ar[i].length;j++){//ar[i] 1차원 배열에 대한 길이
				ar[i][j]=num++; 
				//ar[i][j]=num;
				//num++;
				System.out.printf("%-2d ",ar[i][j]);
			}
			System.out.println();
		}
	}
}