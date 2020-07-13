package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.employee;
import model.projectmodel;

/**
 * Servlet implementation class worksonservlet
 */
public class worksonservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public worksonservlet() {
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
			//projectmodel p= new projectmodel();
//			List <projectmodel> list_prjkt= new ArrayList<projectmodel>();
			employee e1 = new employee();
			Statement st =(Statement) request.getAttribute("st");
			ResultSet rs =st.executeQuery("select * from project where dno="+request.getParameter("dno"));
			while(rs.next()) {
				projectmodel p= new projectmodel();
				p.setDnum(rs.getInt("dnum"));
				p.setPlocation(rs.getString("plocation"));
				p.setPname(rs.getString("pname"));
				p.setPno(rs.getInt("pno"));
				request.setAttribute("prjkt", p);
//				list_prjkt.add(p);
			}
			System.out.println();
			e1.setSsn(Integer.parseInt(request.getParameter("ssn")));
			e1.setFname(request.getParameter("fname"));
			e1.setMinit(request.getParameter("minit"));
			e1.setLname(request.getParameter("lname"));
			e1.setAddress(request.getParameter("address"));
			e1.setBdate(request.getParameter("bdate"));
			e1.setDno(Integer.parseInt(request.getParameter("dno")));
			e1.setSuper_ssn(Integer.parseInt(request.getParameter("superssn")));
			e1.setSalary(Integer.parseInt(request.getParameter("salary")));
			e1.setSex(request.getParameter("sex"));
			request.setAttribute("e1", e1);
//			request.setAttribute("list_prjkt", list_prjkt);
			RequestDispatcher rd =request.getRequestDispatcher("workson.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error is in con");
			System.out.println(e.getStackTrace());
		}
		
	}

}
