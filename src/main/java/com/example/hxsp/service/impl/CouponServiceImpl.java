package com.example.hxsp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.hxsp.service.CouponUserService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.dao.CouponInfoDao;
import com.example.hxsp.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponInfoDao couponInfoDao;
	@Autowired
	private CouponUserService couponUserService;

	@Override
	public Map<String, Object> getAllCoupon(Integer pageNo, Integer pageSize) {
		Map<String, Object> map = new HashMap<>(2);
		PageHelper.startPage(pageNo, pageSize);
		List<CouponInfo> list = couponInfoDao.findAllCoupon(null);
		PageInfo<CouponInfo> pageInfo = new PageInfo<CouponInfo>(list);	
//		//获取未过期且库存不为0 的优惠券
//
//		List<CouponInfo> list2 = pageInfo.getList();
//		List<CouponInfo> list3 = new ArrayList<CouponInfo>();
//		Date date=new Date();
//		for (CouponInfo couponInfo : list2) {
//			Date re = couponInfo.getReceiveEndTime();
//
//			if(re==null) {
//				if(couponInfo.getIsLimited()==1&&couponInfo.getLastTotal()>0) {
//					list3.add(couponInfo);
//					//顯示
//				}else if(couponInfo.getIsLimited()==0) {
//					//顯示
//					list3.add(couponInfo);
//				}
//			}else if(re.getTime()>=date.getTime()) {
//				//顯示
//				list3.add(couponInfo);
//
//			}
//
//
//
//
//			continue;
//
//
//
//			
//
//		}
		List<CouponInfo> list2 = pageInfo.getList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		map.put("list",dateFormat(list2));
		map.put("total", pageInfo.getTotal());
		return map;
	}

	@Override
	public void addOneCoupon(String name, Double money, Integer isLimited, Integer total, Integer useType,
			Integer primaryKey, Double minPrice, Date receiveStartTime, Date receiveEndTime, Date useStartTime, Date useEndTime, Integer type) {
		CouponInfo couponInfo = new CouponInfo();
		couponInfo.setName(name);
		couponInfo.setMoney(money);
		couponInfo.setIsLimited(isLimited);
		couponInfo.setTotal(total);
		couponInfo.setUseType(useType);
		couponInfo.setPrimaryKey(primaryKey);
		couponInfo.setMinPrice(minPrice);
		couponInfo.setReceiveStartTime(receiveStartTime);
		couponInfo.setReceiveEndTime(receiveEndTime);
		couponInfo.setUseStartTime(useStartTime);
		couponInfo.setUseEndTime(useEndTime);
		couponInfo.setType(type);

		couponInfoDao.insertOne(couponInfo);

	}

	@Override
	public void changeOneCoupon(Integer id, String name, Double money, Integer isLimited, Integer total, Integer useType,
			Integer primaryKey, Double minPrice, String rst, String ret, String ust, String uet, Integer type, Integer status) throws ParseException {
		
		Date receiveStartTime = null;
		Date receiveEndTime = null;
		Date useStartTime = null;
		Date useEndTime = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(rst!=null&&!"".equals(rst)) {
			receiveStartTime = sdf.parse(rst);
		}
		if(ret!=null&&!"".equals(ret)) {
			receiveEndTime = sdf.parse(ret);
		}
		if(ust!=null&&!"".equals(ust)) {
			useStartTime = sdf.parse(ust);
		}
		if(uet!=null&&!"".equals(uet)) {
			useEndTime = sdf.parse(uet);
		}
		couponInfoDao.updateOne(id, name, money, isLimited, total, useType, primaryKey, minPrice, receiveStartTime, receiveEndTime, useStartTime,
				useEndTime, type, status);
	}

	@Override
	public void changeOneCoupon(Integer id, Integer lastTotal) {
		couponInfoDao.updateLastTotal(id, lastTotal);
	}

	@Override
	public List<CouponInfo> sel(Integer id) {
		if(id!=null) {
			return dateFormat(couponInfoDao.findOne(id));
		}
		return dateFormat(couponInfoDao.findAllCoupon(1));
	}

	@Override
	public void minusStock(Integer id) {
		couponInfoDao.minus(id);
	}


	@Override
	public List<Document> selAvaliableList(Integer uid) {
		Set<Integer> ids = new HashSet<Integer>();
		List<Document> res = new ArrayList<Document>();
		//获取已经领取的优惠券
		List<CouponUser> selMyList = couponUserService.selMyList(uid, null);
		for (CouponUser couponUser : selMyList) {
			ids.add(couponUser.getCouponId());
		}
		//获取所有活动优惠券
		List<CouponInfo> findAllCoupon = couponInfoDao.findAllCoupon(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (CouponInfo couponInfo : findAllCoupon) {
			Document doc = new Document();
			doc.put("id", couponInfo.getId());
			doc.put("name", couponInfo.getName());
			doc.put("money", couponInfo.getMoney());
			doc.put("is_limited", couponInfo.getIsLimited());
			doc.put("total", couponInfo.getTotal());
			doc.put("last_total", couponInfo.getLastTotal());
			doc.put("use_type", couponInfo.getUseType());
			doc.put("primary_key", couponInfo.getPrimaryKey());
			doc.put("min_price", couponInfo.getMinPrice());
			doc.put("receive_start_time", couponInfo.getReceiveStartTime()==null?null:sdf.format(couponInfo.getReceiveStartTime()));
			doc.put("receive_end_time", couponInfo.getReceiveEndTime()==null?null:sdf.format(couponInfo.getReceiveEndTime()));
			doc.put("is_fixed_time", couponInfo.getIsFixedTime());
			doc.put("use_start_time", couponInfo.getUseStartTime()==null?null:sdf.format(couponInfo.getUseStartTime()));
			doc.put("use_end_time", couponInfo.getUseEndTime()==null?null:sdf.format(couponInfo.getUseEndTime()));
			doc.put("day", couponInfo.getDay());
			doc.put("type", couponInfo.getType());
			doc.put("sort", couponInfo.getSort());
			doc.put("status", couponInfo.getStatus());
			doc.put("is_del", couponInfo.getIsDel());
			doc.put("update_time", sdf.format(couponInfo.getUpdateTime()));
			if(ids.add(couponInfo.getId())) {
				//未领取
				doc.put("isReved", 0);
			}else {
				//已领取
				doc.put("isReved", 1);
			}
			res.add(doc);
		}
		return res;
	}


	@Override
	public void del(String ids) {
		String[] idlist = ids.split(",");
		for (String id : idlist) {
			couponInfoDao.del(Integer.parseInt(id));
			
		}
		
	}
	
	/**
	 * 日期格式轉換
	 * @param list
	 * @return
	 */
	public List<CouponInfo> dateFormat(List<CouponInfo> list){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (CouponInfo couponInfo : list) {
			try {
				couponInfo.setUpdateTime(sdf.parse(sdf.format(couponInfo.getUpdateTime())));
				Date uet = couponInfo.getUseEndTime();
				Date ust = couponInfo.getUseStartTime();
				Date ret = couponInfo.getReceiveEndTime();
				Date rst = couponInfo.getReceiveStartTime();
				if(uet!=null) {
					couponInfo.setUseEndTime(sdf.parse(sdf.format(couponInfo.getUseEndTime())));
				}
				if(ust!=null) {
					couponInfo.setUseStartTime(sdf.parse(sdf.format(couponInfo.getUseStartTime())));
				}
				if(ret!=null) {
					couponInfo.setReceiveEndTime(sdf.parse(sdf.format(couponInfo.getReceiveEndTime())));
				}
				if(rst!=null) {
					couponInfo.setReceiveStartTime(sdf.parse(sdf.format(couponInfo.getReceiveStartTime())));
				}
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
		}
		return list;
	}

	

}
