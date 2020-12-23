package com.example.hxsp.service;

import java.util.List;

import com.example.hxsp.bean.ProductCategory;

public interface ProductCategoryService {

	/**
	 * 获取该级的次级目录
	 * @param pid 父级id
	 * @return
	 */
	List<ProductCategory> findContentsByPid(Integer pid);

}
