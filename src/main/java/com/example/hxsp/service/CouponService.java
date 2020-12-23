package com.example.hxsp.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.hxsp.bean.CouponInfo;
import com.example.hxsp.bean.CouponUser;
import org.bson.Document;

public interface CouponService {

	/**
	 * 分页查看发放的所有优惠券
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> getAllCoupon(Integer pageNo, Integer pageSize);

	/**
	 * 添加一个优惠券
	 * @param name 名称
	 * @param money 金额
	 * @param isLimited 数量是否有限
	 * @param total 总数量
	 * @param useType  使用类型 1 全场通用, 2 商品券, 3 品类券 
	 * @param primaryKey 所属商品id / 分类id
	 * @param minPrice 最低消费
	 * @param receiveStartTime 可领取开始时间
	 * @param useStartTime 可使用时间范围 开始时间
	 * @param useEndTime 可使用时间范围 结束时间
	 * @param type 优惠券类型 1 手动领取, 2 新人券, 3 赠送券
	 * @return
	 */
	void addOneCoupon(String name, Double money, Integer isLimited, Integer total, Integer useType, Integer primaryKey,
			Double minPrice, Date receiveStartTime, Date receiveEndTime, Date useStartTime, Date useEndTime, Integer type);

	/**
	 * 修改一个优惠券
	 * @param name 名称
	 * @param money 金额
	 * @param isLimited 数量是否有限
	 * @param total 总数量
	 * @param useType  使用类型 1 全场通用, 2 商品券, 3 品类券 
	 * @param primaryKey 所属商品id / 分类id
	 * @param minPrice 最低消费
	 * @param useStartTime 可使用时间范围 开始时间
	 * @param useEndTime 可使用时间范围 结束时间
	 * @param type 优惠券类型 1 手动领取, 2 新人券, 3 赠送券
	 * @param status 状态（0：关闭，1：开启）
	 * @return
	 * @throws ParseException 
	 */
	void changeOneCoupon(Integer id, String name, Double money, Integer isLimited, Integer total, Integer useType,
			Integer primaryKey, Double minPrice, String receiveStartTime, String receiveEndTime, String useStartTime, String useEndTime, Integer type, Integer status) throws ParseException;

	/**
	 * 查询（指定id，或所有可领取）
	 * @param id
	 * @return
	 */
	List<CouponInfo> sel(Integer id);

	/**
	 * 库存削减
	 * @param id
	 */
	void minusStock(Integer id);

	void changeOneCoupon(Integer id, Integer integer);

	List<Document> selAvaliableList(Integer uid);

	void del(String ids);

	
}
