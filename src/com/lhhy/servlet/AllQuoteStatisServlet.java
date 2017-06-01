package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Page;
import com.lhhy.biz.QuoteStatisBiz;

/**
 * Servlet implementation class AllQuoteStatisServlet
 */
@WebServlet("/jsp/AllQuoteStatisServlet")
public class AllQuoteStatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllQuoteStatisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Page page = new Page(request.getParameter("page"),request.getParameter("rows"));
		
		PrintWriter out = response.getWriter();
		QuoteStatisBiz biz = new QuoteStatisBiz();
		String data = biz.queryAllQuoteStatis(page);
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
