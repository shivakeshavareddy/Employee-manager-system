package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.employee;


/**
 * Servlet implementation class checkmanager
 */
public class checkmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Statement st;
	public static Connection con;
    public checkmanager() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int essn = Integer.parseInt(request.getParameter("essn"));
		employee emp = new employee();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","spothire","jokseeli");
			st = con.createStatement();
			ResultSet rs= st.executeQuery("select * from employee where superssn="+essn);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("essn", essn);
				request.setAttribute("essn", essn);
				session.setAttribute("msg", "");
				ResultSet rs2 = st.executeQuery("select * from employee where ssn="+essn);
				if (rs2.next()) {
					emp.setAddress(rs2.getString("address"));
					emp.setBdate(rs2.getString("bdate"));
					emp.setDno(rs2.getInt("dno"));
					emp.setFname(rs2.getString("fname"));
					emp.setLname(rs2.getString("lname"));
					emp.setMinit(rs2.getString("minit"));
					emp.setSalary(rs2.getInt("salary"));
					emp.setSex(rs2.getString("sex"));
					emp.setSsn(rs2.getInt("ssn"));
					emp.setSuper_ssn(rs2.getInt("superssn"));
					session.setAttribute("emp", emp);
					
				}
				ResultSet rs3 = st.executeQuery("select ssn from employee");
				ArrayList<Integer> ssnlist= new ArrayList<Integer>();
				while(rs3.next()) {
					ssnlist.add(rs3.getInt("ssn"));
				}
				session.setAttribute("ssnlist", ssnlist);
				RequestDispatcher rd =request.getRequestDispatcher("welcomeportal.jsp");
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd =request.getRequestDispatcher("invalid.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
