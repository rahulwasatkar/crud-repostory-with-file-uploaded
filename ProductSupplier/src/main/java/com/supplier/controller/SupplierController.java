package com.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.entity.Supplier;
import com.supplier.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;

	@PostMapping("/savesupplier")
	public ResponseEntity<Boolean> savesupplier( @RequestBody Supplier supplier) {
		boolean isSave = service.savesupplier(supplier);
		if (isSave) {
			return new ResponseEntity<Boolean>(isSave, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		}

	}

	@GetMapping("/getsupplier/{supplierId}")
	public ResponseEntity<Supplier> getproductById(@PathVariable int supplierId) {
		Supplier supplier = service.getsupplierById(supplierId);
		if (supplier != null) {
			return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);

		} else {
			 return new ResponseEntity<Supplier>(HttpStatus.OK);
		}
	}

	@GetMapping("/getallsupplier")
	public ResponseEntity<List<Supplier>> getallProduct() {
		List<Supplier> list = service.getallSupplier();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Supplier>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Supplier>>(HttpStatus.OK);
		}
	}



}
