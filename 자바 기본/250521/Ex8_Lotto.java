package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex8_Lotto extends JFrame implements ActionListener {

   JLabel numbers;
   JPanel northPanel, centerPanel;
   ImageIcon number;
   GridLayout grid;
   JButton creatNum; // 버튼
   FlowLayout flow; // 해당 객체를 이동
  
public Ex8_Lotto(){
     
     
      flow = new FlowLayout(FlowLayout.RIGHT);
      northPanel = new JPanel(flow);
      grid = new GridLayout(1, 6);
     
      northPanel.add(creatNum = new JButton("번호 생성"));
     
      centerPanel = new JPanel(grid);
     
      this.add(northPanel,BorderLayout.NORTH);
      this.add(centerPanel);
      setBounds(300, 300, 1200, 700);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     
      creatNum.addActionListener(this);
      // 이벤트 감지자 등록
   }
  
   public static void main(String[] args) {
      // 프로그램 시작
      new Ex8_Lotto();
   }
  

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      TreeSet<Integer> ts = new TreeSet<Integer>();
     
      // 새로운 로또 번호를 받아야 할때
      while(ts.size() < 6) {
         int random = (int)(Math.random()*45 + 1);
         ts.add(random);
      }
     
      Iterator<Integer> it = ts.iterator();
      centerPanel.removeAll();
      while(it.hasNext()) {
         int su = it.next();
         StringBuilder sb = new StringBuilder();      //src/images/su.gif
         sb.append("src")
           .append("/")
           .append("images")
           .append("/")
           .append(su)
           .append(".")
           .append("gif");
         number = new ImageIcon(sb.toString());
         numbers = new JLabel(number);
         centerPanel.add(numbers);           
      }
   }

}