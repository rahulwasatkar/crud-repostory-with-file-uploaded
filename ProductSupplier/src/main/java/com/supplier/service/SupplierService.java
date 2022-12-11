package com.supplier.service;

import java.util.List;


import com.supplier.entity.Supplier;


public interface SupplierService {
	
	public boolean savesupplier(Supplier supllier);
	public Supplier getsupplierById(int supplierId);
	public List<Supplier> getallSupplier();
	

}
