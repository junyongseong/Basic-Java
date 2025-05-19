package am;

public class Ex4_Args {
	public void test(int n) {//인자 1, 오버로딩(중복정의)
		++n;
		System.out.println(n);
	}
	public void test(int n,int n1)//자료형이 같고 개수가 같으면 오류
	{							//인자 2개짜리
		++n;
		System.out.printf("%d %d",n,n1);
	}
	public void test(int n,int n1,int n2)//인자 2개짜리
	{						
		++n;
		System.out.printf("%d %d %d",n,n1,n2);
	}
}
