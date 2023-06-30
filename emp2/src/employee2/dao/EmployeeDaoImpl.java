package employee2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import employee2.db.DBConnect;
import employee2.model.Employee;

//Dao : Repository = 비즈니스 로직 처리 -> 데이터베이스 입출력
public class EmployeeDaoImpl implements EmployeeDaoInter{
	Connection conn = null;
	PreparedStatement pstmt = null; //sql 실행

	@Override
	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO employees(userid, passwd, username, regdate, addr) VALUES(?, ?, ?, now(), ?)";
		conn = DBConnect.getConnection();
		
		try {
			//쿼리실행 : 연결 + 쿼리실행
			pstmt = conn.prepareStatement(sql);
			//getter
			pstmt.setString(1, employee.getUserid());
			pstmt.setString(2, employee.getPasswd());
			pstmt.setString(3, employee.getUsername());
			pstmt.setString(4, employee.getAddr());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("Add Employee Successfully.");
			}else {
				System.out.println("Insert Error");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void viewAllEmployee() {
		String sql = "SELECT * FROM employees ORDER BY id DESC";
		conn = DBConnect.getConnection();
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("ID\tUserid\tPasswd\tUsername\tRegdate\tAdress");
			//반복문
			while(rs.next()) {//객체 배열안에 자료를 전부 하나씩 (next()) 출력
				System.out.println("--------------------------------------------------------");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.println(rs.getString(6));
				System.out.println("--------------------------------------------------------");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void viewOneEmployee(int id) {
		String sql = "SELECT * FROM employees WHERE id = ?";
		conn = DBConnect.getConnection();
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			
			//반복문
			while(rs.next()) {//객체 배열안에 자료를 전부 하나씩 (next()) 출력
				System.out.println("--------------------------------------------------------");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.println(rs.getString(6));
				System.out.println("--------------------------------------------------------");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		


	@Override
	public void updateEmployee(Employee employee, int upID) {
		//UPDATE 테이블 SET 바꿀컬럼명=값.. WHERE id 바꿀pk
		String sql = "UPDATE employees SET userid = ?, passwd = ?, username = ?, regdate = now(), addr = ? WHERE id = ?";
		conn = DBConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getUserid());
			pstmt.setString(2, employee.getPasswd());
			pstmt.setString(3, employee.getUsername());
			pstmt.setString(4, employee.getAddr());
			pstmt.setInt(5, upID);
			
			int result = pstmt.executeUpdate(); 
			if(result != 0) {
				System.out.println("사원정보가 수정되었습니다.");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		String sql = "DELETE FROM employees WHERE id = ?";
		conn = DBConnect.getConnection();
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		if(result != 0) {
			System.out.println("사원정보가 삭제되었습니다.");
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}

}
