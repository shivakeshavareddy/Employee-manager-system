package web;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
 * Servlet implementation class page3servlet
 */
public class page3servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Statement st = checkmanager.st;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page3servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		works_on w1 =new works_on();
		System.out.println(request.getParameter("dependents")+"lol");
		String h[]= request.getParameterValues("nondepartmentHours");

		for(String p: h) {
			System.out.println(p);
		}
		System.out.println(request.getParameter("ssn")+"ssn");
		if(request.getParameter("dependents").contentEquals("yes")) {
//			w1.setEssn(Integer.parseInt(request.getParameter("essn")));
//			System.out.println(request.getParameterValues("dproject"));
//			for(int i=0;1<request.getParameterValues("departmenthours").length;i++) {
//				
//				System.out.println(request.getParameterValues("departmenthours"));
//			}
//			for(int j=0; j<request.getParameterValues("nondepartmenthours").length;j++) {
//				System.out.println(request.getParameterValues("nondepartmenthours"));
//			}
			RequestDispatcher rd = request.getRequestDispatcher("dependents.jsp");
			rd.forward(request, response);
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			HttpSession session =request.getSession();
			employee e1 = (employee) session.getAttribute("e1");
			System.out.println(e1);
			int ssn =e1.getSsn();
			ArrayList<works_on> works_list = new ArrayList<works_on>();
			System.out.println(request.getParameter("dependents")+"lol");
			String dh[]= request.getParameterValues("departmentHours");
			String ndh[]= request.getParameterValues("nondepartmentHours");
			String dprjkts[]=request.getParameterValues("dproject");
			String ndprjkts[] =request.getParameterValues("project");
			for(String p: dh) {
				System.out.println(p);
			}
			System.out.println(ssn);
			if(request.getParameter("dependents").contentEquals("yes")) {
				for(int i=0;i<dh.length;i++) {
					works_on w1 =new works_on();
					w1.setEssn(ssn);
				w1.setHours(Float.parseFloat(dh[i]));
				w1.setPno(Integer.parseInt(dprjkts[i]));
				works_list.add(w1);
				}
				for(int j=0; j<ndh.length;j++) {
					works_on w1 =new works_on();
					w1.setEssn(ssn);
				w1.setHours(Float.parseFloat(ndh[j]));
				w1.setPno(Integer.parseInt(ndprjkts[j]));
				works_list.add(w1);
				}
				session.setAttribute("wlist", works_list);
				RequestDispatcher rd = request.getRequestDispatcher("dependents.jsp");
				rd.forward(request, response);
			}else {
				for(int i=0;i<dh.length;i++) {
					works_on w1 =new works_on();
					w1.setEssn(ssn);
				w1.setHours(Float.parseFloat(dh[i]));
				w1.setPno(Integer.parseInt(dprjkts[i]));
				works_list.add(w1);
				
				}
				for(int j=0; j<ndh.length;j++) {
					works_on w1 =new works_on();
					w1.setEssn(ssn);
				w1.setHours(Float.parseFloat(ndh[j]));
				w1.setPno(Integer.parseInt(ndprjkts[j]));
				works_list.add(w1);
				}
				ArrayList<dependentsmodel> dlist = new ArrayList<dependentsmodel>();
//				dependentsmodel d =new dependentsmodel();
//				dlist.add(d);
				session.setAttribute("wlist", works_list);
				session.setAttribute("dlist", dlist);
				RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
				rd.forward(request, response);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
