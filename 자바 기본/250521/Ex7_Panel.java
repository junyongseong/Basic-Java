package pm;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Ex7_Panel extends JPanel {

	int x=100,y=10;
	
	@Override
	protected void paintComponent(Graphics g) {
		//g는 붓과 같은 객체다.
		//x=100;
		//y=10;
		//g.drawRect(x, y, 100, 100);
		g.fillRect(x, y, 10, 10);
	}
	
}
