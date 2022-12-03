package com.main.java.project.with.spring.boot.crud.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.java.project.with.spring.boot.crud.entity.Product;

@Repository
public class DaoLayer implements Dao {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean saveproduct(Product product) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean isSave = false;
		try {
			Product product2 = session.get(Product.class, product.getProductId());
			if (product2 == null) {
				session.save(product);
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
	public Product getproductById(int productId) {
		Session session = sf.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public List<Product> getallproduct() {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria cr = session.createCriteria(Product.class);

			list = cr.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public boolean updateproduct(Product product) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean isUpdate = false;
		try {
			Product product2 = session.get(Product.class, product.getProductId());
			session.evict(product2);
			if (product2 != null) {
				session.update(product);
				tr.commit();
				isUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdate;
	}

	@Override
	public boolean deleteproduct(int productId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product product = session.get(Product.class, productId);

			session.delete(product);
			tr.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public List<Product> getmacpriceproduct() {
		Session session = sf.openSession();
		List<Product> list1 = null;
		double maxprice = 0;
		try {
			Criteria cr = session.createCriteria(Product.class);
			Criteria cr1 = session.createCriteria(Product.class);
			cr.setProjection(Projections.max("productPrice"));
			List<Double> list = cr.list();
			maxprice = list.get(0);
			cr1.add(Restrictions.eq("productPrice", maxprice));
			list1 = cr1.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list1;
	}

	@Override
	public List<Product> getproductByname(String productName) {
		Session session = sf.openSession();
		List<Product> list = null;
		List<Product> list1 = null;
		try {
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productName", productName));
			list = cr.list();
		} catch (Exception e) {

		} finally {

		}
		return list;
	}

	@Override
	public int saveList(List<Product> list) {
		int cnt = 0;
		for (Product product : list) {
			boolean isadded = saveproduct(product);
			if (isadded) {
				cnt++;
			}
		}

		return cnt;
	}

}
