package com.main.java.project.with.spring.boot.crud.model;

import com.main.java.project.with.spring.boot.crud.entity.Product;

public class ProductSupplier {
	
	private Product product;
	private Supplier supplier;
	
	
	public ProductSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public ProductSupplier(Product product, Supplier supplier) {
		super();
		this.product = product;
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "ProductSupplier [product=" + product + ", supplier=" + supplier + "]";
	}

}
