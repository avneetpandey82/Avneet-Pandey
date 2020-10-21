package com.foodShala.lib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.foodShala.lib.dao.Dao;
import com.foodShala.lib.dao.DaoImp;
import com.foodShala.lib.model.Menu;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	
	Dao dao;

	public Cart() {
		dao = new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String username = (String)session.getAttribute("username");
		List<Menu> menu = dao.getCart(username);
		int sum = dao.getTotal(username);
		if(!menu.isEmpty()) {
			session.setAttribute("menu", menu);
			session.setAttribute("sum", sum);
			request.getRequestDispatcher("Customers/Cart.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
			JOptionPane.showMessageDialog(null, "List is empty");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
