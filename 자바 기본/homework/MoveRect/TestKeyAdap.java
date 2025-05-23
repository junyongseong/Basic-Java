package homework.회사;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyAdap extends KeyAdapter {

	TestFrame f;//이곳에 반드시 TestFrame을 받아야 하는것은 아니다.
	//즉, 필요한 객체의 변수를 선언해도 된다. 다시말해서
	//TestPanel을 선언해도 된다.
	
	//테스트프레임 안에 멤버로 패널이 있음
	//즉 테스트 프레임의 주소를 알면 p로 접근이 가능
	
	public TestKeyAdap(TestFrame f) {
		this.f=f;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 누를 때마다 호출되는 곳!
		//이때 왼쪽 방향키와 오른쪽 방향키만 선별하자
		int keyCode =e.getKeyCode();
		
		switch(keyCode) {
			case KeyEvent.VK_LEFT:
				//TestPanel안에 있은 X의값을 5정도 빼준다.
				//객체의 주소 알아야함 
				f.p.x -=5;
				if(f.p.x<0)
					f.p.x=0;
				break;
			case KeyEvent.VK_RIGHT:
				f.p.x+=5;
					if(f.p.x>f.p.getWidth()-80)
						f.p.x=f.p.getWidth()-80;
					break;
		}//switch문의 끝
		f.p.repaint();//x좌표가 변경되었으니 그림을 다시 그린다.
	}

}
