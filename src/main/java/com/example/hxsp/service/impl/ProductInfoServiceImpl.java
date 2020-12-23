package com.example.hxsp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.ProductInfo;
import com.example.hxsp.dao.ProductInfoDao;
import com.example.hxsp.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	private ProductInfoDao productInfoDao;

	@Override
	public Map<String, Object> findAll(Integer pageNo, Integer pageSize, Integer type, Integer cateId, String productName, Integer isShow) {
		ProductInfo pi = new ProductInfo();
		pi.setCateId(cateId);
		if(productName==null||"".equals(productName)) {
			
			pi.setProductName(productName);
		}else {
			
			pi.setProductName("%"+productName+"%");
		}
		
		pi.setIsShow(isShow);
		Map<String, Object> map = new HashMap<>(2);
		List<ProductInfo> list = null;
		PageHelper.startPage(pageNo, pageSize);
		if (type == 0) {
			list = productInfoDao.selAlla(pi);
		} else if (type == 1) {
			list = productInfoDao.selAllIntegralProducts();
		}
		PageInfo<ProductInfo> pageInfo = new PageInfo<ProductInfo>(list);
		List<ProductInfo> list2 = pageInfo.getList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (ProductInfo productInfo : list2) {
			try {
				productInfo.setUpdateTime(sdf.parse(sdf.format(productInfo.getUpdateTime())));
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
		}
		map.put("data", list2);
		map.put("total", pageInfo.getTotal());
		return map;
	}

	@Override
	public List<ProductInfo> findAllHotProductsOnSale() {
		return productInfoDao.selAllHotProductsOnSale();
	}

	@Override
	public List<ProductInfo> findAllIntegralProducts() {
		return productInfoDao.selAllIntegralProducts();
	}

	@Override
	public List<ProductInfo> findAllIntProductsOnSale() {
		return productInfoDao.selAllIntProductsOnSale();
	}

	@Override
	public List<ProductInfo> findPro(Integer id, Integer cateId) {
		if (id != null) {
			return productInfoDao.selProById(id);
		}
		return productInfoDao.selProByCateId(cateId);
	}

	@Override
	public void setOnOffSale(Integer id, Integer type) {
		if (type == 0) {
			productInfoDao.setProOffSale(id);
		} else if (type == 1) {
			productInfoDao.setProOnSale(id);
		}

	}

	@Override
	public void addNewPro(String images, String name, String info, String keyword, Integer cateId, Double price,
			Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot, Integer isPostage,
			Integer giveIntegral, Double cost, String videoLink, Integer tempId) {
		String image = images.split(",")[0];
		
		ProductInfo productInfo = new ProductInfo();
		productInfo.setImage(image);
		productInfo.setSliderImage(images);
		productInfo.setProductName(name);
		productInfo.setProductInfo(info);
		productInfo.setKeyword(keyword);
		productInfo.setCateId(cateId);
		productInfo.setPrice(price);
		productInfo.setOtPrice(otPrice);
		productInfo.setProductType(type);;
		productInfo.setUnitName(unit);
		productInfo.setStock(stock);
		productInfo.setIsShow(isShow);
		productInfo.setIsHot(isHot);
		productInfo.setIsPostage(isPostage);
		productInfo.setGiveIntegral(giveIntegral);
		productInfo.setCost(cost);
		productInfo.setVideoLink(videoLink);
		productInfo.setTempId(tempId);
		productInfoDao.insertOne(productInfo);
	}

	@Override
	public void changePro(Integer id, String images, String name, String info, String keyword, Integer cateId,
			Double price, Double otPrice, Integer type, String unit, Integer stock, Integer isShow, Integer isHot,
			Integer isPostage, Integer giveIntegral, Double cost, String videoLink, Integer tempId) {
		productInfoDao.updateOne(id, images, name, info, keyword, cateId, price, otPrice, type, unit, stock, isShow,
				isHot, isPostage, giveIntegral, cost, videoLink, tempId);
	}

	@Override
	public void delPro(String ids) {
		if(!ids.isEmpty()&&ids.length()>0) {
			String[] split = ids.split(",");
			for (String string : split) {
				try {
					int id = Integer.parseInt(string);
					productInfoDao.delete(id);
				} catch (Exception e) {
					continue;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductInfo> selAllProduct() {
		return productInfoDao.selAllProduct();
	}


}
