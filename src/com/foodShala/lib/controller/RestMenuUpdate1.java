package com.foodShala.lib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.foodShala.lib.dao.Dao;
import com.foodShala.lib.dao.DaoImp;
import com.foodShala.lib.model.Menu;

@WebServlet("/RestMenuUpdate1")
public class RestMenuUpdate1 extends HttpServlet {
	Dao dao;
	public RestMenuUpdate1() {
		dao = new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		List<Menu> list = dao.getItem(id);
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("Restaurants/UpdateDish.jsp").forward(request, response);
		}else {
			JOptionPane.showMessageDialog(null, "Update problem");
			request.getRequestDispatcher("RestMenuUpdate").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
