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

@WebServlet("/Order")
public class Order extends HttpServlet {
    Dao dao;
	public Order() {
		dao = new DaoImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = JOptionPane.showConfirmDialog(null, "Want to place the order");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(i==0) {
			List<Menu> menu = dao.getCart(username);
			int x =dao.emptyCart(username);
			int order = dao.Order(menu,username);
			if(order!=0 && x!=0 ){
				JOptionPane.showMessageDialog(null, "Order done");
				request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
			}else {
				request.getRequestDispatcher("Cart").forward(request, response);
				JOptionPane.showMessageDialog(null, "Error while Ordering");
			}
		}else {
			request.getRequestDispatcher("Cart").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
