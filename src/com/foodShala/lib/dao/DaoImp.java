package com.foodShala.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.foodShala.lib.model.Customer;
import com.foodShala.lib.model.Menu;
import com.foodShala.lib.model.Restaurant;
import com.foodShala.lib.util.DBConnection;

public class DaoImp implements Dao{
	Connection connect = DBConnection.getConnection();
	PreparedStatement ps;
	String sql;
	@Override
	public int addCust(Customer customer) {
		sql="Insert into customerList(name,dob,phone,address,gender,foodType,username,password) values(?,?,?,?,?,?,?,?)";
		int id=0;
		try {
			ps=connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,customer.getName());
			ps.setString(2, customer.getDob());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getGender());
			ps.setString(6, customer.getFoodType());
			ps.setString(7, customer.getUsername());
			ps.setString(8, customer.getPassword());
			ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if (rs.next())
			{
				id=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ID Already exist");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		};
		return id;
	}
	@Override
	public String getCustomer(String username, String password) {
		String name = null;
		sql = "Select name from customerList where username=? AND password=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	@Override
	public int addRest(Restaurant restaurant) {
		sql="Insert into RestList(name,dob,phone,address,gender,username,password) values(?,?,?,?,?,?,?)";
		int id=0;
		try {
			ps=connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,restaurant.getName());
			ps.setString(2,restaurant.getDob());
			ps.setString(3,restaurant.getPhone());
			ps.setString(4,restaurant.getAddress());
			ps.setString(5,restaurant.getGender());
			ps.setString(6,restaurant.getUsername());
			ps.setString(7,restaurant.getPassword());
			ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if (rs.next())
			{
				id=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ID Already exist");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		};
		return id;
	}
	@Override
	public String getRest(String username, String password) {
		String name = null;
		sql = "Select name from RestList where username=? AND password=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return name;
		
	}
	@Override
	public List<Menu> getRestMenu() {
		List<Menu> list = new ArrayList<Menu>();
		sql = "Select * from menu";
		try {
			ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean delete(int id) {
		boolean status = false;
		sql="Delete from menu where id=?";
		try {
			ps=connect.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i!=0)
				status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int addDish(Menu menu) {
		int i = 0;
		sql = "Insert into menu(name,image,types,price) values(?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, menu.getName());
			ps.setString(2, menu.getImage());
			ps.setString(3, menu.getType());
			ps.setInt(4, menu.getPrice());
			
			i=ps.executeUpdate();
			if(i==0) {
				JOptionPane.showMessageDialog(null, "Not Added");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<Menu> getItem(int id) {
		List<Menu> list = new ArrayList<Menu>();
		sql ="Select * from menu where id =?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Menu menu = new Menu(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int updateMenu(Menu menu) {
		int i = 0;
		sql = "Update menu set name=?,image=?,types=?,price=? where id=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, menu.getName());
			ps.setString(2, menu.getImage());
			ps.setString(3, menu.getType());
			ps.setInt(4, menu.getPrice());
			ps.setInt(5, menu.getId());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}
	@Override
	public int AddtoCart(List<Menu> menu,String username) {
		int i = 0;
		sql = "Insert into cart(username,name,image,types,price) values(?,?,?,?,?)";
		try {
			ps = connect.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, username);
			ps.setString(2, menu.get(0).getName());
			ps.setString(3, menu.get(0).getImage());
			ps.setString(4, menu.get(0).getType());
			ps.setInt(5, menu.get(0).getPrice());
			
			i=ps.executeUpdate();
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public List<Menu> getCart(String username) {
		List<Menu> list = new ArrayList<Menu>();
		sql = "Select * from cart where username=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu(rs.getInt(6),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				list.add(menu);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Internal Error.");
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int getTotal(String username) {
		int sum = 0;
		sql = "Select SUM(price) from cart where username=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sum;
	}
	@Override
	public int deleteFromCart(int id) {
		System.out.println(id);
		int i=0;
		sql = "Delete from cart where id=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			i =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public int emptyCart(String username) {
		int i = 0;
		sql = "Delete from cart where username=?";
		try {
			ps =connect.prepareStatement(sql);
			ps.setString(1, username);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int Order(List<Menu> menu,String username) {
		int x=0;
		sql = "Insert into orders value(?,?,?,?,?)";
		try {
			for(int i=0;i<menu.size();i++) {
				ps = connect.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, menu.get(i).getName());
				ps.setString(3, menu.get(i).getImage());
				ps.setString(4, menu.get(i).getType());
				ps.setInt(5, menu.get(i).getPrice());
				x = ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	@Override
	public List<Menu> getOrderList(String username) {
		List<Menu> order = new ArrayList<Menu>();
		sql = "Select * from orders where username=?";
		try {
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				order.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
