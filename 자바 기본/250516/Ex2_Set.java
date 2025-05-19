package am;

import java.util.HashSet;
import java.util.Iterator;

public class Ex2_Set {

	public static void main(String[] args) {
		//Set구조는 인덱스가 없고 중복을 허용하지 않음
		HashSet<String> set=new HashSet<String>();
		
		String s= new String("SiST");
		String s1 ="SiST";//암시적객체 
		
		//set구조에 저장
		set.add(s);
		set.add(s1);//내용이 똑같으면 같은걸로 취급
		set.add("123");
		set.add("abc");
		set.add("SiST");//이것도 안들어감
		
		//내용이 같은 것들을 모두 같은것으로 취급한다.
		System.out.printf("set.size() : %d\n",set.size());//3
		
		//set구조의 요소들을 반복처리하기 위해서는 Iterator(반복자) 사용
		//먼저 Set구조로부터 Iterator를 얻어낸다.
		Iterator<String> it =set.iterator();
		while(it.hasNext()){//불린형 (has)가지고 있냐?참이냐?그러면 다음(next) 
							//hasNext()는 현재 커서 (반복자)의 위치에서 바로
							//다음 요소에 자원이 있다면 true 없다면 false다/
							//next()는 다음 요소로 이동하여 그 자리에 있는
							// 객체를 반환한다. 그것을 변수 n에 저장한다.
			String n = it.next();//it 반복자 제네릭에	서 String이니 여기서도 string
			System.out.println(n);
		}//while문의 끝
		
	}

}
