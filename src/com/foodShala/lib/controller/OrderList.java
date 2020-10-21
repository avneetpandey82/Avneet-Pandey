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

@WebServlet("/OrderList")
public class OrderList extends HttpServlet {
	Dao dao;
	public OrderList() {
	dao = new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		List<Menu> orders = dao.getOrderList(username);
		session.setAttribute("orderList", orders);
		if(!orders.isEmpty())
			request.getRequestDispatcher("Customers/Orders.jsp").forward(request, response);
		else {
			JOptionPane.showMessageDialog(null, "List is Empty");
			request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
