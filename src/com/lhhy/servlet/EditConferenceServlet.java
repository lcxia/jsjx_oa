package com.lhhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhhy.bean.Conference;
import com.lhhy.biz.ConferenceBiz;

/**
 * Servlet implementation class EditConferenceServlet
 */
@WebServlet("/jsp/EditConferenceServlet")
public class EditConferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditConferenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Conference q = new Conference();
		//System.out.println(request.getParameter("ClientId"));
		q.setConferenceId(Integer.parseInt(request.getParameter("conferenceId")));
		q.setConferenceCode(request.getParameter("conferenceCode"));
		q.setConferenceDoneDate(request.getParameter("conferenceDoneDate"));

		ConferenceBiz biz = new ConferenceBiz();
		String rs = biz.editConference(q);
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
