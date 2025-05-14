package pm;

import java.util.Scanner;

public class Ex6_BaseBall {

	int[] com = new int[3];
	int[] user= new int[3];
	
	private int strike_count=0; //이 변수가 3이되면 프로그램 종료
	private int ball_count=0;
	
	private boolean duplicate;
	Scanner scan = new Scanner(System.in); //메인
	
	
	//컴퓨터가 가지는 정수 3개를 세팅하는 기능 중복값 거르기
	public void random()
	{
		//로또에서 사용
		//컴퓨터가 저장하는 난수 3개, 중복 X
		for (int i = 0; i < com.length; ) {
			com[i] = (int)(Math.random() * 9 + 1);
			duplicate = false;

			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					duplicate = true;
					break;
				  	}
				}
				if (!duplicate) {
					i++; // 중복이 없을 때만 다음 인덱스로 이동
					}
				}
	}
	
	//컴퓨터가 가지는 값을 문자열로 반환하는 기능
	public String getCom() {
		StringBuffer sb =new StringBuffer();
		//com배열에 있는 숫자 3개를 하나씩 얻어내어 sb에 추가하는 반복문
		for (int i=0; i<com.length;i++)
		{
			sb.append(com[i]);
			
			//마지막에는 ","를 넣지 않도록 하는 비교문
			if(i<com.length-1) //i가 2보다 작을때만 ","를 추가
				sb.append(", ");
			
		}
		return sb.toString();
	}
	
	//사용자가 입력한 문자열을 정수 3개로 변환하여 배열에 저장하는 기능
	 public void setUser(String n)	{
	        for (int i = 0; i < user.length; i++) {
	        	char ch=n.charAt(i);//n에서 1자씩 검출하여 숫자를 얻어내여 user 배열에 저장
	            user[i] = ch-48;;
	        }
	    }

	 // 스트라이크 int로 반환
	 public int countStrike() {
		 strike_count=0;//스트라이크 누적을 초기화
		 for (int i = 0; i < com.length; i++)
			{
				if(user[i]==com[i])
					strike_count++;
			}
		 return strike_count;
	 }

	 //볼 카운트 int로 반환
	 public int countBall(){
		 ball_count=0;
		 for (int i = 0; i < com.length; i++)
			{
				if(user[i]==com[(i+1)%3])//한칸 뒤
					ball_count++;
				else if(user[i]==com[(i+2)%3])//두칸 뒤
					ball_count++;
			}
		 return ball_count;
	 }
}


