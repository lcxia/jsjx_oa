package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Quote;
import com.lhhy.biz.QuoteBiz;

/**
 * Servlet implementation class EditQuoteServlet
 */
@WebServlet("/jsp/EditQuoteServlet")
public class EditQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Quote q = new Quote();
		//System.out.println(request.getParameter("quoteId"));
		q.setQuoteId(Integer.parseInt(request.getParameter("quoteId")));
		q.setQuoteDate(request.getParameter("quoteDate"));
		q.setQuoteOrder(request.getParameter("quoteOrder"));
		q.setQuoteIndustry(request.getParameter("quoteIndustry"));
		q.setQuoteDevice(request.getParameter("quoteDevice"));
		q.setQuoteTake(request.getParameter("quoteTake"));
		q.setQuoteContent(request.getParameter("quoteContent"));
		double d = Double.parseDouble(request.getParameter("quoteNoTaxPrice"));
		q.setQuoteNoTaxPrice(d);
		q.setQuoteTaxPrice(d * 1.17);

		QuoteBiz biz = new QuoteBiz();
		String rs = biz.editQuote(q);
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
