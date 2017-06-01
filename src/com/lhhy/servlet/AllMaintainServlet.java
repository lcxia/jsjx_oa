package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Page;
import com.lhhy.biz.MaintainBiz;

/**
 * Servlet implementation class AllMaintainServlet
 */
@WebServlet("/jsp/AllMaintainServlet")
public class AllMaintainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMaintainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"),request.getParameter("rows"));
		response.setCharacterEncoding("utf-8");
		MaintainBiz biz = new MaintainBiz();
		String data = biz.queryAllMaintain(page);
		PrintWriter out = response.getWriter();
		out.println(data);
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
