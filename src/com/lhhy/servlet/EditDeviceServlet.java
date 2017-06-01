package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Device;
import com.lhhy.biz.DeviceBiz;

/**
 * Servlet implementation class EditDeviceServlet
 */
@WebServlet("/jsp/EditDeviceServlet")
public class EditDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Device d = new Device();
		d.setDeviceId(Integer.parseInt(request.getParameter("deviceId")));
		d.setDeviceCode(request.getParameter("deviceCode"));

		DeviceBiz biz = new DeviceBiz();
		String rs = biz.editDevice(d);
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
