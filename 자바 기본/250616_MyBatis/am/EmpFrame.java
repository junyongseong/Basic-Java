package am;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmpFrame.class.getName());

    String[][] data;
    String[] c_name = {"사번", "이름", "입사일", "급여", "부서명"};

    SqlSessionFactory factory;
    List<EmpVO> list;
    int i;

    public EmpFrame() {
        initComponents();//화면 구성

        init();//DB연걸
        allData();


        //이벤트 감지자 등롱
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //검색 버튼을 누를 때 수행함!
                String start= jTextField1.getText().trim();
                String end= jTextField2.getText().trim();
                if(start.length()>0 && end.length()>0){
                    //mapper(emp.xml)에 search_date를 호출하기 위해 ***
                    //지정된 파라미터 객체(parameterType emp보면 Map)인 Map을 생성 ***중요
                    Map<String,Object> map = new HashMap<>();//만들때는 HashMap
                    map.put("start",start);//"start"는 emp에있는 start
                    map.put("end",end);//"end"는 emp에있는 end

                    SqlSession ss = factory.openSession();
                    list = ss.selectList("emp.search_date",map);
                    ss.close();
                    viewTable(list);
                }
                else{
                    JOptionPane.showMessageDialog(EmpFrame.this,"날짜를 모두 입력하시오");
                }
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //테이블에서 더블클릭을 알아내자!
                int cnt= e.getClickCount();
                if(cnt == 2){
                    //Jtable에 선택된 행,index를 얻어내자
                    i = jTable1.getSelectedRow();
                    //setTitle(String.valueOf(i));
                    //위의 i는 List<EmpVO>에 접근하기 위한 index다.
                    EmpVO vo =list.get(i);

                    //setTitle(vo.getEname());
                    new MyDialog(EmpFrame.this,true,vo);

                }
            }
        });
    }

    private void init(){
        try {
            Reader r = Resources.getResourceAsReader("am/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
            this.setTitle("준비완료");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void allData(){
        SqlSession ss = factory.openSession();
        list = ss.selectList("emp.all");
        viewTable(list);//인자로 리스트를 줌 윗줄 보면 List<EmpVO> list이거니 이걸 그대로
        ss.close();
    }

    public void viewTable(List<EmpVO> list){
        //받은 list를 2차원 배열로 변환한 후 JTable에 표현하자
        data = new String[list.size()][c_name.length];//리스트의 길이만큼 1차원 배열
        int i= 0;
        for(EmpVO vo :list){
            data[i][0]=vo.getEmpno(); //사번
            data[i][1] = vo.getEname();//이름
            data[i][2] = vo.getHiredate();//입사일
            data[i][3] = vo.getSal();//급여
            data[i][4] = vo.getDname();//부서명
            i++;
        }
        jTable1.setModel(new DefaultTableModel(data,c_name){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();


        jLabel1.setText("시작일:");
        jPanel1.add(jLabel1);

        jTextField1.setColumns(8);
        jPanel1.add(jTextField1);

        jLabel2.setText("      ");
        jPanel1.add(jLabel2);

        jLabel3.setText("종료일:");
        jPanel1.add(jLabel3);

        jTextField2.setColumns(8);
        jPanel1.add(jTextField2);

        ImageIcon icon = new ImageIcon("src/images/image.png");
        Image img = icon.getImage().getScaledInstance(
                21,21,Image.SCALE_SMOOTH);
        jButton1.setIcon(new ImageIcon(img));
        jButton1.setPreferredSize(new java.awt.Dimension(23, 25));

        //jButton1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jButton1.setBorder(BorderFactory.createLineBorder(Color.green,2));
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                data,c_name ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new EmpFrame().setVisible(true));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;

    public void updateData(EmpVO vo) {
        SqlSession ss =factory.openSession();//()에 true넣으면 AutoCommit
        int cnt = ss.update("emp.edit",vo);
        if(cnt>0) {
            ss.commit();
            //JTbable의 값을 갱신해야함 다시한번 db로부터 값을 가져오거나 다시 이순신을 찾아가서 값을 바꾸던가.
            //후자가 더 이득임 즉 사용자가 JTable에서 더블클릭한 행번호(index)를 알아야 한다.
            //jTable1.setValueAt(vo.getEname(),i,1);//이름
            //jTable1.setValueAt(vo.getHiredate(),i,2);//입사일
            //jTable1.setValueAt(vo.getSal(),i,3);//급여
            //멤버변수 List의 내용도 변경해야 한다.
            list.set(i,vo);
            viewTable(list);
        }
        else
            ss.rollback();
        ss.close();
    }
}
