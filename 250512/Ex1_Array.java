package am;

public class Ex1_Array {

	public static void main(String[] args) {
		//객체 자료형 배열을 생성하자
		String[] ar= new String[3];
		ar[0]="100";
		ar[1]="222";
//		ar[2]="300"; 	//암시적이니 다르다가 나오고 아래는
//		ar[2]="100";	//같다가 나옴
		ar[2]=new String("100");//명시적 객체 생성이니 다르다가 나옴
		
		for(int i=0;i<ar.length;i++)
		{
			System.out.printf("%s ",ar[i]);
		}
		System.out.println("\n-------------------------");
		if(ar[0]==ar[2]) {
			System.out.println("0번지와 2번지의 참조 주소가 같다.");
		}
		else
			System.out.println("0번지와 2번지의 참조 주소가 다르다.");

		if(ar[0].equals(ar[2]))
			System.out.println("0번지와 2번지의 참조 주소 내용이 같다.");
		else
			System.out.println("0번지와 2번지의 참조 주소 내용이 다르다.");
		
		System.out.println("=========================");
		String str="쌍용교육센터:3강의장:오경주";
		
		//str에 저장된 문자열에서 ":"을 중심으로
		//분할처리 하여 배열로 반환한다.
		String ar1[]=str.split(":");
		for(int i=0;i<ar1.length;i++)
		{
			System.out.println(ar1[i]);
		}
		
	}

}
