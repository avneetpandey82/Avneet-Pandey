package com.foodShala.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.foodShala.lib.dao.Dao;
import com.foodShala.lib.dao.DaoImp;

@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	Dao dao;
	public DeleteFromCart() {
		dao = new DaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int i = dao.deleteFromCart(id);
		System.out.println(i+"DeleteCart");
		if(i!=0) {
			JOptionPane.showMessageDialog(null, "Deleted from Cart");
			request.getRequestDispatcher("Cart").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "Error in deleting from Cart");
			request.getRequestDispatcher("DeleteFromCart").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
