package pm;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ex8_Frame extends JFrame implements MouseListener{
	
	private JButton[] bt_ar=new JButton[8];
	JPanel north_p=new JPanel();
	JTextArea ta =new JTextArea();
	int i;
	
	public Ex8_Frame() {
		
		this.add(north_p,BorderLayout.NORTH);
		this.add(ta);
		JScrollPane jp = new JScrollPane(ta);
		this.add(jp,BorderLayout.CENTER);
		for(int i=0;i<bt_ar.length;i++) {
			StringBuffer sb =new StringBuffer("구구단");
			sb.append(i+2);
			bt_ar[i] =new JButton(sb.toString());
			
			bt_ar[i].addMouseListener(this);
			//버튼 객체에게 mouse 이벤트를 감지하는 객체를 등록한다.
			//그 Mouse 이벤트를 감지하는 객체가 바로 this(현재 객체)
			north_p.add(bt_ar[i]);
		}
		setTitle("내가 그린 기린 그림은 목이 긴 기림 그림이고,"
				+ "네가 그린 기린 그림은 목이 안 긴 기린 그림이다.");
		setBounds(300, 100, 1000, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Ex8_Frame f = new Ex8_Frame();
	}
	/*
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object obj = e.getSource();
		
		for(i=0;i<bt_ar.length+2;i++) {
		if(obj==bt_ar[i]) {
			
			ta.append(String.format("=====%d단 출력=====\n",i+2));
			for(int j=1;j<10;j++) {
				ta.append(String.format("%d X %d =%d\n",i+2,j,(i+2)*j));	
				}
			}
		}
	}*/
	public void mouseClicked(MouseEvent e) {
	    Object obj = e.getSource();

	    for (int i = 0; i < bt_ar.length + 2; i++) {
	        if (obj == bt_ar[i]) {
	            StringBuffer sb = new StringBuffer();
	            sb.append("=====").append(i + 2)
	              .append("단 출력=====\n");

	            for (int j = 1; j < 10; j++) {
	                sb.append(i + 2).append(" X ").append(j)
	                  .append(" = ").append((i + 2) * j).append("\n");
	            }
	            ta.append(sb.toString());
	        }
	    }
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

}
