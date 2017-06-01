package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Evection;
import com.lhhy.biz.EvectionBiz;

/**
 * Servlet implementation class EditEvectionServlet
 */
@WebServlet("/jsp/EditEvectionServlet")
public class EditEvectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEvectionServlet() {
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

		Evection e = new Evection();
		//System.out.println(request.getParameter("evectionId"));
		e.setEvectionId(Integer.parseInt(request.getParameter("evectionId")));
		e.setEvectionName(request.getParameter("evectionName"));
		e.setEvectionPlace(request.getParameter("evectionPlace"));
		e.setEvectionOut(request.getParameter("evectionOut"));
		e.setEvectionBack(request.getParameter("evectionBack"));
		e.setEvectionComment(request.getParameter("evectionComment"));

		EvectionBiz biz = new EvectionBiz();
		String rs = biz.editEvection(e);
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
