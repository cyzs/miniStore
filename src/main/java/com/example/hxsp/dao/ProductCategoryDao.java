package com.example.hxsp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.hxsp.bean.ProductCategory;

@Repository
public interface ProductCategoryDao {

	/**
	 * 查询该父级下的所有子级
	 * @param pid
	 * @return
	 */
	List<ProductCategory> selContentsByPid(Integer pid);

}
