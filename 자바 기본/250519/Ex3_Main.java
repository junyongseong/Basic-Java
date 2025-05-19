package am;

public class Ex3_Main {

	public static void main(String[] args) {
		//원하는 객체 생성
		Ex3_TestRef c =new Ex3_TestRef();
		
		Ex3_Member mem =new Ex3_Member();
		mem.setName("SiST");
		
		System.out.println(mem.getName());//SiST
			
		c.test(mem);//다시 호출
		System.out.println(mem.getName());//쌍용교육센터
	}

}
