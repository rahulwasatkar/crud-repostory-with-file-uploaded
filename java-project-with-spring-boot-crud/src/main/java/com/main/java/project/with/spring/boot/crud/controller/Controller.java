package com.main.java.project.with.spring.boot.crud.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.java.project.with.spring.boot.crud.entity.Product;
import com.main.java.project.with.spring.boot.crud.exception.ProductAlreadyExistExceptions;
import com.main.java.project.with.spring.boot.crud.exception.ProductNotfoundException;
import com.main.java.project.with.spring.boot.crud.model.ProductSupplier;
import com.main.java.project.with.spring.boot.crud.service.ServiceLayer;
import com.main.java.project.with.spring.boot.crud.service.ServiceLayer;

@RestController
@RequestMapping("/product")
public class Controller {

	@Autowired
	private ServiceLayer service;

	@PostMapping("/saveproduct")
	public ResponseEntity<Boolean> saveproduct(@Valid @RequestBody Product product) {
		boolean isSave = service.saveproduct(product);
		if (isSave) {
			return new ResponseEntity<Boolean>(isSave, HttpStatus.CREATED);
		} else {
			throw new ProductAlreadyExistExceptions("product allready exist with Id = " + product.getProductId());
		}

	}

	@GetMapping("/getproduct/{productId}")
	public ResponseEntity<Product> getproductById(@PathVariable int productId) {
		Product product = service.getproductById(productId);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);

		} else {
			throw new ProductNotfoundException("product not found for id = " + productId);
		}
	}

	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getallProduct() {
		List<Product> list = service.getallproduct();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.OK);
		}
	}

	@PutMapping("/updateproduct")
	public ResponseEntity<Boolean> updateProduct(@Valid @RequestBody Product product) {
		boolean isUpdate = service.updateproduct(product);
		if (isUpdate) {
			return new ResponseEntity<Boolean>(isUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isUpdate, HttpStatus.OK);
		}
	}

	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable int productId) {
		boolean isDeleted = service.deleteproduct(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}
	}

	@GetMapping("/getmaxprice")
	public ResponseEntity<List<Product>> getmaxpriceproduct() {
		List<Product> list = service.getmacpriceproduct();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.OK);
		}
	}

	@GetMapping("/getproductbyname")
	public ResponseEntity<List<Product>> getproductbyName(@RequestParam String productName) {
		List<Product> list = service.getproductByname(productName);
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PostMapping("/getfile")
	public ResponseEntity<String> saveproductfromfile(@RequestParam MultipartFile file, HttpSession session) {
		String totalcount = service.getfile(file, session);

		return new ResponseEntity<String>(totalcount, HttpStatus.OK);
	}
	
	@GetMapping("/getproductsupplier/{productId}")
	public ResponseEntity<ProductSupplier> getProductSupplier(@PathVariable int productId){
		ProductSupplier productSupplier = service.getProductWithSupplier(productId);
		if(productSupplier!=null) {
		return new ResponseEntity<ProductSupplier>(productSupplier,HttpStatus.OK);
	}else {
		return new ResponseEntity<ProductSupplier>(HttpStatus.OK);
	}
	}
}
