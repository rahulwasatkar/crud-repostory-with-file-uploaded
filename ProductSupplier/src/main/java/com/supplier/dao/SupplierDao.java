package com.supplier.dao;

import java.util.List;

import com.supplier.entity.Supplier;

public interface SupplierDao {
	public boolean savesupplier(Supplier supllier);
	public Supplier getsupplierById(int supplierId);
	public List<Supplier> getallSupplier();

}
