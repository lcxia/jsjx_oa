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
 * Servlet implementation class AddContractServlet
 */
@WebServlet("/jsp/AddContractServlet")
public class AddContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取表单提交数据，并封装到Contract中
		Contract c = new Contract();
		c.setContractCode(request.getParameter("contractCode"));
		c.setContractDate(request.getParameter("contractDate"));
		c.setContractIndustry(request.getParameter("contractIndustry"));
		c.setContractDevice(request.getParameter("contractDevice"));
		c.setContractOrder("TIM-Y"+request.getParameter("quoteCen")+"-"+request.getParameter("contractOrder"));
		c.setContractComment(request.getParameter("contractComment"));
		//调用biz层的添加方法，并获得结果
		ContractBiz biz = new ContractBiz();
		String rs = biz.addContract(c);
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
