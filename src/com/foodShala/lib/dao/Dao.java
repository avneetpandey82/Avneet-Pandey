package com.foodShala.lib.dao;

import java.util.List;

import com.foodShala.lib.model.Customer;
import com.foodShala.lib.model.Menu;
import com.foodShala.lib.model.Restaurant;

public interface Dao {

	public int addCust(Customer customer);

	public String getCustomer(String username, String password);

	public int addRest(Restaurant restaurant);

	public String getRest(String username, String password);

	public List<Menu> getRestMenu();

	public boolean delete(int id);

	public int addDish(Menu menu);

	public List<Menu> getItem(int id);

	public int updateMenu(Menu menu);

	public int AddtoCart(List<Menu> menu, String username);

	public List<Menu> getCart(String username);

	public int getTotal(String username);

	public int deleteFromCart(int id);

	public int emptyCart(String username);

	public int Order(List<Menu> menu,String username);

	public List<Menu> getOrderList(String username);
	
}
