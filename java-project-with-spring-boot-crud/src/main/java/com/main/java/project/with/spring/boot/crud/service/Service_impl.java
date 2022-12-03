package com.main.java.project.with.spring.boot.crud.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.main.java.project.with.spring.boot.crud.dao.DaoLayer;
import com.main.java.project.with.spring.boot.crud.entity.Product;

@Service
public class Service_impl implements ServiceLayer {
	@Autowired
	DaoLayer dao;
	int shitCount = 0;

	@Override
	public boolean saveproduct(Product product) {
		boolean isave = dao.saveproduct(product);
		return isave;
	}

	@Override
	public Product getproductById(int productId) {
		Product product = dao.getproductById(productId);
		System.out.println(product);
		return product;
	}

	@Override
	public List<Product> getallproduct() {
		List<Product> product = dao.getallproduct();
		return product;
	}

	@Override
	public boolean updateproduct(Product product) {
		boolean isUpdated = dao.updateproduct(product);
		return isUpdated;
	}

	@Override
	public boolean deleteproduct(int productId) {
		boolean isDeleted = dao.deleteproduct(productId);
		return isDeleted;
	}

	@Override
	public List<Product> getmacpriceproduct() {

		return dao.getmacpriceproduct();
	}

	@Override
	public List<Product> getproductByname(String productName) {

		return dao.getproductByname(productName);
	}

	public List<Product> readData(String path) {
		Product product = null;
		List<Product> list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			shitCount = sheet.getLastRowNum();
			Iterator<Row> rows = sheet.rowIterator();
			int cnt = 0;

			while (rows.hasNext()) {
				product = new Product();
				Row row = rows.next();
				if (cnt == 0) {
					cnt++;
					continue;
				}

				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {

					Cell cell = cells.next();

					int col = cell.getColumnIndex();
					switch (col) {
					case 0: {

						product.setProductId((int) cell.getNumericCellValue());
					}

						break;
					case 1: {
						product.setProductName(cell.getStringCellValue());
					}

						break;
					case 2: {
						product.setProductPrice(cell.getNumericCellValue());
					}

						break;
					case 3: {
						product.setProductType(cell.getStringCellValue());
					}

						break;

					default:
						break;
					}

				}
				list.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public String getfile(MultipartFile file, HttpSession session) {
		int count = 0;
		String filename = file.getOriginalFilename();
		System.out.println(filename);
		String path = session.getServletContext().getRealPath("/uploaded");
		try {
			byte[] data = file.getBytes();
			FileOutputStream fos = new FileOutputStream(new File(path + File.separator + filename));
			fos.write(data);
			List<Product> list = readData(path + File.separator + filename);

			count = dao.saveList(list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "total sheetcount  ="+shitCount +"and total record inserted = "+count;
	}

}
