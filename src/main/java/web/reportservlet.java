package web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dependentsmodel;
import model.employee;
import model.works_on;

/**
 * Servlet implementation class reportservlet
 */
public class reportservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Statement st = checkmanager.st;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportservlet() {
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
		HttpSession session = request.getSession();
		
		employee e1 =(employee) session.getAttribute("e1");
		ArrayList<works_on> wlist = (ArrayList<works_on>) session.getAttribute("wlist");
		ArrayList<dependentsmodel> dlist = (ArrayList<dependentsmodel>) session.getAttribute("dlist");
		String sql1="insert into employee values "+e1.toString();
		
		try {
			System.out.println(sql1);
			st.executeQuery(sql1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("emp");
		}
		try {
			for( works_on w:wlist) {
			
				st.executeQuery("insert into works_on values"+w.toString());
				System.out.println("insert into works_on values"+w.toString());
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("works");
			}
		
		try {for( dependentsmodel d:dlist) {
				System.out.println("insert into dependent values"+d.toString());
				st.executeQuery("insert into dependent values"+d.toString());
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("de");
			}
		RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		}
		
	}


