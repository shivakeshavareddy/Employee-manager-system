package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.employee;
import model.projectmodel;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Statement st = checkmanager.st;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			employee e1= new employee();
			ArrayList<projectmodel>pl = new ArrayList<projectmodel>();
			ArrayList<projectmodel>np = new ArrayList<projectmodel>();
			e1.setAddress(request.getParameter("address"));
			e1.setBdate(request.getParameter("bdate"));
			e1.setDno(Integer.parseInt(request.getParameter("dno")));
			e1.setFname(request.getParameter("fname"));
			e1.setLname(request.getParameter("lname"));
			e1.setMinit(request.getParameter("minit"));
			e1.setSalary(Integer.parseInt(request.getParameter("salary")));
			e1.setSex(request.getParameter("sex"));
			e1.setSsn(Integer.parseInt(request.getParameter("ssn")));
			e1.setSuper_ssn(Integer.parseInt(request.getParameter("superssn")));
			e1.setEmail(request.getParameter("email"));
			HttpSession session=request.getSession();
			session.setAttribute("e1", e1);
			request.setAttribute("e1", e1);
			request.setAttribute("st", st);
			ResultSet rs =st.executeQuery("select * from project where dnum="+request.getParameter("dno"));
			while(rs.next()) {
				projectmodel p= new projectmodel();
				p.setDnum(rs.getInt("dnum"));
				p.setPlocation(rs.getString("plocation"));
				p.setPname(rs.getString("pname"));
				p.setPno(rs.getInt("pnumber"));
			pl.add(p);
			}
			ResultSet rs1 =st.executeQuery("select * from project where dnum !="+request.getParameter("dno"));
			while(rs1.next()) {
				projectmodel p= new projectmodel();
				p.setDnum(rs1.getInt("dnum"));
				p.setPlocation(rs1.getString("plocation"));
				p.setPname(rs1.getString("pname"));
				p.setPno(rs1.getInt("pnumber"));
			np.add(p);
			}
			request.setAttribute("np", np);
			request.setAttribute("pl", pl);
			RequestDispatcher rd =request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lol");
			System.out.println(e.getMessage());
		}
	}

}
