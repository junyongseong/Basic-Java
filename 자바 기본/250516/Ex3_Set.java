package am;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex3_Set {

	public static void main(String[] args) {
		// 중복을 허용하지 않고, 인덱스가 없다. 그리고
		//정렬을 지원하는 Set구조가 TreeSet
		
		TreeSet<String> set = new TreeSet<String>();
		
		String s= new String("SiST");
		String s1 ="SiST";//암시적객체 
		
		//set구조에 저장
		set.add(s);
		set.add(s1);//내용이 똑같으면 같은걸로 취급
		set.add("123");
		set.add("abc");
		set.add("SiST");//이것도 안들어감

		Iterator<String> it =set.iterator();//반복자
		while(it.hasNext()) {//커서 다음칸에 요소가 있는지 확인
			//있다면 다음칸으로 이동하여 요소 가져오기
			String n=it.next();
			System.out.println(n);
		}
		System.out.println(set);
		
	}

}
