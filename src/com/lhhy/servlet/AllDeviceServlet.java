package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Page;
import com.lhhy.biz.DeviceBiz;

/**
 * Servlet implementation class AllDeviceServlet
 */
@WebServlet("/jsp/AllDeviceServlet")
public class AllDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page page = new Page(request.getParameter("page"),request.getParameter("rows"));
		//从响应中提取管道流
		PrintWriter out = response.getWriter();
		DeviceBiz biz = new DeviceBiz();
		//获取数据
		String data = biz.queryAllDevice(page);
		//将数据打印到管道中并发送
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
