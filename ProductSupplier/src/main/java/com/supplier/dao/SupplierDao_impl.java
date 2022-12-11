package com.supplier.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.supplier.entity.Supplier;

@Repository
public class SupplierDao_impl implements SupplierDao {
	
	@Autowired
  SessionFactory sf;

	@Override
	public boolean savesupplier(Supplier supllier) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean isSave = false;
		try {
			Supplier supplier2 = session.get(Supplier.class,supllier.getSupllierId());
			if (supplier2 == null) {
				session.save(supllier);
				tr.commit();
				isSave = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSave;
		
	}

	@Override
	public Supplier getsupplierById(int supplierId) {
		Session session = sf.openSession();
		Supplier supplier = null;
		try {
			supplier = session.get(Supplier.class, supplierId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return supplier;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getallSupplier() {
		Session session = sf.openSession();
		List<Supplier> list = null;
		try {
			@SuppressWarnings("deprecation")
			Criteria cr = session.createCriteria(Supplier.class);

			list = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
