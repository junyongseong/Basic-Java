package pm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("사번검색 : 1, 이름검색 : 2, 직책검색 : 3, 부서검색 : 4");
            System.out.print("선택 : ");
            int choice = scan.nextInt();
            

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("검색어 입력 :\n ");
            String keyword = scan.nextLine();

            String result = company.search_emp(choice, keyword);
            System.out.println("[검색 결과]");
            System.out.println(result);
        }

        scan.close();
    }
}
