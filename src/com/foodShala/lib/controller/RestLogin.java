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

@WebServlet("/RestLogin")
public class RestLogin extends HttpServlet {
	Dao dao;
	public RestLogin() {
		dao = new DaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String names = dao.getRest(username,password);
		System.out.println(names);
		HttpSession session = request.getSession();
		if(names!=null) {
			session.setAttribute("names", names);
			request.getRequestDispatcher("RestMenuDisplay").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "Login Failed. Retry");
			request.getRequestDispatcher("RedirectRestLogin").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
