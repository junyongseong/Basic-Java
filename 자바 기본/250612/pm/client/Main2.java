package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Reader;
import java.util.List;

public class Main2 extends JFrame {

    JPanel north_p;
    JButton btn;
    JTextField input_tf;
    JTable table;
    JMenuBar bar;
    JMenu file_menu;
    JMenuItem search_Empno,search_Ename,search_Job,search_Deptno;

    String[] c_name ={"사번","이름","직종","부서코드"};
    String[][] data= null;

    SqlSessionFactory factory;

    public Main2(){//생성자

        north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        north_p.add(new JLabel("검색할 이름 : "));
        north_p.add(input_tf= new JTextField(15));
        north_p.add(btn= new JButton("검색"));
        this.add(north_p,BorderLayout.NORTH);

        this.add(new JScrollPane(table= new JTable()));
        table.setModel(new DefaultTableModel(data,c_name));

        //메뉴 작업----------------------------------------------
        search_Empno = new JMenuItem("사번검색");
        search_Ename = new JMenuItem("이름검색");
        search_Job = new JMenuItem("직종검색");
        search_Deptno = new JMenuItem("부서검색");

        file_menu = new JMenu("파일");

        //메뉴 아이템 추가
        file_menu.add(search_Empno);
        file_menu.add(search_Ename);
        file_menu.add(search_Job);
        file_menu.add(search_Deptno);

        bar= new JMenuBar();
        bar.add(file_menu);
        this.setJMenuBar(bar);

        this.setBounds(300,100,500,400);
        this.setVisible(true);

        init();//공장 준비 완료!!

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//프로그램 종료
            }
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //사용자가 입력한 검색할 이름을 가져온다.
                String n = input_tf.getText().trim();
                if(n.length()<1){
                    JOptionPane.showMessageDialog(Main2.this ,
                            "검색할 이름을 입력해주세요");
                }else{
                    //DB 호출
                    search(n,"name");
                }
            }
        });
        //사번검색이라는 버튼을 눌렀을때
        search_Empno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String inputText = JOptionPane.showInputDialog("사번검색");
                System.out.println("입력된 값: " + inputText);
                search(inputText,"empno");
            }
        });


        //이름 검색 버튼을 눌렀을때
        search_Ename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = JOptionPane.showInputDialog("이름검색");
                System.out.println("입력된 값: " + inputText);
                search(inputText,"name");
            }
        });
        //직종 검색 버튼을 눌렀을때
        search_Job.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = JOptionPane.showInputDialog("직종검색");
                System.out.println("입력된 값: " + inputText);
                search(inputText,"job");
            }
        });

        //부서 검색 버튼을 눌렀을때
        search_Deptno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = JOptionPane.showInputDialog("부서검색");
                System.out.println("입력된 값: " + inputText);
                search(inputText,"deptno");
            }
        });

    }//기본 생성자 생성

    private void search(String n, String type){
        SqlSession ss = factory.openSession();
        String sqlId = "emp.search_" + type; // 예: search_empno, search_job 등
        List<EmpVO> list = ss.selectList(sqlId, n);

        if(list !=null && list.size()>0) {
            data = new String[list.size()][c_name.length];
            int i = 0;
            for (EmpVO vo : list) {
                data[i][0] = vo.getEmpno();
                data[i][1] = vo.getEname();
                data[i][2] = vo.getJob();
                data[i][3] = vo.getDeptno();
                i++;
            }
            table.setModel(new DefaultTableModel(data, c_name));
        } else {
            JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
        }
        ss.close();
    }

    private void init(){
        try {
            //Reader 생성
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            //공장 생성
            factory = new SqlSessionFactoryBuilder().build(r);
            //리소스 닫기
            r.close();
            this.setTitle("준비완료!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main2();
    }
}
