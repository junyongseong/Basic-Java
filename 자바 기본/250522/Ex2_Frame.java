package pm;

import javax.swing.JFrame;

public class Ex2_Frame extends JFrame {

	public Ex2_Frame() {
		
		setBounds(300, 100, 400, 450);
		setVisible(true);
		
		//이벤트 감지자 등록
		this.addWindowListener(new Ex2_MyAdap());;
	}
	
	public static void main(String[] args) {
		new Ex2_Frame();

	}

}
