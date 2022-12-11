package com.main.java.project.with.spring.boot.crud.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.main.java.project.with.spring.boot.crud.entity.Product;
import com.main.java.project.with.spring.boot.crud.model.ProductSupplier;

public interface ServiceLayer {
	public boolean saveproduct(Product product);
	public Product getproductById(int productId);
	public List<Product> getallproduct();
	public boolean updateproduct(Product product);
	public boolean deleteproduct(int productId);
	public List<Product> getmacpriceproduct();
	public List<Product> getproductByname(String productName);
	public String getfile(MultipartFile file,HttpSession session);
    public ProductSupplier getProductWithSupplier(int productId);

}
