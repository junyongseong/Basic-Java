package homework.회사;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindowAdap extends WindowAdapter{


	//WindowAdapter는 WindowListner를 구현하였으며 추상메스드 들이
	//모두 Empty로 재정의 되어 현재 클래스에서 의무적으로 재정의 할 
	//메서드가 없다.
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);//지금 바로 프로그램 종료
	}

}
