package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Contract;
import com.lhhy.biz.ContractBiz;

/**
 * Servlet implementation class EditContractServlet
 */
@WebServlet("/jsp/EditContractServlet")
public class EditContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contract c = new Contract();
		c.setContractId(Integer.parseInt(request.getParameter("contractId")));
		c.setContractCode(request.getParameter("contractCode"));
		c.setContractDate(request.getParameter("contractDate"));
		c.setContractIndustry(request.getParameter("contractIndustry"));
		c.setContractDevice(request.getParameter("contractDevice"));
		c.setContractOrder("TIM-Y"+request.getParameter("quoteCen")+"-"+request.getParameter("contractOrder"));
		c.setContractComment(request.getParameter("contractComment"));

		ContractBiz biz = new ContractBiz();
		String rs = biz.editContract(c);
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
