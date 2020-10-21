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
import com.foodShala.lib.model.Customer;

@WebServlet("/CustRegistration")
public class CustRegistration extends HttpServlet {
	
	static Dao dao;
	public CustRegistration() {
		dao = new DaoImp();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String phone = request.getParameter("pnumber");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String foodType = request.getParameter("preference");
			String username = request.getParameter("uname");
			String password = request.getParameter("password");
			
			Customer customer = new Customer(name, dob, phone, address,gender, foodType, username, password);
			int i = dao.addCust(customer);
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			
			if(i!=0) {
				request.getRequestDispatcher("CustMenuDisplay").forward(request, response);
			}else {
				request.getRequestDispatcher("CustRegistration").forward(request, response);
				JOptionPane.showMessageDialog(null, "Internal Error. Try After Sometime");
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
