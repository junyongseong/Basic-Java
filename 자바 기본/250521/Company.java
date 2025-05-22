package pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Company extends JFrame implements ActionListener {

	JPanel west_p;//왼쪽(서쪽)에 패널 생성
	JPanel south_p;//아래(남쪽)에 패널생성
	JButton bt1,bt2,bt3,bt4,bt5;//버튼 5개는 south_p에 추가
	JTextArea ta;// 중앙에 생성
	//west_p(왼쪽 패널)에 jlabel을 사번:, 이름:, 직책:, 부서: 만들고
	// jtextfield를 각각 그 옆에 하나씩 만듬
	boolean b1,b2,b3,b4,b5;
	
	
	FlowLayout flow1,flow2;//서쪽(왼쪽)하나 남쪽(아래) 하나
	GridLayout grid;
	
	public Company() {
		  // 왼쪽 패널
		grid = new GridLayout(7, 4, 5, 5); // 행, 열, 수평, 수직 
        west_p = new JPanel(grid);

        //사번
        west_p.add(new JLabel("사번 :"));
        JTextField sabun = new JTextField(5);
		//sabun.setSize(10, 10);
       // sabun.setLocation(100, 200);
        sabun.setForeground(Color.RED);
        sabun.setBackground(Color.green);
        Font font = new Font("Arial", Font.BOLD, 15);
        sabun.setFont(font);
        west_p.add(sabun);

        //이름
        west_p.add(new JLabel("이름 :"));
        JTextField name = new JTextField(5);
        name.setForeground(Color.RED);
        name.setBackground(Color.green);
        Font font1 = new Font("Arial", Font.BOLD, 15);
        name.setFont(font1);
        west_p.add(name);

        //직책
        west_p.add(new JLabel("직책 :"));
        JTextField pos = new JTextField(5);
        pos.setForeground(Color.RED);
        pos.setBackground(Color.green);
        Font font2 = new Font("Arial", Font.BOLD, 15);
        pos.setFont(font2);
        west_p.add(pos);

        //부서
        west_p.add(new JLabel("부서 :"));
        JTextField dept = new JTextField(5);
        dept.setForeground(Color.RED);
        dept.setBackground(Color.green);
        Font font3 = new Font("Arial", Font.BOLD, 15);
        dept.setFont(font3);

        west_p.add(dept);

        this.add(west_p, BorderLayout.WEST);

        // 아래 패널
        flow2 = new FlowLayout(FlowLayout.RIGHT);
        south_p = new JPanel(flow2);
        bt1 = new JButton("전체");
        bt2 = new JButton("추가");
        bt3 = new JButton("검색");
        bt4 = new JButton("삭제");
        bt5 = new JButton("취소");

        south_p.add(bt1);
        south_p.add(bt2);
        south_p.add(bt3);
        south_p.add(bt4);
        south_p.add(bt5);

        this.add(south_p, BorderLayout.SOUTH);

        // 텍스트 영역 추가 (중앙)
        ta = new JTextArea();
        this.add(new JScrollPane(ta), BorderLayout.CENTER);

        setBounds(300, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        // 버튼에 액션 리스너 등록
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
    }
    // 버튼 상태 제어함수
    public void setButtonState(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5) {
        bt1.setEnabled(b1);
        bt2.setEnabled(b2);
        bt3.setEnabled(b3);
        bt4.setEnabled(b4);
        bt5.setEnabled(b5);
    }

    public static void main(String[] args) {
        new Company();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object obj = e.getSource();
	    if(obj == bt1) {//전체
	    	setButtonState(true, true, true, true, true);
	    }
	    else if (obj == bt2) { // 추가
            setButtonState(false, true, false, false, true);
        } 
	    else if (obj == bt3) { // 검색
            setButtonState(false, false, true, false, true);
        } 
	    else if (obj == bt4) { // 삭제
            setButtonState(false, false, false, true, true);
        } 
	    else  { // 취소
            setButtonState(true, true, true, true, true);
        }
		
	}
}
