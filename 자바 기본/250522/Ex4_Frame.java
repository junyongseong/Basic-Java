package pm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex4_Frame extends JFrame implements ActionListener{

	JPanel north_p,center_p;
	JButton bt;
	
	public Ex4_Frame() {
		
		//화면 구성
		north_p =new JPanel();
		north_p.add(bt= new JButton("색상"));
		this.add(north_p,BorderLayout.NORTH);
		
		this.add(center_p= new JPanel());
		
		setBounds(300, 100, 500, 400);
		setVisible(true);
		
		//이벤트 감지자 등록 Ex2_MyAdap에서 만들어놈
		this.addWindowListener(new Ex2_MyAdap());
		bt.addActionListener(this);//색상 버튼을 누르면 ex4_dialog에 있는 패널이 출력되어야함
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex4_Frame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 색상 버튼을 클릭 할 때 마다 수행하는곳
		//Ex4_Dialog d=new Ex4_Dialog(this);
		new Ex4_Dialog(this);//이것도 가능
	}

}
