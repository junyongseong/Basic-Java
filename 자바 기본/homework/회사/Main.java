package homework;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//프로그램 시작 이때 회사 객체 생성
		Company comp = new Company();//company 객체를 생성
		comp.init();//위에서 만든 company 안에 init호출
		//이 안에서 Emp객체 4개 생성 후 각각의 이름과 사번 등을 저장
		//그렇게 만들어진 각각의emp 객체를 ArrayList에 저장해 놓는다.
		
        Scanner scan = new Scanner(System.in);
        System.out.println("검색할 항목을 선택하세요:");
        System.out.println("사번검색 : 1 이름검색 : 2  직책검색 : 3 부서검색 :4");
        int cmd =scan.nextInt();
        
        String msg=null;
        String str=null;
        
        switch(cmd) {
        	case 1:
        		System.out.println("검색할 사번:");
        		str =scan.next();
        		msg=comp.searchEmp(cmd, str);
        		break;
        	case 2:
        		System.out.println("검색할 이름:");
        		str =scan.next();
        		msg=comp.searchEmp(cmd, str);
        	case 3:
        		System.out.println("검색할 직책:");
        		str =scan.next();
        		msg=comp.searchEmp(cmd, str);
        	case 4:
        		System.out.println("검색할 부서:");
        		str =scan.next();
        		msg=comp.searchEmp(cmd, str);
        	default :
        		msg="잘못 입력함";
        }//switch의 끝
        System.out.println("검색 결과");
        System.out.println("================");
        if(msg.trim().length()<1)
        	System.out.println("검색된 정보가 없습니다.");
        else
        	System.out.println(msg);
        
	}
}
