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
 * Servlet implementation class AddQuoteServlet
 */
@WebServlet("/jsp/AddQuoteServlet")
public class AddQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取表单提交数据，并封装到Quote中
		Quote q = new Quote();
		q.setQuoteDate(request.getParameter("quoteDate")); 
		q.setQuoteOrder(request.getParameter("quoteOrder"));
		q.setQuoteIndustry(request.getParameter("quoteIndustry"));
		q.setQuoteDevice(request.getParameter("quoteDevice"));
		q.setQuoteTake(request.getParameter("quoteTake"));
		q.setQuoteContent(request.getParameter("quoteContent"));
		double i=Double.parseDouble(request.getParameter("quoteNoTaxPrice"));
		q.setQuoteNoTaxPrice(i);
		q.setQuoteTaxPrice(i*1.17);
		//调用biz层的添加方法，并获得结果
		QuoteBiz biz = new QuoteBiz();
		String rs = biz.addQuote(q);
		//获得管道流，将结果打印到管道中，并发送
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
