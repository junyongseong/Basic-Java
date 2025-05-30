package pm;

import java.io.Serializable;

public class Ex6_Emp implements Serializable{
	String empno,ename,pos,hire_date,deptno;//사번,이름,직책,입사일,부서코드

	public Ex6_Emp(String empno, String ename, String pos,
			String hire_date, String deptno) {
		
		this.empno = empno;
		this.ename = ename;
		this.pos = pos;
		this.hire_date = hire_date;
		this.deptno = deptno;
	
	}
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

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

}
	
	

