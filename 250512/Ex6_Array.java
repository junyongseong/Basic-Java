package pm;

public class Ex6_Array {

	public static void main(String[] args) {
		//문자열 형 4개를 저장할 수 있는 배열 생성
		String[] a1= new String[4];
		
		//초기화
		a1[0]="값1";//암시적 객체 생성
		a1[1]=new String("값1");//명시적 객체 생성
		a1[2]=new String("값3");
		a1[3]="값4";//암시적 객체 생성
		
		String[] a2= {"val1","val2","val3","val3"};
		//a1과 a2라는 1차원 배열을 한곳에 모아두는 2차원 배열을 만들어 보자
		
		String[][] ar = new String[2][4];
		
		//준비된 2차원 배열 각 요소에 a1과 a2를 저장하자
		ar[0] =a1;
		ar[1] =a2;
		
		//이제 다시 2차원 배열을 생성하자 이때 초기값들을 
		//다음과 같이 하고자 한다면 선언 생성 초기화를 한번에 한다.
		/*
		 	v1 v2 v3 v4
		 	n1 n2 n3 n4
		 */
		String[][] ar2= {
				{"v1","v2","v3","v4"},
				{"n1","n2","n3","n4"}
		};
		
			
		String[][][] ar3 = new String[2][2][4]; //정해져 있으니 쓰기
		ar3[0]=ar;	//3차원 배열의 첫번째 요소에 2차원 배열 ar을 저장
		ar3[1]=ar2;	//
		
		//3차원 배열에 저장된 2차원 배열을 반복한 for문
			for(int i=0; i<ar3.length;i++)
			{
				System.out.println("2차원 배열: "+(i+1));
				
				//2차원 배열에 저장된 1차원 배열을 반복할 for문
				for(int j=0; j<ar3[i].length;j++)
				{
					System.out.print("\n\t");//줄바꿈 후 탭을 누른것

					//1차원 배열에 저장된 값들 반복처리
					for(int k=0;k<ar3[i][j].length;k++)
					{
						System.out.printf("->%-5s",ar3[i][j][k]);

					}
				}
				System.out.println();
			}
	}
}