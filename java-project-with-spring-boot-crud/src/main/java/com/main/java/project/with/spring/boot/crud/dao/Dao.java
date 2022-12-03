package com.main.java.project.with.spring.boot.crud.dao;

import java.util.List;

import com.main.java.project.with.spring.boot.crud.entity.Product;

public interface Dao {
	public boolean saveproduct(Product product);
	public Product getproductById(int productId);
	public List<Product> getallproduct();
	public boolean updateproduct(Product product);
	public boolean deleteproduct(int productId);
	public List<Product> getmacpriceproduct();
	public List<Product> getproductByname(String productName);
	public int saveList(List<Product> product); 
}
