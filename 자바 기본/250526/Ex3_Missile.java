package pm;

public class Ex3_Missile extends Thread {
	//스페이스 바를 눌렀을 때 생성되는 총알객체를 의미하는 클래스다.
		int m_x,m_y;//총알의 위치
		int m_w=19,m_h=88;
		
		Ex3_Frame f;//이주소가 있어야 ArrayList와 JPanel을 접근할 수 있다.
		
		public Ex3_Missile(Ex3_Frame f,int x,int y) {
			this.f=f;
			this.m_x=x;
			this.m_y=y;
			
		}
		@Override
		public void run() {
			// 현재 스레드가 해야 할 일 (y좌표 감소- 그림 다시그리기)
			
			//일정 시간동안 쉬면서 y좌표를 감소하는 반복문 필요
			while(true) {
				m_y-=5;
				
				//좌표가 변경되었으므로 그림을 다시 그리자
				f.p.repaint();
				if(m_y<=0)
					break;//무한반복문 탈출
				try {
					Thread.sleep(20);
				} catch (Exception e) {
				}
			}//while문의 끝
			
			f.al.remove(this);
			f.p.repaint();//마지막 미사일 사라지게
		}
}
