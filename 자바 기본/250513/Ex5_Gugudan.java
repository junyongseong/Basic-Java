package pm;

public class Ex5_Gugudan {
	private int dan;

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public void print()
	{
		System.out.println(dan+"단");
		System.out.println("==============");
		
		for(int i=1;i<=9;i++)
			System.out.printf("%d X %d = %d\n",dan,i,(dan*i));
	}
	
	//위와 같은거지만 아래가 시스템적으로 더 효율적임
	//문자열을 반환
	public String result() {
		//문자열을 변경 불가능 그래서 문자열을 반환하기위해 스트링 버퍼
		StringBuffer sb = new StringBuffer();
		
		sb.append(dan);
		sb.append("단\r\n");
		sb.append("==============\r\n");
		
		for(int i=1;i<10;i++)
		{
			sb.append(dan);
			sb.append(" * ");
			sb.append(i );
			sb.append(" = ");
			sb.append(dan*i);
			sb.append("\r\n");
		}//for의 끝
		
		
		
		return sb.toString();
	}//result 함수의 끝
}
