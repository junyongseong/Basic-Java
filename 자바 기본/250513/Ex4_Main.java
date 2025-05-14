package pm;

import am.Ex2_Main;

public class Ex4_Main {

	public static void main(String[] args) {
		//문자열 객체 생성
		String s1= new String("SiST");
		
		
		String s2=s1.concat("교육센터");
		
		System.out.println("s1 : "+s1);//SiST
		System.out.println("s2 : "+s2);//SiST교육센터
		
		System.out.println("====================");
		
		//String은 편집 할 수 없다. 무조건 새로 만들어진다.
		//문자열 편집을 위해서는 StringBuffer를 사용하자!
		StringBuffer sb=new StringBuffer("SiST");//stringbuffer는 새로 만들지 않고 안에서 계속 함
		StringBuffer sb2=sb.append("교육센터");	//sb와 sb2가 같은 곳을 가르키고있음
		
		
		//toString을 써야 스트링 버퍼를 스트링으로 바꿔줌
		//toString을 지워도 잘 출력하지만 스트링 버퍼와 스트링은 다른것임
		System.out.println("sb : "+sb);//SiST교육센터 뒤에 toString을 jvm이 자동으로 호출
		System.out.println("sb2 : "+sb2.toString());//SiST교육센터
		
		if(sb==sb2)
			System.out.println("서로 주소가 같다"); //주소가 같다고 나옴
		else
			System.out.println("서로 주소가 다르다");
		
		}
}