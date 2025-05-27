package am;

import java.awt.Rectangle;

public class Ex2_Meteor extends Thread {
	//스스로 움직이는(떨어지는) 운석을 의미 하는 객체
	Rectangle rect = new Rectangle();//전부 0 외부에서 지정하면됨
	int speed;
	
	//현재 운석객체는 Ex2_Frame정보를 가지고 있어야한다. 그 이유는
	//그곳에 있는 ArrayList와 Jpanel등을 접근해야 하기 때문이다.
	Ex2_Frame f;
	
	public Ex2_Meteor(Ex2_Frame f,int w,int h) {
		this.f=f;
		
		//받은 w와 h는 Rctangle에 저장한다.
		rect.width=w;
		rect.height=h;
		
		speed=(int)(Math.random()*100+10);
		
	}

	@Override
	public void run() {
		// 무한반복을 통해 y값을 증가시킨다.
		//이때 화면 하단에 도달할 경우 무한반복을 탈출한다.
		while(true) {
			rect.y +=3;
			
			
			//화면 하단에 도달했는지 확인
			if(rect.y >= f.p.getSize().height-rect.height)
				break;//무한반복 탈출
			
			//주인공과 현재 운석이 충돌했을 수도 있으므로 충돌검사를 해보자
			if(rect.intersects(f.me.rect))
				break;
			
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
			}
			f.p.repaint();
		}//무한반복문의 끝
		//Ex2_Frame에 있는 ArrayList에서 현재 운석객체를 찾아 삭제한다.
		f.m_list.remove(this);
		f.p.repaint();
	}
}
