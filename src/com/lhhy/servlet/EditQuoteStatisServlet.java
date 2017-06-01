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
 * Servlet implementation class EditQuoteStatisServlet
 */
@WebServlet("/jsp/EditQuoteStatisServlet")
public class EditQuoteStatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuoteStatisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		QuoteStatis q = new QuoteStatis();
		//System.out.println(request.getParameter("quoteStatisId"));
		q.setQuoteStatisId(Integer.parseInt(request.getParameter("quoteStatisId")));
		q.setClientName(request.getParameter("clientName"));
		q.setClientType(request.getParameter("clientType"));
		q.setQuoteStatisDate(request.getParameter("quoteStatisDate"));


		QuoteStatisBiz biz = new QuoteStatisBiz();
		String rs = biz.editQuoteStatis(q);
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
