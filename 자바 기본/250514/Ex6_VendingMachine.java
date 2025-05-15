package am;

public class Ex6_VendingMachine {//자판기 클래스

	Ex6_Drink[] ar = new Ex6_Drink[4];
	
    int[] index = new int[ar.length];	// 사용자 선택 번호 -> 실제 음료 인덱스를 저장
    int userMoney;            			// 사용자 입력 금액 저장

    public void setAr() {
    	
    	
    	
        ar[0] = new Ex6_Drink();
        ar[0].setName("레츠비");
        ar[0].setPrice(500);

        ar[1] = new Ex6_Drink();
        ar[1].setName("사이다");
        ar[1].setPrice(700);

        ar[2] = new Ex6_Drink();
        ar[2].setName("콜라");
        ar[2].setPrice(500);

        ar[3] = new Ex6_Drink();
        ar[3].setName("웰치스");
        ar[3].setPrice(1000);
    }

    // 입력 받은 돈으로 살 수 있는 음료 목록을 String으로 반환
    public String search(int n) {
        StringBuffer sb = new StringBuffer(); 
        int count = 0;
        userMoney = n; // 사용자 돈 저장

        sb.append("구매 가능한 음료 목록:\n");

        for (int i = 0; i < ar.length; i++) {
            Ex6_Drink drink = ar[i];
            if (drink.getPrice() <= n) {
                index[count] = i; // 실제 음료 인덱스를 저장
                count++;

                sb.append(count);
                sb.append(".");
                sb.append(drink.getName());
                sb.append(" ");
                sb.append(drink.getPrice());
                sb.append("원\n");
            }
        }

        if (count == 0) {
            sb.append("해당 금액으로 구매할 수 있는 음료가 없습니다.\n");
        }

        return sb.toString();
    }
    public String select(int choice) {
        StringBuffer sb2 = new StringBuffer();

        Ex6_Drink selected = ar[index[choice - 1]];//선택한거를 기반으로 인덱스를 통해 찾음
        int change = userMoney - selected.getPrice();

        sb2.append(choice);
        sb2.append("번을 선택하였습니다.\n");
        sb2.append("선택한 음료: ");
        sb2.append(selected.getName());
        sb2.append("\n");
        sb2.append("남은 잔돈은 ");
        sb2.append(change);
        sb2.append("원입니다.");

        return sb2.toString();
    }

    
}
