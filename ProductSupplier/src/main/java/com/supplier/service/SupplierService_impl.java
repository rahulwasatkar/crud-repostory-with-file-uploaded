package com.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.dao.SupplierDao;
import com.supplier.entity.Supplier;

@Service
public class SupplierService_impl implements SupplierService {

	@Autowired
	SupplierDao dao;
	@Override
	public boolean savesupplier(Supplier supllier) {
	
		boolean isSave = dao.savesupplier(supllier);
		return isSave;
	}

	@Override
	public Supplier getsupplierById(int supplierId) {
Supplier supplier = dao.getsupplierById(supplierId);
		return supplier;
	}

	@Override
	public List<Supplier> getallSupplier() {
		List<Supplier> list = dao.getallSupplier();
		return list;
	}

}
