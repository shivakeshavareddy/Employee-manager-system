package part1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class parta {

	  Statement st;
	
	public parta() throws  SQLException, ClassNotFoundException {
		
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spothire","jokseeli");
		 st = con.createStatement();
			
		 ResultSet rs= st.executeQuery(" select lname,ssn from employee where dno in (select dnumber from department where dname='Research')");
			while(rs.next()) {
				
				System.out.print(rs.getString("lname")+"\t");
				System.out.println(rs.getInt("ssn"));
			}
			
			ResultSet rs2 = st.executeQuery("Select e.lname,e.ssn,w.hours from employee e natural join works_on w where e.ssn= w.essn and w.pno in (select p.pnumber from dept_locations d natural join project p where p.Pname='ProductZ' and d.dnumber=p.dnum and d.dlocation='Houston')");
			System.out.println("second query");
			while(rs2.next()) {
				
				System.out.print(rs2.getString("lname")+"\t");
				System.out.print(rs2.getInt("ssn")+"\t");
				System.out.println(rs2.getInt("hours"));}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		parta ans= new parta();
		
	}
}

