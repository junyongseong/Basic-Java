package homework.회사;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TestPanel extends JPanel {

	int x=210;
	
	@Override
	protected void paintComponent(Graphics g) {
		//그림을 그리는 동작, Graphics g가 바로 붓과 같은 객체다.
		super.paintComponent(g);//화면전체를 지운것
		
		g.fillRect(x, 235, 80, 30);
	}
	
}
