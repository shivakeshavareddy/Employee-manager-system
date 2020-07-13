package web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteempservlet
 */
public class deleteempservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Statement st = checkmanager.st;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteempservlet() {
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
		HttpSession session = request.getSession();
		int dssn= Integer.parseInt(request.getParameter("dssn"));
		String msg="";
		
		try {
			st.executeQuery("delete from works_on where essn="+dssn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg=e.getMessage();
			session.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("welcomeportal.jsp");
			rd.forward(request, response);
		}
		try {
			st.executeQuery("delete from dependent where essn="+dssn);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			msg =e2.getMessage();
			session.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("welcomeportal.jsp");
			rd.forward(request, response);
		}
		try {
			st.executeQuery("delete from employee where ssn="+dssn);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			msg =e2.getMessage();
			session.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("welcomeportal.jsp");
			rd.forward(request, response);
		}
	RequestDispatcher rd = request.getRequestDispatcher("welcomeportal.jsp");
	rd.forward(request, response);

}}
