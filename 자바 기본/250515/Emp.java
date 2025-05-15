package pm;

public class Emp {
	private int company_num;//사번
	private String name;//이름
	private String pos;//직책
	private String department;//부서
		
	public Emp(int company_num, String name, String pos, String department) {
		this.company_num = company_num;
		this.name = name;
		this.pos = pos;
		this.department = department;
	}//생성자
	
	public Emp(){//기본생성자
	}
	public int getCompany_num() {
		return company_num;
	}
	public void setCompany_num(int company_num) {
		this.company_num = company_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
