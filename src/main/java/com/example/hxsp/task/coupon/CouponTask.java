package com.example.hxsp.task.coupon;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.dao.CouponInfoDao;
import com.example.hxsp.dao.CouponUserDao;

@Component
public class CouponTask {
	
	@Autowired
	private CouponInfoDao couponInfoDao;
	
	@Autowired
	private CouponUserDao couponUserDao;
	
	@Scheduled(cron = "0 0 1 ? * *")
	public void removeExpired1() {
		System.out.println("----------优惠券定时任务开始------------");
		try {
			//将 可领取时间过期的移除
			CouponInfo couponInfo = new CouponInfo();
			Date today = new Date();
			couponInfo.setReceiveEndTime(today);
			couponInfo.setUseEndTime(today);
			couponInfo.setUseStartTime(today);
			couponInfo.setStatus(1);
			List<CouponInfo> findReceivedEndTimeExpired = couponInfoDao.findReceivedEndTimeExpired(couponInfo);
			if(findReceivedEndTimeExpired.size()>0) {
				for (CouponInfo couponInfo2 : findReceivedEndTimeExpired) {
					couponInfoDao.updateStatus(0, couponInfo2.getId());
				}
			}
			
			//将 可使用时间过期的移除(尚未消费使用的)
			List<CouponInfo> findUseEndTimeExpired = couponInfoDao.findUseEndTimeExpired(couponInfo);
			if(findUseEndTimeExpired.size()>0) {
				for (CouponInfo couponInfo2 : findUseEndTimeExpired) {
					couponUserDao.updateStatus(2, couponInfo2.getId(), 0);
				}
			}
			
//			//将 前一天新增的 加入 任务
//			List<CouponInfo> findUseStartTimeExpired = couponInfoDao.findUseStartTimeExpired(couponInfo);
//			if(findUseStartTimeExpired.size()>0) {
//				for (CouponInfo couponInfo2 : findUseStartTimeExpired) {
//					
//				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("----------优惠券定时任务结束------------");
	}

	
}
