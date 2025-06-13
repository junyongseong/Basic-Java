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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameEx1 extends JFrame {

    JPanel north_p;
    JComboBox<String> combo;
    String[] ar ={"이름검색","직종검색","부서검색"};
    JTextField input_tf;
    JButton btn;

    JTable table;
    String[] c_name ={"사번","이름","직종","입사일","부서코드"};
    String[][] data;

    SqlSessionFactory factory;

    public FrameEx1(){

        north_p = new JPanel();
        north_p.add(combo = new JComboBox<>(ar));
        north_p.add(input_tf= new JTextField(12));
        north_p.add(btn= new JButton("검색"));

        this.add(north_p, BorderLayout.NORTH);
        this.add(new JScrollPane(table = new JTable()));
        table.setModel(new DefaultTableModel(data,c_name));

        this.setBounds(300,100,500,400);
        this.setVisible(true);

        //DB 연결
        init();

        //이벤트 감지자 등록
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    private void search(){
        //사용자가 입력한 검색어를 가져온다.
        String str= input_tf.getText().trim();
        if(str.length()>0){
            //사용자가 검색어를 1자리라도 입력했을 때 수행
            Map<String,String> map =new HashMap<>();
            int type = combo.getSelectedIndex();
            //System.out.printf("INDEX : %d,VALUE :%s",type,str);
            map.put("searchType", String.valueOf(type));
            map.put("searchValue",str);

            SqlSession ss = factory.openSession();
            List<EmpVO> list = ss.selectList("emp.search",map);
            viewTable(list);
            ss.close();
        }
    }
    private void viewTable(List<EmpVO> list) {
        //인자로 받은 List구조를 2차원 배열로 변환한 후 JTable에 표현!
        data = new String[list.size()][c_name.length];
        int i = 0;
        for(EmpVO vo : list){
            data[i][0] =vo.getEmpno();//사번
            data[i][1] =vo.getEname();//이름
            data[i][2] =vo.getJob();//직종
            data[i][3] =vo.getHiredate();//입사일
            data[i][4] =vo.getDeptno();//부서코드
            i++;
        }//for의 끝
        table.setModel(new DefaultTableModel(data,c_name));
    }

    private void init(){


        try {
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
            this.setTitle("준비완료!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //검색버튼을 클릭했을 때
                search();
            }
        });
        input_tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //검색어를 입력하고 엔터키를 쳤을때
                search();
            }
        });


    }


    public static void main(String[] args) {
        new FrameEx1();
    }
}
