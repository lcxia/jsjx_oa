package com.lhhy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhhy.bean.Employee;
import com.lhhy.biz.EmployeeBiz;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("employeeName");
		String pass = request.getParameter("employeePass");
		
		EmployeeBiz biz = new EmployeeBiz();
		Employee e = biz.queryEmployee(name, pass);
		HttpSession session = request.getSession();
		if(e==null){
			session.setAttribute("msg", "用户名或密码错误");
			response.sendRedirect("index.jsp");
		}
		else{
			session.setAttribute("user",e);
			session.setAttribute("msg","");
			response.sendRedirect("/jsjx_oa/jsp/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
