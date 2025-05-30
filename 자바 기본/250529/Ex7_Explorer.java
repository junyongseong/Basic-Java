package pm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex7_Explorer extends JFrame {

	JTable table;
	
	String[] c_name = {"사번","이름","입사일","직책","부서"};
	
	Object[][] data = {//2차원 배열
			{"1010","일지매","2024-10-02","사원","10"},
			{"2110","이지매","2024-11-12","대리","10"},
			{"3011","삼지매","2024-07-02","부장","20"}
	};
	
	public Ex7_Explorer() {
		DefaultTableModel model = new DefaultTableModel(data, c_name);
		table= new JTable(model);
		
		this.add(new JScrollPane(table));
		
		this.setBounds(300, 100, 500, 550);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//프로그램 종료
			}
			
		});
	}
	public static void main(String[] args) {
		// 프로그램 시작
		new Ex7_Explorer();

	}

}
