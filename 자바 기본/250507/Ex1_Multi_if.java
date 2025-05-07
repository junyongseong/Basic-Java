package am;

public class Ex1_Multi_if {

	public static void main(String[] args) {
		/* 1~10까지의 수들 중 난수 발생
		 * Math.random()* 범위+ 시작수 */
		
		int ran =(int)(Math.random()*10+1);
		//Math 함수는 0.0~0.9999임 따라서 10을 곱해주는게 끝이아니고
		//double형을 int로 형변환 해줘야함
		
		//double ran = Math.random()*10+1; 이렇게 하면 소수점까지
		//double ran = (int)(Math.random()*10+1);//소수점 한자리수까지
		
		/*ran의 값이 홀수인지? 짝수인지? 판단하자!*/
		//짝수란 2로 나눴을 때 나머지가 0인 값
		System.out.println(ran);
		if(ran%2==0) //산술연산자가 비교연산자보다 우선순위가 높으니 괄호 필요 X
			System.out.println("짝");
		else
			System.out.println("홀");
	}
}
