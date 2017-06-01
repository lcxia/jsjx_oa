package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.QuoteStatis;
import com.lhhy.biz.QuoteStatisBiz;

/**
 * Servlet implementation class AddQuoteStatisServlet
 */
@WebServlet("/jsp/AddQuoteStatisServlet")
public class AddQuoteStatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuoteStatisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QuoteStatis q = new QuoteStatis();
		q.setClientName(request.getParameter("clientName"));
		q.setClientType(request.getParameter("clientType"));
		q.setQuoteStatisDate(request.getParameter("QuoteStatisDate"));;
		
		QuoteStatisBiz biz = new QuoteStatisBiz();
		String rs = biz.addQuoteStatis(q);
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
