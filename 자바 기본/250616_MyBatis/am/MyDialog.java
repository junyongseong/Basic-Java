package am;

import am.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends javax.swing.JDialog {

    EmpFrame parent;
    public MyDialog(EmpFrame parent, boolean modal, EmpVO vo) {
        super(parent, modal);
        this.parent =parent;
        initComponents(); // 화면 구성
        empno_tf.setText(vo.getEmpno());//사번 들어간거
        ename_tf.setText(vo.getEname());
        job_tf.setText(vo.getJob());
        hdate_tf.setText(vo.getHiredate());
        sal_tf.setText(vo.getSal());
        comm_tf.setText(vo.getComm());
        dname_tf.setText(vo.getDname());

        jButton1.addActionListener(new ActionListener() {//취소버튼 jnutton1
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jButton2.addActionListener(new ActionListener() {//저장버튼
            @Override
            public void actionPerformed(ActionEvent e) {
                //저장버튼을 클릭할때마다 수행하는곳

                //뭐가 바뀌었는지 모르니 다 가져와야함
                String empno = empno_tf.getText().trim();
                String enmae = ename_tf.getText().trim();
                String job = job_tf.getText().trim();
                String hdate = hdate_tf.getText().trim();
                String sal = sal_tf.getText().trim();
                String comm = comm_tf.getText().trim();
                String dname = dname_tf.getText().trim();

                // 빈 문자열이면 null로 바꾸기
                if (comm.isEmpty()) {
                    comm = null;
                }

                EmpVO vo = new EmpVO(); //클래스 만들어서 하는게 편할듯? 거기에 가독성
                vo.setEmpno(empno);
                vo.setEname(enmae);
                vo.setJob(job);
                vo.setHiredate(hdate);
                vo.setSal(sal);
                vo.setComm(comm);
                vo.setDname(dname);

                parent.updateData(vo);//EmpFrame에 있는 함수 호출
                dispose();

            }
        });
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        empno_tf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ename_tf = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        job_tf = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hdate_tf = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sal_tf = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comm_tf = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dname_tf = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setText("사번:");
        jPanel1.add(jLabel1);

        empno_tf.setColumns(6);
        empno_tf.setEditable(false);
        jPanel1.add(empno_tf);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel2.setText("이름:");
        jPanel2.add(jLabel2);

        ename_tf.setColumns(6);
        jPanel2.add(ename_tf);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel3.setText("직종:");
        jPanel3.add(jLabel3);

        job_tf.setColumns(6);
        jPanel3.add(job_tf);

        getContentPane().add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel4.setText("입사일:");
        jPanel4.add(jLabel4);

        hdate_tf.setColumns(6);
        jPanel4.add(hdate_tf);

        getContentPane().add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel5.setText("급여:");
        jPanel5.add(jLabel5);

        sal_tf.setColumns(6);
        jPanel5.add(sal_tf);

        getContentPane().add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel6.setText("보너스:");
        jPanel6.add(jLabel6);

        comm_tf.setColumns(6);
        jPanel6.add(comm_tf);

        getContentPane().add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel7.setText("부서명:");
        jPanel7.add(jLabel7);

        dname_tf.setColumns(6);
        dname_tf.setEditable(false);//변경 비활성화
        jPanel7.add(dname_tf);

        getContentPane().add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton2.setText("저장");
        jPanel8.add(jButton2);

        jButton1.setText("취소");
        jPanel8.add(jButton1);

        getContentPane().add(jPanel8);

        pack();
    }

    private javax.swing.JTextField comm_tf;
    private javax.swing.JTextField dname_tf;
    private javax.swing.JTextField empno_tf;
    private javax.swing.JTextField ename_tf;
    private javax.swing.JTextField hdate_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField job_tf;
    private javax.swing.JTextField sal_tf;
}
