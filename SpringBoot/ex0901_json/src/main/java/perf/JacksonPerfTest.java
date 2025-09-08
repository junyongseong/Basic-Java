package perf;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JacksonPerfTest {
    public static void main(String[] args) throws Exception {
        // 테스트용 데이터 100만 개 생성
        int size = 1_000_000;
        List<EmpVO> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new EmpVO(i, "Name" + i, "Job" + i));
        }

        ObjectMapper mapper = new ObjectMapper();

        // 1) List 직렬화
        long start1 = System.nanoTime();
        String json1 = mapper.writeValueAsString(list);
        long end1 = System.nanoTime();
        System.out.println("List 직렬화 시간: " + (end1 - start1) / 1_000_000.0 + " ms");

        // 2) Array 직렬화
        EmpVO[] arr = list.toArray(new EmpVO[0]);
        long start2 = System.nanoTime();
        String json2 = mapper.writeValueAsString(arr);
        long end2 = System.nanoTime();
        System.out.println("Array 직렬화 시간: " + (end2 - start2) / 1_000_000.0 + " ms");
    }
}

class EmpVO {
    private int empno;
    private String ename;
    private String job;

    public EmpVO(int empno, String ename, String job) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }

    // getter 필요 (Jackson 직렬화용)
    public int getEmpno() { return empno; }
    public String getEname() { return ename; }
    public String getJob() { return job; }
}
