package pm;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex6_Map {

	public static void main(String[] args) {
		//사원을 의미하는 객체 Emp를 준비하자
		Ex6_Emp e1 =new Ex6_Emp();
		e1.setEmpno("1200");
		e1.setEname("마루치");
		e1.setDept("개발 1팀");
		
		Ex6_Emp e2 =new Ex6_Emp();
		e2.setEmpno("2021");
		e2.setEname("홍길동");
		e2.setDept("개발 2팀");
		
		Ex6_Emp e3 =new Ex6_Emp();
		e3.setEmpno("1007");
		e3.setEname("오로치");
		e3.setDept("개발 3팀");
		/*
		HashMap<String, Ex6_Emp> map = new HashMap<String, Ex6_Emp>();
		map.put("1200", e1);
		map.put("1007", e3);
		map.put("2021", e2);*/
		
		//먼저 위 3개의 객체들을 ArrayList에 저장하자!!
		ArrayList<Ex6_Emp> list =new ArrayList<Ex6_Emp>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		//사원 정보들을 모두 가진 List구조를 Map에 저장하자!!
		//키는 스트링 값은 어레이리스트 Ex6_emp
		HashMap<String, ArrayList<Ex6_Emp>> map = new HashMap<>();
		
		//키 "list", 값 list
		map.put("list", list);
		
		ArrayList<Ex6_Emp> al =map.get("list");
		for(int i=0;i<list.size();i++)
		{
			Ex6_Emp e=al.get(i);
			System.out.printf("%s %s %s",e.getEmpno(),e.getEname(),e.getDept());//사번
			System.out.println();
		}
	}

}
