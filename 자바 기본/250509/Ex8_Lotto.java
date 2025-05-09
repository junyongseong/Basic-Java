package pm;

import java.util.*;
public class Ex8_Lotto {

    public static void main(String[] args) {

    	//정수 6개짜리 배열선언
        int[] lotto = new int[6];

        //배열길이 만큼 반복
        for (int i = 0; i < lotto.length; ) {
            boolean duplicate_values = true; //중복값찾기 불린형 왜? 값을 찾는거니
            //중복체크할때 중복일시 false 참일때 로또 번호를 저장하고 배열에 넣기
            int number = (int) (Math.random() * 45 + 1);//1~45난수값

            //중복일때
            for (int j = 0; j < i; j++) {
                if (lotto[j] == number) {//중복임
                    duplicate_values = false;
                    break;//나감 아래부터 실행
                }
            }
            //중복이 아닐때
            if (duplicate_values) {
                lotto[i] = number; //번호 저장
                i++;
            }
        }
        Arrays.sort(lotto);

        System.out.println("로또번호: ");
        for (int i = 0; i < lotto.length; i++) {
        	System.out.print(lotto[i] + " ");
        }
    }
}
