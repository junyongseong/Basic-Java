package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ex9_File extends JFrame {

    JPanel north_p;
    JPanel center_p;
    JTextField loc_tf;
    JButton ok_bt;
    JTable table;
    DefaultTableModel model;

    public Ex9_File() {
        // north 패널 -----------------------==-=-=-=-=--
        north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        north_p.add(new JLabel("경로 : "));
        loc_tf = new JTextField(40);
        ok_bt = new JButton("확인");
        north_p.add(loc_tf);
        north_p.add(ok_bt);
        this.add(north_p, BorderLayout.NORTH);

        // 테이블을 위한 함수ㅜㅜ----------=-=-=-=-==-=
        //String[] Name = { "파일명", "수정날짜", "용량" };
        model = new DefaultTableModel(0, 0);//일단 빈 모델로 생성해봄
        table = new JTable(model);
        center_p = new JPanel(new BorderLayout());
        center_p.add(new JScrollPane(table));
        this.add(center_p, BorderLayout.CENTER);
        // 테스트 위해 초기 경로 설정        
        String firstPath = "c:/my_study/test/util";
        loc_tf.setText(firstPath);
        //MakeTable(firstPath); // 초기 파일 목록 로딩 함수 없어도 ㄱㅊ

        // 확인 버튼 클릭      
        ok_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = loc_tf.getText().trim();
                MakeTable(path);
            }
        });
       
        this.setBounds(300, 100, 600, 500);
        this.setVisible(true);
        
        this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//종료이ㅇㅁ
			}
		});
    }//생성자의 끝

    //  테이블 함수로
    private void MakeTable(String path) {
    File f = new File(path);
    if (!f.exists() ||  !f.isDirectory()) {
        JOptionPane.showMessageDialog(this, "디렉토리 존재 X");
        return;
    }

    File[] files = f.listFiles();
    if (files == null || files.length == 0) {
        JOptionPane.showMessageDialog(this, "파일 존재 X");
        return;
    }

    String[] Name = { "파일명", "수정날짜", "용량" };
    String[][] ar = new String[files.length][Name.length];

    for (int i = 0; i < files.length; i++) {
        File sub_file = files[i];
        try {
            Map<String, Object> att = Files.readAttributes(
                Paths.get(sub_file.getAbsolutePath()), "*");

            ar[i][0] = sub_file.getName(); // 파일명
            FileTime ft = (FileTime) att.get("lastModifiedTime");
            ar[i][1] = ft.toString(); // 수정날짜
            ar[i][2] = String.valueOf(sub_file.length()); // 용량

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    model.setDataVector(ar, Name); // 테이블에 데이터 한 번에 반영
    
}

    public static void main(String[] args) {
        new Ex9_File();
    }
}
