package pm;

public class Ex11_Array {

	public static void main(String[] args) {
		/* 배열 : 같은 자료형 여러 개를 하나로 묶은것
		 * 정수 6개를 저장할 수 있는 배열 준비
		 * 
		 * new는 새롭게 만들어라
		 * int[] ar =new int[6];
		 * */
		
		//로또
		int[] ar =new int[6];
		for(int i=0;i<=5;i++)//배열의 index는 0부터 시작
		{
			ar[i] =(int)(Math.random()*45+1);//1~45중 난수 발생
			System.out.println(ar[i]);
		}//for문의 끝
		System.out.println(ar);//객체 즉 배열을 만들때 생성된 id값
		
		System.out.println("---배열 출력---");

		for(int i=0;i<6;i++) {
			System.out.printf("%-3d",ar[i]);
		}
		//이렇게 하면 중복이 생김 따라서 중복을 없애야하고 오름차순으로 정리해야 함

	}

}
