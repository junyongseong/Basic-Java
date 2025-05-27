package pm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import am.Me;

public class Ex3_Frame extends JFrame {

	Dimension d = new Dimension(390, 590);// 크기 객체
	
	//필요한 이미지를 선언
	Image back_img, me_img;
	
	JPanel p;
	Me me = new Me();
	
	//2번째 작업----------------------------------
	Image meteor_img;
	ArrayList<Ex3_Meteor> m_list = new ArrayList<>();
	boolean chk = true;
	
	//운석을 주기적으로 생성하여 m_list에 저장하는 스레드
	Thread makeMeteor = new Thread() {

		@Override
		public void run() {
			// 1초 간격으로 운석객체를 생성하여 m_list에 추가한다.
			// 반드시 p의 paintComponent에서 그림을 그려야 한다.
			// 생성된 운석객체의 스레드를 구동시키면서 마무리~~~
			while(chk) {
				//운석객체 생성
				Ex3_Meteor m = new Ex3_Meteor(Ex3_Frame.this, 
						meteor_img.getWidth(p), //32 - 운석객체 안에 있는 rect에 w로 지정
						meteor_img.getHeight(p)); //28-운석객체 안에 있는 rect에 h로 지정
				
				//운석의 x좌표값
				int x = (int)(Math.random()*p.getSize().width-m.rect.width);
				
				m.rect.x = x;
				m.rect.y = -30;// 화면 위에서 시작
				
				m_list.add(m);// 생성된 운석객체를 ArrayList에 저장(추가)
				m.start();// 운석객체가 스레드이므로 스스로 움직인다.
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}//while의 끝
		}
		
	};
	//====================================================
	
	//세번째 작업-----------------------------------------
	// 폭발객체(Ex3_Explosion)가 저장될 ArrayList
	ArrayList<Ex3_Explosion> ex_list = new ArrayList<>();
	
	//폭발이미지들을 배열로 준비
	Image[] exp_ar = new Image[27];
	//----------------------------------------------------
	
	Image bullet_img;
	ArrayList<Ex3_Bullet> b_list = new ArrayList<>();
		
	public Ex3_Frame() {
		back_img = new ImageIcon("src/images/back.jpg").getImage();
		me_img = new ImageIcon("src/images/me.png").getImage();
		meteor_img = new ImageIcon("src/images/meteor.png").getImage();
		bullet_img = new ImageIcon("src/images/bullet.jpg").getImage();
		
		//폭발이미지들을 만들어 배열에 저장하는 반복문
		for(int i=0; i<exp_ar.length; i++) {
			String img_path = String.format("src/images/exp_enemy_1/exp_%d.png", i+1);
			Image exp = new ImageIcon(img_path).getImage();
			
			//로드된 이미지객체를 배열에 저장
			exp_ar[i] = exp;
			
		}//폭발이미지 생성 반복문의 끝
		
		p = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// 배경 그리기
				g.drawImage(back_img, 0, 0, this);
				
				//주인공 그리기
				g.drawImage(me_img, me.rect.x, me.rect.y, this);
				
				//2번째 예제에서 추가된 내용---------------------------
				//  운석들을 모두 그리는 반복문
				for(int i=0; i<m_list.size(); i++) {
					//운석 하나 얻어내기
					Ex3_Meteor m = m_list.get(i);
					
					g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
				}//for의 끝
				
				//폭발객체는 모두 ex_list에 저장되어 있다. 이거 하나당 27개의
				// 이미지를 표현해야 한다.
				for(int i=0; i<ex_list.size(); i++) {
					//폭발객체 하나 얻어내기
					Ex3_Explosion exp = ex_list.get(i);
					
					//폭발객체 안에 있는 index를 이용하여
					// exp_ar이라는 배열의 index로 이용한다. 그리고자 하는 이미지를
					// 가져온다.
					Image img = exp_ar[exp.index];
					g.drawImage(img, exp.pt.x, exp.pt.y, this);
					
					if(exp.move_index()) // true인 경우는 폭발객체가 가지고 있는 index가
						ex_list.remove(exp);// 27이상일 때다. 즉 폭발이 끝났다는 것이므로
										// 폭발객체를 ex_list에서 삭제한다.
				}
				
				// 총알 그리기
				for(int i=0; i<b_list.size(); i++) {
					//총알객체 하나 얻어내기
					Ex3_Bullet b = b_list.get(i);
					
					g.drawImage(bullet_img, b.rect.x, b.rect.y, 
								b.rect.width, b.rect.height, this);
				}//for의 끝
				
			}
			
		};
		init_game();//게임초기화 함수 호출
		init_me_pos();
		
		this.setLocation(300, 50);
		this.pack(); // 내부에 들어온 컴포넌트들의 크기에 맞도록
		// 현재 창의 사이즈를 설정 우린 창에 JPanel만 추가 하므로
		// JPanel의 크기(Dimention)에 맞춘다.
		
		this.setResizable(false);// 창의 크기 조정 불가
		p.setFocusable(true); // 2번째 작업에서 추가된 내용 :::::::::::::::::::::::
		this.setVisible(true);
		
		//2번째 작업에서 추가 :::::::운석들을 만들어 던지는 스레드 시작 
		makeMeteor.start();
		
		//이벤트 감지자 등록
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				chk = false;
				System.exit(0);//프로그램 종료
			}
		});
		
		// 2번째 작업에서 추가된 내용 :::::::::::::::::::::::
		p.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// 방향키들 중 좌/우만 받아낸자!
				// me의 rect안에 x값을 증/감소 시킨다.
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						me.rect.x -= 5;
						me.rect.x = Math.max(me.rect.x, 0);
						break;
					case KeyEvent.VK_RIGHT:
						me.rect.x += 5;
						me.rect.x = Math.min(me.rect.x, p.getSize().width-me.rect.width);
						break;
					case KeyEvent.VK_SPACE:
						int x = me.rect.x + (me.rect.width/2-bullet_img.getWidth(p)/2);
						int y = me.rect.y;
						//위에서 준비된 x,y를 가지고 총알객체 생성
						Ex3_Bullet b = new Ex3_Bullet(Ex3_Frame.this, x, y);
						b_list.add(b);
						// 총알이 스스로 올라가도록 스레드 구동
						b.start();
						break;
				}//switch의 끝
				p.repaint();//좌표가 변경되었으므로 다시 그리기
			}
		});
	}
	
	private void init_game() {
		// 크기객체(Dimension)을 가지고 JPanel의 크기로 예약하자!
		p.setPreferredSize(d);
		
		//크기가 지정된 JPanel을 현재 창 가운데에 추가!
		this.add(p);
	}
	
	private void init_me_pos() {
		//주인공 이미지의 초기 위치를 지정하는 함수
		
		//주인공 이미지의 너비와 높이
		int imgWidth = me_img.getWidth(this);
		int imgHeight = me_img.getHeight(this);
		
		//System.out.printf("w:%d,h:%d\r\n", imgWidth, imgHeight);
		
		//Me객체 안에 Rectangle의 x,y,width,height를 지정하자
		me.rect.x = (d.width - imgWidth)/2;
		me.rect.y = d.height - imgHeight - 5;
		
		me.rect.width = imgWidth; // 여기에 있는 너비와 높이가 없어도 이미지는 표현된다. 
		me.rect.height = imgHeight;// rect의 너비와 높이가 필요한 이유는
								// 운석객체와 주인공객체가 충돌하는지 알아낼 때 필요함
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex3_Frame();
	}

}






