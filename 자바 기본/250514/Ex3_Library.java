package am;

public class Ex3_Library {
	//공간만 만들어진 상태
	Ex3_Book[] ar = new Ex3_Book[5];
	
	//도서들을 만들어서 배열에 저장하는 기능
	public void setAr()
	{
		ar[0] = new Ex3_Book();
		ar[0].setB_num("P-J-100");
		ar[0].setTitle("이것이 자바다");
		ar[0].setPub("한빛미디어");
		ar[0].setPos("A-13");
		ar[0].setRent(true); //빌려 갈 수 있
		
		ar[1] = new Ex3_Book();
		ar[1].setB_num("P-J-112");
		ar[1].setTitle("UML");
		ar[1].setPub("한빛미디어");
		ar[1].setPos("B-100");
		ar[1].setRent(true);
		
		ar[2] = new Ex3_Book();
		ar[2].setB_num("P-J-100");
		ar[2].setTitle("이것이 우분투 리눅스다");
		ar[2].setPub("한빛미디어");
		ar[2].setPos("A-13");
		ar[2].setRent(true);
		
		ar[3] = new Ex3_Book();
		ar[3].setB_num("P-J-150");
		ar[3].setTitle("자바 바이블");
		ar[3].setPub("한빛 아카데미");
		ar[3].setPos("A-20");
		ar[3].setRent(false); //이미 빌려감
		
		ar[4] = new Ex3_Book();
		ar[4].setB_num("P-O-125");
		ar[4].setTitle("스프링 활용");
		ar[4].setPub("한빛미디어");
		ar[4].setPos("C-13");
		ar[4].setRent(true);
	}
	
	//책 이름으로 검색하는 기능! String으로 반환 인자 n이 넘어올 값
	public String search(String n){
		//도서명으로 검색된 책 정보들을 문자열로 저장하기 위해 필요한 객체준비
		 StringBuffer sb = new StringBuffer();
		 //모든 책들의 이름을 가져와서 인자로 받은 n이 저장된 값이 포함되었는지
		 //확인하는 반복문
		 for (int i = 0; i < ar.length; i++) {
			 //배열에 저장된 책 정보(Ex3_Book)를 하나씩 가져온다.
			 Ex3_Book bookname = ar[i];
			 //얻어낸 책 정보에서 책 제목만 얻어낸다.
			 String tt =bookname.getTitle();//"이것이 자바다"
			 
			 int idx=tt.indexOf(n); //tt안에 n의 값이 있는 위치값을 변수
			 						//idx에 저장한다. 만약 n의 값이 없다면
			 						//idx에는 -1이 저장된다.
			 if(idx != -1)
			 {
				 sb.append("\n");
				 sb.append("도서번호: ").append(bookname.getB_num()); //도서번호
				 sb.append("\n");
				 sb.append("제목: ").append(bookname.getTitle());//책 제목
				 sb.append("\n");
				 sb.append("출판사: ").append(bookname.getPub());//출판사
				 sb.append("\n");
				 sb.append("위치: ").append(bookname.getPos());//책 위치
				 sb.append("\n");
				 
				 String rent="대여중";
				 if(bookname.isRent())//true면 대여 가능으로 하자
					 rent="대여 가능";
				 				 
				 sb.append(rent);//대여중 or 대여가능이 들어감
				 sb.append("\n");
				 sb.append("==================");
			 	}
	        }
		 
	        return sb.toString();
	    }
    
	
}
