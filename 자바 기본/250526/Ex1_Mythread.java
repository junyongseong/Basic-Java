package am;

import java.awt.Color;
import java.awt.*;

public class Ex1_Mythread extends Thread {
	int x,y;
	int width,height;
	Color bg;
	int speed;
	
	Ex1_Frame f;//Ex1_Frame안에 있는 p를 접근하여 
				//필요할때 p에게 다시 그림을 그리도록 해야하기 때문에
				//p를 가지고 있는 객체 즉, Ex1_Frame의 주소를
				//현재 객체가 생성될 때 받아야하낟.
	
	public Ex1_Mythread(int x,int y,Ex1_Frame f) {
		width =100;
		height =100;
		this.x=x-(width/2);//width/2=50	클릭한 지점을 타원가운데로 맞추기 위해
		this.y=y-(height/2);//height/2=50 
		this.f=f;//***중요*****
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		bg=new Color(red,green,blue);
		
		speed = (int)(Math.random()*651+50);
	}

	@Override
	public void run() {
		//현재 스레드는 JPanel의 높이값에서 height값을 뺀 값까지를
		//y좌표의 한계점으로 본다.
		
		while(true){
			y+=5;
			//JPanel의 높이값과 y의 값을 비교한다음
			//무한 반복을 탈출할지 말지 판단
			if(y>=f.p.getHeight()-height)//이거 안해주면 넘어감
				break;//무한반복 탈출하면서 스레드 소멸
			//JPanle의 그림을 다시 그리도록 한다.
			f.p.repaint();
			
			//일정시간 동안 휴식!
			try {
				Thread.sleep(speed);
				
			} catch (Exception e) {
				
			}
			
		}//while문의 끝
		//스레드 소멸 직전
		//저장된 어레이리스트에서 자신을 삭제하면 된다.
		f.al.remove(this);//현재객체에서 지우는거니
		f.p.repaint();//이게 없으면 나머지 하나가 남아버림

	}
	
}
