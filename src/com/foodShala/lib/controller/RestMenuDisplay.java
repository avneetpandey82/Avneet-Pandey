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

@WebServlet("/RestMenuDisplay")
public class RestMenuDisplay extends HttpServlet {
	
	Dao dao;
	
	public RestMenuDisplay() {
		dao= new DaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Menu> list= dao.getRestMenu();
		if (list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("Restaurants/AddMenu.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null,"List is empty");
			request.getRequestDispatcher("Restaurants/AddMenu.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
