package am;

public class empVO {
	//emp 테이블에서 필요로 하는 컬럼들을 멤버변수로 선언
	//db에서 데이터 가져오면 무조건 문자열임
	private String empno,ename,job,hiredate;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
