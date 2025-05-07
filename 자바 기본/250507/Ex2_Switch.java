package am;

public class Ex2_Switch {
	public static void main(String[] args){
		/* [Switch 문의 구성]
		 * 
		 * Switch(조건값){
		 * 	case 비교값1:
		 * 		조건값이 비교값 1과 같을 때 수행;
		 * 		break;
		 * 	case 비교값2:
		 * 		조건값이 비교값 2와 같을 때 수행;
		 * 		break;
		 * 	~~~~~~~~~~~~~~~~~~~
		 * 	case 비교값 n:
		 * 		조건값이 비교값n과 같을 때 수행;
		 * 		break;
		 * 	default:
		 * 		조건값과 모든 비교값이 다를 때 수행;
		 * 		마지막에는 break문 생략가능
		 * }
		 * 
		 * 문제 1~3까지의 수들 중 난수를 발생시켜 변수 su에 저장
		 * 난수가 1일경우엔 "초급" 출력
		 * 2일 경우엔 "중급" 출력
		 * 3일때는 "고급" 출력*/
		
		int su = (int)(Math.random()*3+1);
		
		switch(su)
		{
			case 1:
				System.out.println(su+" 초급");
				break;
			case 2:
				System.out.println(su+" 중급");
				break;
			case 3:
				System.out.println(su+" 고급");
				break;
		}
		
		System.out.println("---if문 사용시---");
		if(su==1)
			System.out.println(su+" 초급");
		else if(su==2)
			System.out.println(su+" 중급");
		else
			System.out.println(su+" 고급");
	}
}
