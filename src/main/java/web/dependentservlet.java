package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dependentsmodel;
import model.employee;

/**
 * Servlet implementation class dependentservlet
 */
public class dependentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dependentservlet() {
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
		HttpSession session =request.getSession();
		employee e1 = (employee) session.getAttribute("e1");
		
		ArrayList<dependentsmodel> dlist = new ArrayList<dependentsmodel>();
		String dependentsname [] = request.getParameterValues("dependentname");
		String dsex[]=request.getParameterValues("dependentsex");
		String dbdate[]=request.getParameterValues("dependentbdate");
		String drelationship[]=request.getParameterValues("dependentrealtionship");
		
//		for(String x:dependentsname) {
//			System.out.println(x);
//		}
		
		
		for(int i= 0;i<dependentsname.length;i++) {
			dependentsmodel d= new dependentsmodel();
			d.setBdate(dbdate[i]);
			d.setDependentname(dependentsname[i]);
			d.setEss(e1.getSsn());
			d.setRelationship(drelationship[i]);
			d.setSex(dsex[i]);
			dlist.add(d);
		}
		session.setAttribute("dlist", dlist);
		RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
		rd.forward(request, response);
	}

}
