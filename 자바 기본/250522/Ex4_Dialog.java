package pm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Ex4_Dialog extends JDialog implements WindowListener,ActionListener{

	JButton red_bt,green_bt,blue_bt;//이 버튼이 눌러지면 ex4_frame으로 가야함
	JPanel p;
	Ex4_Frame f;
	public Ex4_Dialog(Ex4_Frame n) {//버튼이 눌러지면 ex4_frame으로 가기위해 인자를 바당야함
		
		f=n;//n은 지역변수니 전역변수 f에다 넣어줌
		
		//화면구성
		p=new JPanel();
		p.add(red_bt=new JButton("Red"));
		p.add(green_bt=new JButton("green"));
		p.add(blue_bt=new JButton("blue"));
		
		this.add(p);//현재창 가운데에 p추가
		
		setBounds(420, 150, 250, 150);
		setVisible(true);
		
		//종료 이벤트
		//this.addWindowListener(new Ex2_MyAdap());//이렇게 하면 종료가 다됨 별도로 하나 더 만들기
		this.addWindowListener(this);//implements로 하나 만들기
		red_bt.addActionListener(this);
		green_bt.addActionListener(this);
		blue_bt.addActionListener(this);
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// 종료버튼 누를때 호출되는곳
		this.dispose();//이게 현재창만 없애는것
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 여기서 클릭되면 색상 바꾸기
		Object obj=e.getSource();
		
		if(obj==red_bt) {
			//f는 Ex4_Frame이니 Ex4_Frame에 있는 center_p에 넣어줘야함
			f.center_p.setBackground(Color.red);
		}
		else if(obj==green_bt) {
			f.center_p.setBackground(Color.green);
		}
		else {
			f.center_p.setBackground(Color.blue);

		}

	}
	
}
