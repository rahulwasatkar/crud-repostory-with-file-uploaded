package com.main.java.project.with.spring.boot.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Product {
	
	@Id
	@Min(1)
	private int productId;
	@NotNull(message = "Product name should not empty..")
	private String productName;
	@Min(1)
	private double productPrice;
	@NotNull(message="product type must be present...")
	private String productType;
	private int supllierId;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getSupllierId() {
		return supllierId;
	}

	public void setSupllierId(int supllierId) {
		this.supllierId = supllierId;
	}

	public Product(@Min(1) int productId, @NotNull(message = "Product name should not empty..") String productName,
			@Min(1) double productPrice, @NotNull(message = "product type must be present...") String productType,
			int supllierId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.supllierId = supllierId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productType=" + productType + ", supllierId=" + supllierId + "]";
	}
	
	}

