package pm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex5_Map {

	public static void main(String[] args) {
		// Map 구조: 키와 값을 하나의 쌍으로 저장하는 구조
		// 	키들은 중복 불가
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		String s1 = new String("SiST");
		String s2 = "SiST";
		String s3 = "쌍용교육센터";
		String s4 = "SiST"; //s2와 s4는 같은 주소를 가르킴
		
		//저장은 put
		map.put(100, s1);//100이라는 키로 s1을 저장
		map.put(200, s4);//200이라는 키로 s4을 저장
		map.put(300, s3);
		map.put(400, s2);
		map.put(300, s2);//기존데이터 변경 s3(쌍용교육센터)가 s2로 변경
		
		System.out.printf("map.size() : %d\n",map.size());
		
		//값 가져오기는 반드시 키를 활용해야함
		//map.get(300)의 반환값 밸류는(SiST) string타입 그래서 string사용
		String v1 =map.get(300);//키 300과 연결된 value가 v1에 저장된다.
		System.out.printf("map.get(300) : %s\n",v1);
		
		map.remove(100);//삭제
		System.out.printf("100 삭제 후 map.size() : %d\n",map.size());
		
		
		//키를 모를 경우에는 모든키를 먼저 얻어낸다.
		Set<Integer> set =map.keySet();
		
		//iterator을 사용함 반복자 얻기
		//Iterator<Integer> it =set.iterator();
		ArrayList<Integer> al =new ArrayList<Integer>();
		Collections.sort(al);
		
		Iterator<Integer> it =al.iterator();
		while(it.hasNext()) {
			//it에는 모두 키들만 존재한다.
			int key = it.next();//200,300,400중 하나 100은 삭제
			String value =map.get(key);
			System.out.printf("키 : %d 값: %s\n",key,value);

		}//while문의 끝

	}
}
