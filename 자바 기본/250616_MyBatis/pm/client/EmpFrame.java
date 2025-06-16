package pm.client;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.DpetVO;
import pm.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpFrame extends JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EmpFrame.class.getName());

    String[][] data;
    String[] c_name = {"사번", "이름", "입사일", "급여", "부서명"};

    SqlSessionFactory factory;
    List<EmpVO> list;
    List<DpetVO> depts;
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
                ArrayList<String> dept_list = new ArrayList<>();
                //위의 List가 Map에 dept_list라는 키로 저장될 객체다. 이게 emp.xml로전달되서 반복문 돔

                //사용자가 선택한 checkbox가 무엇인지 알아내자!
                for (JCheckBox box : chk_ar){
                    if (box.isSelected()) {//선택되었다면 true 아니면 false
                        //선택된 체크박스의 문자열은 얻을 수 있다.
                        String str =box.getText();
                        //System.out.println(str);
                        //str을 depts라는 List에서 DeptVO를 대상으로 찾아낸다.
                        // 부서코드를 dpte_list에 저장
                        for(DpetVO dvo :depts){
                            if (dvo.getDname().equalsIgnoreCase(str)){
                                dept_list.add(dvo.getDeptno());
                                break;
                            }
                        }//안쪽 for문의 끝
                    }

                }//for문의 끝
                //System.out.println(dept_list); 이놈을 Map구조에 저장해야함
                Map<String,ArrayList<String>> map = new HashMap<>();//ArrayList<String> 51번째 줄
                map.put("dept_list",dept_list);

                SqlSession ss= factory.openSession();
                List<EmpVO> list =ss.selectList("emp.search_deptno",map);
                viewTable(list);
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
            Reader r = Resources.getResourceAsReader("pm/config/conf.xml");
            factory = new SqlSessionFactoryBuilder().build(r);
            r.close();
            this.setTitle("준비완료");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void allData(){
        SqlSession ss = factory.openSession();
        depts = ss.selectList("emp.dept_all");
        viewDept();
        ss.close();
    }
    private void viewDept(){
        //멤버변수인 depts의 길이만큼 chk_ar이라는 배열을 생성한다.
        chk_ar = new JCheckBox[depts.size()];
        //아직 JChekBox가 만들어지진 않음
        int i=0;
        for (DpetVO dvo : depts){
            chk_ar[i] = new JCheckBox(dvo.getDname());
            jPanel1.add(chk_ar[i]);
            i++;
        }
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

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


        jLabel1.setText("부서검색:");
        jPanel1.add(jLabel1);


        ImageIcon icon = new ImageIcon("src/images/image.png");
        Image img = icon.getImage().getScaledInstance(
                21,21,Image.SCALE_SMOOTH);
        jButton1.setIcon(new ImageIcon(img));
        jButton1.setPreferredSize(new Dimension(23, 25));

        //jButton1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        jButton1.setBorder(BorderFactory.createLineBorder(Color.green,2));
        jPanel1.add(jButton1);

        getContentPane().add(jPanel1, BorderLayout.PAGE_START);

        jTable1.setModel(new DefaultTableModel(
                data,c_name ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, BorderLayout.CENTER);

        pack();
    }
    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new EmpFrame().setVisible(true));
    }

    private JButton jButton1;
    private JLabel jLabel1;
    private JCheckBox[] chk_ar;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;


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
