package pm;

public class Ex3_Gugudan {

	private int dan;

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	//구구단을 출력하는 함수
	public void Printgugudan()
	{
		System.out.println(dan+"단");

		for(int i=1;i<=9;i++) {
			System.out.printf("%d X %d = %d\n",dan,i,(dan*i));
		}
	}
}//클래스의 끝
