package am;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ex1_KeyAdap extends KeyAdapter {

	Ex1_Frame f;
	
	public Ex1_KeyAdap(Ex1_Frame f) {
		this.f=f;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode= e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_LEFT:
			f.p.x-=5;
			if(f.p.x<0)
				f.p.x=0;
			break;
		case KeyEvent.VK_RIGHT:
			f.p.x +=5;
			if(f.p.x>f.p.getWidth()-80)
				f.p.x=f.p.getWidth()-80;
			break;
		}//switch문의 끝
		f.p.repaint();//update-->paint 호출
		
	}

}
