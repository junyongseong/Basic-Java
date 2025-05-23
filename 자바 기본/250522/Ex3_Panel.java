package pm;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Ex3_Panel extends JPanel {

	int x,y;//그림을 그리는 위치
	int width=10;
	int height=10;
	
	@Override
	protected void paintComponent(Graphics g) {
		//그림을 그리는 붓이 g
		g.fillOval(x, y, width, height);//x,y=(0,0) 칠해진 너비10 높이10 짜리 타원 
	}

}
