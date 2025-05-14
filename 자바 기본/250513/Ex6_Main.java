package pm;

import java.util.Scanner;

public class Ex6_Main {
    public static void main(String[] args) {

        Ex6_BaseBall game = new Ex6_BaseBall();

        game.random(); // 컴퓨터 숫자 생성
        String msg =game.getCom();
        
        System.out.println("숫자 야구 게임 시작");
        System.out.println("컴퓨터 숫자: " +msg); // 테스트용
        System.out.println("===================");
        
        Scanner scan = new Scanner(System.in); // Scanner를 main에 추가
        
        int strikes=0, balls; // 결과 저장 변수
        int count = 0; // 시도 횟수

        do {
        	count++; // 시도 횟수 증가
        	System.out.println();
        	System.out.printf("%d차 시도입니다.\n",count);
            System.out.print("숫자를 입력하시오 : ");
            
            String input = scan.nextLine();//키보드로부터 한줄 입력받기
            game.setUser(input); // 사용자 입력 저장
            
            if(input.length()>3)
            {
            	System.out.println("3자를 입력하셔야 합니다.");
            	continue;//strikes 초기화 안하면 오류남
            }
            
            
            strikes = game.countStrike(); // 스트라이크 수 계산 함수 호출
            balls = game.countBall(); // 볼 수 계산 함수 호출

            System.out.printf("%d스트라이크 %d볼 입니다\n", strikes, balls);

        } while (strikes != 3);//=game.com.length - baseball안에 컴 길이 즉 3

        System.out.printf("%d차 시도만에 성공하셨습니다! 축하합니다.",count);
        scan.close(); // 리소스 해제
    }
}
