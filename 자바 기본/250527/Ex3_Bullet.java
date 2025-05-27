package pm;

import java.awt.Rectangle;

public class Ex3_Bullet extends Thread {
	Rectangle rect = new Rectangle();

	Ex3_Frame f;
	boolean chk = true;
	
	public Ex3_Bullet(Ex3_Frame f, int x, int y) {
		this.f = f;
		
		rect.x = x;
		rect.y = y;
		rect.width = 15;
		rect.height = 35;
	}

	@Override
	public void run() {
		// 무한반복을 통해 y값을 증가시킨다.
		// 이때 화면 하단에 도달할 경우 무한반복을 탈출한다.
		while(chk) {
			rect.y -= 3;
			
			//화면상단에 도달했는지? 확인!!
			if(rect.y <= 0)
				break;// 무한반복 탈출
						
						
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				
			}
			f.p.repaint();
		}//무한반복의 끝
		
		//Ex3_Frame에 있는 ArrayList에서 현재 운석객체를 찾아 삭제한다.
		f.b_list.remove(this);
	}
}
