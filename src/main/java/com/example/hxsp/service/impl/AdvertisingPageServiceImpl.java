package com.example.hxsp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.example.hxsp.bean.AdvertisingPage;
import com.example.hxsp.dao.AdvertisingPageDao;
import com.example.hxsp.service.AdvertisingPageService;
import com.example.hxsp.service.CouponService;
import com.example.hxsp.service.ProductInfoService;

/**
 * 首页广告轮播图
 * 
 * @author Administrator
 *
 */
@Service
public class AdvertisingPageServiceImpl implements AdvertisingPageService {

	@Autowired
	private AdvertisingPageDao advertisingPageDao;

	@Override
	public List<AdvertisingPage> getAds() {
		return dateFormat(advertisingPageDao.findAllAds());
	}

	@Override
	public List<AdvertisingPage> getAdsShow() {
		return dateFormat(advertisingPageDao.findAllAdsShow());

	}

	@Override
	public void setOnOffSale(Integer id, Integer type) {
		if (type == 0) {
			advertisingPageDao.setOffSale(id);
		} else if (type == 1) {
			advertisingPageDao.setOnSale(id);
		}

	}

	@Override
	public void create(Integer productId, Integer type, String path, String image, Integer sort, Integer isShow) {
		//确认跳转路径
//		switch (type) {
//		case 1:
//			//商品
//
//			break;
//
//		case 2:
//			//优惠券
//			path = Common.COUPONURL;
//			break;
//		default:
//			break;
//		}
		AdvertisingPage advertisingPage = new AdvertisingPage();
		advertisingPage.setProductId(productId);
		advertisingPage.setType(type);
		advertisingPage.setImage(image);
		advertisingPage.setSort(sort);
		advertisingPage.setIsShow(isShow);
		advertisingPage.setPath(path);
		advertisingPageDao.save(advertisingPage);

	}
	
	public void change(Integer id, Integer productId, Integer type, String path, String image, Integer sort, Integer isShow) {
		AdvertisingPage advertisingPage = new AdvertisingPage();
		advertisingPage.setId(id);
		advertisingPage.setProductId(productId);
		advertisingPage.setType(type);
		advertisingPage.setImage(image);
		advertisingPage.setSort(sort);
		advertisingPage.setIsShow(isShow);
		advertisingPage.setPath(path);
		advertisingPageDao.change(advertisingPage);

	}

	@Override
	public void del(String ids) {
		if(!ids.isEmpty()&&ids.length()>0) {
			String[] split = ids.split(",");
			for (String id : split) {
				try {
					advertisingPageDao.del(Integer.parseInt(id));
				} catch (Exception e) {
					continue;
				}
			}
		}
		
		
	}
	
	/**
	 * 日期格式切換
	 * @param list
	 * @return
	 */
	public List<AdvertisingPage> dateFormat(List<AdvertisingPage> list){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (AdvertisingPage advertisingPage : list) {
			try {
				advertisingPage.setUpdateTime(sdf.parse(sdf.format(advertisingPage.getUpdateTime())));
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}

}
