package am;

public class Ex6_Oper {
	public static void main(String[] args) {
		/* 대입 연산자 : =,+=,-=,*=,/= 
		 * 우선 순위는 가장 낮다. */
		
		int a=7;
		int b=5;
		
		int c = 0;
		c +=a; //c에다가 c+a를 저장하시오.
		System.out.println("c+=a : "+c);//7
		
		c+=b;
		System.out.println("c+=b : "+c);//7 + 5 = 12
		
		c *=b;
		System.out.println("c*=b : "+c);//12 * 5 = 60
		
		c /=b;
		System.out.println("c/=b : "+c);//60 / 5=12
	}
}
