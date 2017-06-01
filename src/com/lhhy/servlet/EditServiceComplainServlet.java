package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.ServiceComplain;
import com.lhhy.biz.ServiceComplainBiz;

/**
 * Servlet implementation class EditServiceComplainServlet
 */
@WebServlet("/jsp/EditServiceComplainServlet")
public class EditServiceComplainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServiceComplainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		ServiceComplain q = new ServiceComplain();
		q.setServiceComplainId(Integer.parseInt(request.getParameter("serviceComplainId")));
		q.setServiceComplainCode(request.getParameter("serviceComplainCode"));
		ServiceComplainBiz biz = new ServiceComplainBiz();
		String rs = biz.editServiceComplain(q);
		PrintWriter out = response.getWriter();
		out.println(rs);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
