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

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	Dao dao;
	public AddToCart() {
		dao = new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		int i=0;
		if(username!=null) {
		
			int id = Integer.parseInt(request.getParameter("id"));
			List<Menu> menu = dao.getItem(id);
			i = dao.AddtoCart(menu,username);
		}else {
			request.getRequestDispatcher("RedirectCustLogin").forward(request, response);
			JOptionPane.showMessageDialog(null, "You need to login first");
			return;
		}
		if(i!=0) {
			
			request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
			JOptionPane.showMessageDialog(null, "Successfully Added");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
