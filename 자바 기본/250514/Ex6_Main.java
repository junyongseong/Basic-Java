package am;

import java.util.Scanner;

public class Ex6_Main {

    public static void main(String[] args) {

        Ex6_VendingMachine vm = new Ex6_VendingMachine();
        vm.setAr(); // 배열에 음료수의 정보 생성

        Scanner scan = new Scanner(System.in);
        System.out.print("Insert Coin : ");
        int input = scan.nextInt();

        String result = vm.search(input); // 검색 결과 문자열 반환
        System.out.println(result); // 결과 출력
        
        System.out.println("음료를 선택하십시오 : ");
        int choice =scan.nextInt();
        String select =vm.select(choice);
        System.out.println(select);
        
        
        
    }
}
