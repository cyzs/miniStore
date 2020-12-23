package com.example.hxsp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.hxsp.dao.CouponInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.CouponUser;
import com.example.hxsp.bean.OrderInfo;
import com.example.hxsp.dao.CouponUserDao;
import com.example.hxsp.service.CouponService;
import com.example.hxsp.service.CouponUserService;
import com.example.hxsp.service.exception.CouponAlreadyRevException;
import com.example.hxsp.service.exception.OutOfStockException;
import com.example.hxsp.utils.JsonResult;

@Service
public class CouponUserServiceImpl implements CouponUserService{

	@Autowired
	private CouponUserDao couponUserDao; 


	@Autowired
	private CouponService couponService;

	@Autowired
	private CouponUserService couponUserService;
	@Autowired
	private CouponInfoDao couponInfoDao;
	
	@Override
	public List<CouponUser> selMyList(Integer uid, Integer status) {
		return couponUserDao.findMyList(uid, status);
	}

	@Override
	public void receiveOne(Integer uid, Integer id) {
		//获取优惠券信息
		List<CouponInfo> selectedCopons = couponService.sel(id);
		if(selectedCopons.isEmpty()) {
			throw new OutOfStockException("优惠券已下架！");
		}
		
		if(alreadyRev(uid, id)) {
			throw new CouponAlreadyRevException("当前用户已经领取过此优惠券了！");
		}
		
		CouponInfo selectedCopon = selectedCopons.get(0);
		//看是否有剩余数量
		if(selectedCopon.getIsLimited()==1) {
			//看剩余的是否够给当前用户
			Integer lastTotal = selectedCopon.getLastTotal();
			if(lastTotal < 1){
				throw new OutOfStockException("当前剩余数量不够领取!");
			}
			//            new Thread() {
			//            	public void run() {
			//            		//库存减一
			couponService.changeOneCoupon(id, --lastTotal);;
			//            	};
			//            }.start();
			CouponUser couponUser = new CouponUser();
			couponUser.setCouponId(selectedCopon.getId());
			couponUser.setUid(uid);
			couponUser.setUseType(selectedCopon.getType());
			couponUser.setName(selectedCopon.getName());
			couponUser.setMoney(selectedCopon.getMoney());
			couponUser.setMinPrice(selectedCopon.getMinPrice());
			couponUser.setPrimaryKey(selectedCopon.getPrimaryKey());
			couponUser.setStatus(0);
			couponUserDao.save(couponUser);



			if (lastTotal<=0){
				couponInfoDao.updateStatus(0,id);
			}
		}
		

		//是否有固定的使用时间
		if(selectedCopon.getIsFixedTime()==1){




		}

		CouponUser storeCouponUser = new CouponUser();
		storeCouponUser.setCouponId(id);
		storeCouponUser.setUid(uid);
		storeCouponUser.setName(selectedCopon.getName());
		storeCouponUser.setMoney(selectedCopon.getMoney());
		storeCouponUser.setMinPrice(selectedCopon.getMinPrice());
		storeCouponUser.setStartTime(selectedCopon.getUseStartTime());
		storeCouponUser.setEndTime(selectedCopon.getUseEndTime());
		storeCouponUser.setUseType(selectedCopon.getUseType());
		couponUserDao.save(storeCouponUser);




	}

	/**
	 * 判断用户是否已经领取过优惠券
	 * @param uid
	 * @param id
	 * @return
	 */
	public boolean alreadyRev(Integer uid, Integer id) {
		List<CouponUser> list = couponUserDao.findByUidAndId(uid, id);
		if(list.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean use(Integer id, List<Integer> productIdList, BigDecimal price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canUse(Integer id, List<Integer> productIdList, BigDecimal price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rollbackByCancelOrder(OrderInfo order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long findMyAvailableCouponNum(String uid, Integer status) {
		return couponUserDao.findMyListNum(uid, status);
	}

	@Override
	public long alreadyReceived(Integer uid, Integer id) {
		return couponUserDao.alreadyReceived(uid,id);
	}

}
