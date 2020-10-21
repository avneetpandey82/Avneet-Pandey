package com.foodShala.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.foodShala.lib.dao.Dao;
import com.foodShala.lib.dao.DaoImp;
import com.foodShala.lib.util.DBConnection;

@WebServlet("/CustLogin")
public class CustLogin extends HttpServlet {

	static Dao dao;
	public CustLogin() {
		dao = new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String user = dao.getCustomer(username,password);
		HttpSession session = request.getSession();
		if(user!=null) {
			session.setAttribute("user", user);
			session.setAttribute("username", username);
			request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
		}else {
			request.getRequestDispatcher("RedirectCustLogin").forward(request, response);
			JOptionPane.showMessageDialog(null, "User not found");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
