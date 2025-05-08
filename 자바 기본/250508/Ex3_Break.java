package am;

public class Ex3_Break {

	public static void main(String[] args) {
		/*
		  [결과]
		 1 2 3 4
		 1 2 3 4
		 */
		
		int k=0;
		while(k<2) {
			int i=1;
			while(i<5)
			{
				System.out.printf("%-2d",i);
				//i가 3의 배수일 때 탈출!
				if(i%3==0)
					break;//가장 가까운 반복문 탈출
				i++;
			}
			k++;
			System.out.println();
		}
	}

}
