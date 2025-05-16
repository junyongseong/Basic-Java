package am;

import java.util.*;

public class Ex4_Set_Lotto {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
	
        /*for (int i = 0; i < 6;) {//중복일때 출력이 안됨 
         							//이렇게 하면 중복일때 사이즈가 안채워짐
         							 //무한반복 돌리고 set.size가 6일때 break;
        	 int number = (int) (Math.random() * 45 + 1);
        	 set.add(number);
        	 
        	 if(set.size()<6)
        		 i++;
        	 else
        		 break;
        	 
        }*/
		
		while(true)
		{
			int number = (int) (Math.random() * 45 + 1);
       	 	set.add(number);
			
			if(set.size()==6)
				break;
		}//무한반복
		System.out.print("로또번호 : ");
		//반복자 처리
		Iterator<Integer> it=set.iterator();
		
		while(it.hasNext()) {
			int su =it.next();
        	System.out.printf("%d ",su );
		}
	}
}
