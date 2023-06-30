package employee2;

import java.util.Scanner;

import employee2.dao.EmployeeDaoImpl;
import employee2.db.DBConnect;
import employee2.model.Employee;

public class Employee_Ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		
		System.out.println("Welcome to Koreait Employees System Application");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl(); //입력, 수정, 삭제, 출력 -> 전역객체
		
		boolean isRun = true;
		while(isRun) {
			System.out.println("1.AddEmployee\n"
					+ "2.viewAllEmployee\n"
					+ "3.viewOneEmployee\n"
					+ "4.updateEmployee\n"
					+ "5.deleteEmployee\n"
					+ "6.Exit");
			
			System.out.println();
			System.out.print("Enter Choice > ");
			int ch = Integer.parseInt(sc.nextLine());
			
			switch(ch) {
			case 1:
				System.out.println();
				System.out.println("1.AddEmployee");
				System.out.println();
				
				System.out.println("userid > ");
				String uid = sc.nextLine();
				
				System.out.println("passwd > ");
				String pwd = sc.nextLine();
				
				System.out.println("username > ");
				String uname = sc.nextLine();
				
				System.out.println("Addr > ");
				String address = sc.nextLine();
				
				
				emp.setUserid(uid);
				emp.setPasswd(pwd);
				emp.setUsername(uname);
				emp.setAddr(address);
				
				edi.addEmployee(emp);
				
				DBConnect.getConnection();
				break;
				
			case 2:
				System.out.println();
				System.out.println("2.viewAllEmployee");
				System.out.println();
				
				edi.viewAllEmployee();
				
				break;
				
			case 3:
				System.out.println();
				System.out.println("3.viewOneEmployee");
				System.out.println();
				
				System.out.println("검색할 사원의 번호 > ");
		       	int empID = Integer.parseInt(sc.nextLine());
		        edi.viewOneEmployee(empID);
		        
				break;
				
			case 4:
				System.out.println();
				System.out.println("4.updateEmployee");
				System.out.println();
				
				System.out.println("수정할 사원의 번호 > ");
				int upID = Integer.parseInt(sc.nextLine());
				
				System.out.println("수정할 아이디 > ");
				String upUserid = sc.nextLine();
				
				System.out.println("수정할 비밀번호 > ");
				String upPwd = sc.nextLine();
				
				System.out.println("수정할 이름 > ");
				String upUname = sc.nextLine();
				
				System.out.println("수정할 주소 > ");
				String upAddr = sc.nextLine();
				
				emp.setUserid(upUserid);
				emp.setPasswd(upPwd);
				emp.setUsername(upUname);
				emp.setAddr(upAddr);
				
				edi.updateEmployee(emp, upID);

				
				break;
				
			case 5:
				System.out.println();
				System.out.println("5.deleteEmployee");
				System.out.println();
				
				System.out.println("삭제할 사원의 번호 > ");
				int delID = Integer.parseInt(sc.nextLine());
				edi.deleteEmployee(delID);
				
				break;
				
			case 6:
				System.out.println();
				System.out.println("6.프로그램 종료");
				System.exit(0);
				
			default:
				System.out.println();
				System.out.println("다시 입력해 주세요");
				System.out.println();
				break;
				
				
			}
		}
		
	}

}
