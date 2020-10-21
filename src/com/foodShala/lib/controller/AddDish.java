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
import com.foodShala.lib.model.Menu;

@WebServlet("/AddDish")
public class AddDish extends HttpServlet {
	Dao dao;
	public AddDish() {
		dao=new DaoImp();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String dishName= request.getParameter("dishName");
			String dishImage= request.getParameter("dishImage");
			String dishType= request.getParameter("dishType");
			int dishPrice= Integer.parseInt(request.getParameter("dishPrice"));
			
			Menu menu = new Menu(dishName, dishImage, dishType, dishPrice);		
			int i = dao.addDish(menu);
			if(i!=0) {
				JOptionPane.showMessageDialog(null, "Successfully Added");
				request.getRequestDispatcher("RestMenuDisplay").forward(request, response);
			}else {
				JOptionPane.showMessageDialog(null, "Dish error");
				request.getRequestDispatcher("RestMenuDisplay").forward(request, response);
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
