package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.EmpDao;
import com.pojo.Emp;


@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	Emp e = new Emp();
	EmpDao ed = new EmpDao();
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			boolean b = ed.deleteEmp(id);
			if(b)
			{
				response.sendRedirect("EmpServlet");
			}
		}
		else if(action!=null && action.equals("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Emp e = ed.getEmpById(id);
			session.setAttribute("e", e);
			response.sendRedirect("updateEmp.jsp");
		}
		
		else
		{
			List<Emp> el = ed.getEmpList();
			session.setAttribute("elist", el);
			response.sendRedirect("emplist.jsp");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		Emp e = new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		System.out.println(e);
		if(action!=null && action.equals("addEmp"))
		{
			boolean b = ed.addEmp(e);
			if(b)
			{
				 
				 out.print("<p>Record saved successfully!</p>");  
		            request.getRequestDispatcher("index.jsp").include(request, response);   
			}
			else
			{
				out.print("Sorry unable to save record");
			}
		}
		
		else if(action!=null && action.equals("updateEmp"))
		{
			/*int id1=Integer.parseInt(request.getParameter("id"));
			e.setId(id1);*/
			boolean b = ed.updateEmp(e);
			if(b) {
				response.sendRedirect("EmpServlet");

			}
		}
		
			
	}

}
