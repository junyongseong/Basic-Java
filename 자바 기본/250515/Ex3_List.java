package pm;

import java.util.ArrayList;

public class Ex3_List {

	public static void main(String[] args) {
		// 배열과 같은 List구조 생성
		ArrayList<Integer> al =new ArrayList<Integer>();//()안은 용량
									//만약 여러개를 더 만들면 더 늘어나고 삭제하면 줄어듬
		
		//현재 List구조의 사이즈를 얻어내자
		int size=al.size();
		System.out.printf("al.size : %d\n",size);

		al.add(100);//하나 저장
		size =al.size();
		System.out.printf("al.size : %d\n",size);//100
		
		for(int i=1;i<11;i++)//10번반복해서 i값 추가
			al.add(i);
		
		size=al.size();
		System.out.printf("al.size : %d\n",size);//11
		
		//List 구조에 저장된 요소들을 하나씩 얻어내어 출력하는 반복문
		for(int i=0;i<al.size();i++) {
			//List구조에 저장된 요소들을 하나씩 얻어낼 때는
			//반드시 저장된 요소의 자료형을 알아야한다.
			int v1 =al.get(i);
			System.out.printf("%-4d",v1);//100,1,2,~10// 100이 0번지 10이 10번지
		}
		System.out.println();
		System.out.println("==================================");
		
		
		al.remove(1);//특정번지에 있는 걸 지워라 여기선 1번지를 지우는것
		for(int i=0;i<al.size();i++) {
			
			int v1 =al.get(i);
			System.out.printf("%-4d",v1);
		}
		System.out.println();
		System.out.println("==================================");
		System.out.printf("삭제후 사이즈 : %d",al.size());
		
		System.out.println();
		System.out.println("==================================");
		//원하는 위치에 추가하기 -insert 원하는 위치 3번지
		al.add(3, 400);
		
		for(int i=0;i<al.size();i++) {
			
			int v1 =al.get(i);
			System.out.printf("%-4d",v1);//지우고 들어가는게 아니라 그냥 그위치에 넣어지고 뒤엔 하나씩 밀림
		}
		
		System.out.println();
		System.out.println("==================================");
		/*
		//현재 ArrayList에 99가 있는지 확인하자! for문 활용
		boolean chk = false;
		for(int i=0; i<al.size();i++) {
			int v=al.get(i);
			if(v==99)
				chk=true;
				break;
		}
		
		if(chk)
			System.out.println("99가 있습니다.");
		else
			System.out.println("99가 없습니다.");
			
		*/
		
		//contains활용
		boolean chk=al.contains(99);
		if(chk)
			System.out.println("99가 있습니다.");
		else
			System.out.println("99가 없습니다.");
		System.out.println("==================================");
		
		
		if(al.contains(99))//조건식이 들어갈 수 있음 true or false 따라서 가능
			System.out.println("99가 있습니다.");
		else
			System.out.println("99가 없습니다.");
		System.out.println("==================================");
		
		//indexOf활용
		int idx =al.indexOf(99);
		if(idx !=-1)
			System.out.println("true");
		else
			System.out.println("false");
		
		System.out.println("==================================");

		if(al.contains(400)) {
			int index =al.indexOf(400);
			System.out.printf("400이 %d위치에 있습니다\r\n",index);
		}
		
		System.out.println("==================================");
		al.clear();//모두 삭제
		System.out.printf("클리어 후 사이즈 : %d\n",al.size());
		System.out.printf("리스트가 비었을까? : %b\n",al.isEmpty());
		
		//리스트 구조에서 알아야 할 메서드(함수)들
		//-add :추가 ,add(3,400): 3번 위치에 400을 추가
		//-get :추출
		//-remove:삭제
		//-size : 저장된 요소 수
		//-clear : 모두삭제
		//-contains : 포함여부 확인
		//-isEmpty :비었는지 확인
	}
	
}
