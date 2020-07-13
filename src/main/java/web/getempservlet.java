package web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.empdao;
import model.employee;


/**
 * Servlet implementation class getempservlet
 */
public class getempservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getempservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		empdao dao = new empdao();
		employee e1= dao.getemp(ssn);
		
		request.setAttribute("e1", e1);
		RequestDispatcher rd = request.getRequestDispatcher("welcomemanager.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		empdao dao = new empdao();
		employee e1= dao.getemp(ssn);
		
		request.setAttribute("e1", e1);
		RequestDispatcher rd = request.getRequestDispatcher("welcomemanager.jsp");
		rd.forward(request, response);
	}

}
