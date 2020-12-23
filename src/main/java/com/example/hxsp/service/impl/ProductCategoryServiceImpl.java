package com.example.hxsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.ProductCategory;
import com.example.hxsp.dao.ProductCategoryDao;
import com.example.hxsp.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	private ProductCategoryDao productCategoryDao;
	@Override
	public List<ProductCategory> findContentsByPid(Integer pid) {
		return productCategoryDao.selContentsByPid(pid);
	}

}
