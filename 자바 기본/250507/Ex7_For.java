package am;

public class Ex7_For {
	public static void main(String[] args) {
		/**문제) 1~10까지의 합을 구하는 반복문을 구현하시오!*/
		
		int sum =0;//반복문 안에서 사용된 i의 값을 누적시킬 변수

		for(int i=1;i<=10;i++)
		{
			sum +=i; //sum=sum+i
		}
		System.out.println("1~10까지의 합 : "+sum);

	}
}
