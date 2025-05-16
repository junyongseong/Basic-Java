package am;

import java.util.ArrayList;

public class Ex1_List {

	public static void main(String[] args) {
		//List 구조는 배열과 같이 index 요소로 접근하고
		//중복된 값을 허용한다.
		
		ArrayList<String> list =new ArrayList<String>();//string만 저장할 수 있는 리스트 구조
		String s =new String("SiST");//명시적 객체 생성
		String s1="SiST";
		
		//저장 기능
		list.add(s1);
		list.add("123");
		list.add("abc");
		list.add(s);
		list.add("SiST");//위에 s1과 같은거 하지만 없애는게 아니라 추가 됨
		System.out.printf("list.size() : %d\n",list.size());//5
		
		//변수 s와 같은 객체가 어디에 저장되었는지? 알아보는 반복문
		for(int i=0; i<list.size();i++) {
			//ArrayList에서 하나씩 얻어낸다.
			String v1=list.get(i);
			if(v1==s) {
				System.out.printf("찾으시는 s가 index %d에 있습니다.\n",i);
			}
			else if(v1==s1)
				System.out.printf("찾으시는 s1가 index %d에 있습니다.\n",i);
			
		}
		System.out.println("=========================");
		if(list.contains(s1)) {
			int idx=list.indexOf(s1);
			System.out.println("s1이 List에 존재합니다.");
			System.out.printf("s1이 List %d번지에 존재합니다.",idx);
		}
		else
			System.out.println("s1이 List에 존재하지 않습니다.");
	}

}
