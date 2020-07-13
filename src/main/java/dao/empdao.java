package dao;

import model.employee;
import java.sql.*;
public class empdao {
public employee getemp(int ssn) {
	employee emp = new employee();
//	System.out.println(ssn);
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spothire","jokseeli");
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery("select * from employee where ssn="+ssn);
		if (rs.next()) {
			emp.setAddress(rs.getString("address"));
			emp.setBdate(rs.getString("bdate"));
			emp.setDno(rs.getInt("dno"));
			emp.setFname(rs.getString("fname"));
			emp.setLname(rs.getString("lname"));
			emp.setMinit(rs.getString("minit"));
			emp.setSalary(rs.getInt("salary"));
			emp.setSex(rs.getString("sex"));
			emp.setSsn(rs.getInt("ssn"));
			emp.setSuper_ssn(rs.getInt("super_ssn"));
			System.out.println(emp);
		con.close();
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	return emp;
		
		
	}

}
