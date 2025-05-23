package pm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex5_Frame extends JFrame {

	JPanel center_p;//위에 패널 생성 -> jlabel 생성후 이미지 아이콘
	JPanel south_p;//아래 패널 생성 하고 jlabel과 텍스트 필드 버튼 하나 생성
	ImageIcon icon1; //이미지를 넣기위한 아이콘 하나 생성
	JButton bt1;//로그인 버튼
	CardLayout cl;
	JTextField text;
	GridLayout grid;
	FlowLayout flow;
	
	public Ex5_Frame() {
		
	    // center_p 패널 설정
	    center_p = new JPanel();
	    center_p.setLayout(new CardLayout()); // 여기서만 CardLayout
	    icon1 = new ImageIcon("src/images/2.png");
	    Image img = icon1.getImage();
	    Image changeImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    ImageIcon chageicon = new ImageIcon(changeImg);
	    JLabel lb1 = new JLabel(chageicon);
	    center_p.add(lb1);
	    this.add(center_p, BorderLayout.CENTER); // CENTER에 추가

	    // south 패널 설정
	    south_p = new JPanel();
	    south_p.setLayout(new GridLayout(3, 1,1,1)); // 2행 1열?씨부레 뭐야 이건
	    JLabel lb2 = new JLabel("대화명 : ");
	    text = new JTextField(10);
	    south_p.add(lb2);
	    south_p.add(text);
	    
	    bt1 = new JButton("로그인");

	    south_p.add(bt1,FlowLayout.RIGHT);

	    this.add(south_p, BorderLayout.SOUTH); // SOUTH에 추가
		
		setBounds(300, 100, 500, 500);
		setVisible(true);
		this.addWindowListener(new Ex2_MyAdap());
		
	}
	public static void main(String[] args) {
		//프로그램 시작
		new Ex5_Frame();
	}
}
