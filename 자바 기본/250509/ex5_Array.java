package am;

public class ex5_Array {

	public static void main(String[] args) {
		//문자를 4개 저장할 수 있는 배열을 생성한 후
		//반복을 이용하여 'A','B','C','D'가 저장되도록 초기화하시오
		
		char[] ar=new char[4];
		
		for(int i=0;i<ar.length;i++)
		{
			ar[i] = (char)('A'+i);
			System.out.printf("ar%d = %c\n",i,ar[i]);
		}
	}

}
