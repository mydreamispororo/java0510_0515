package employee2.dao;

import employee2.model.Employee;

public interface EmployeeDaoInter {
	//본체 없습니다. -> 사용하는 쪽에서는 강제 오버라이드
	//CRUD -> INSERT, SELECT, UPDATE, DELETE
	//insert into 테이블 이름 values(아이디, 비번, 이름, 시간, 주소...);
	public void addEmployee(Employee employee);
	
	//전체보기 select * from 테이블이름
	public void viewAllEmployee();
	
	//사용자정보 상세보기 : select * FROM 테이블이름 WHERE userid = 'koreait';
	public void viewOneEmployee(int id);
	
	//UPDATE 테이블명 set 컬럼명 = 값 WHERE userid = 'koreait';
	public void updateEmployee(Employee employee, int upID);
	
	//DELETE FROM 테이블명 WHERE userid = 'koreait'
	public void deleteEmployee(int id);
}
