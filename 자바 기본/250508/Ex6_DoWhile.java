package pm;

public class Ex6_DoWhile {

	public static void main(String[] args) {
		///do While문의 구성
		/*
		  do{
		  	실행할 문장들;
		  	}while(조건식); <<---세미콜론 잊지말기
		  	
		  	앞서 배운 while문과 다르게 선처리, 후 비교
		 	무조건 한번은 수행하는 형태다.
		 
		 	'@'문자를 5번 반복하는 문작을 do while로 구현하자!
		 */
		int i=0;
		
		do {
			System.out.printf("%-2c",'@');
			i++;
			
			if(i%3==0)
				break;
		}while(i<5);
		
		System.out.println("\n--------------------");
		//1~10까지 반복 수행한다. 이때 3의 배수는 출력하지 않아야한다.
		int j=1;
		do {
			
			if(j%3==0)
				System.out.printf("");
			else
				System.out.printf("%-2d",j);
			j++;
		}while(j<=10);
		
		System.out.println("\n--------------------");

		int k=0;
		do {
			k++;
			if(k%3 ==0 || k>10)//3의 배수를 찾는다.
				continue;//다음 반복회차로 이동
			
			System.out.printf("%-3d",k);
		}while(k<=10);
	}
}
