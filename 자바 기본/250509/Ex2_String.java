package am;

import java.util.Scanner;

public class Ex2_String {

	public static void main(String[] args) {
		//키보드로 문자열을 받는다.
		//그것이 숫자인지 아닌지를 판단하는 프로그램을 완성하시오
		
		System.out.println("문자열을 입력하시오 : ");
		Scanner scan =new Scanner(System.in);
		
		String num =scan.nextLine();
		
		//str에서 한 문자씩 얻어내어 그것이 0~9까지 수들중 하나인지 
		// 아닌지 판단 (boolean)하자
		
		boolean isnum = true; //res가 true면 숫자 아니면 문자열
		
	
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
	    	if (ch < '0' || ch > '9') {
	    		isnum=false;
	    		break;
	           }
		}
		
		if(isnum)//if(isnum==true)
		{
      	  System.out.println("숫자");
		}
		else
	      System.out.println("숫자X");
	      }
	}

