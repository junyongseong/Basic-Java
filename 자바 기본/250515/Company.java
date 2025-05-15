package pm;

import java.util.ArrayList;

public class Company {
	ArrayList<Emp> employees =new ArrayList<>();
	Emp emp= new Emp();
	public Company()
	{
		employees.add(new Emp(001, "홍길동", "대리", "인사과"));
		employees.add(new Emp(002, "철수", "과장", "기획과"));
		employees.add(new Emp(003, "영희", "부장", "총무과"));
		employees.add(new Emp(004, "영구", "인턴", "영업과"));
	}
	
	public String search_emp(int choice, String keyword) {
	    String result = "";
	    boolean found = false;

	    for (int i = 0; i < employees.size(); i++) {
	        Emp emp = employees.get(i);
	        switch (choice) {
	            case 1:
	                try {
	                    int num = Integer.parseInt(keyword);
	                    if (emp.getCompany_num() == num) {
	                        result += printEmp(emp) + "\n";
	                        found = true;
	                    }
	                } catch (NumberFormatException e) {
	                    return "사번은 숫자만 입력해야 합니다.";
	                }
	                break;

	            case 2:
	                if (emp.getName().equals(keyword)) {
	                    result += printEmp(emp) + "\n";
	                    found = true;
	                }
	                break;

	            case 3:
	                if (emp.getPos().equals(keyword)) {
	                    result += printEmp(emp) + "\n";
	                    found = true;
	                }
	                break;

	            case 4:
	                if (emp.getDepartment().equals(keyword)) {
	                    result += printEmp(emp) + "\n";
	                    found = true;
	                }
	                break;

	            default:
	                return "잘못된 선택입니다.";
	        }
	    }

	    if (!found) {
	        result = "해당하는 직원이 없습니다.";
	    }

	    return result;
	}

	public String printEmp(Emp emp) {
	    return "사번: " + emp.getCompany_num() +
	           ", 이름: " + emp.getName() +
	           ", 직책: " + emp.getPos() +
	           ", 부서: " + emp.getDepartment();
	}

}
