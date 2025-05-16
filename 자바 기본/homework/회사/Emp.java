package homework;

public class Emp {
	private String empno, ename, position, dept;

	public Emp(String empno, String ename, String position, String dept) {
		this.empno = empno;
		this.ename = ename;
		this.position = position;
		this.dept = dept;
	}
	public Emp() {}

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
