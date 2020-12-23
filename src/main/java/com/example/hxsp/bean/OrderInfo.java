package com.example.hxsp.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 订单表
 * @author Administrator
 *
 */
@Data
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//	订单ID
	private String orderId;//订单号
	private Integer uid;//	用户id
	private String realName;//用户姓名
	private String userPhone;//用户电话
	private String userAddress;//详细地址详细地址
	private BigDecimal freightPrice;//运费金额
	private Integer totalNum;//订单商品总数
	private BigDecimal totalPrice;//订单总价
	private Double totalPostage;//邮费
	private BigDecimal payPrice;//实际支付金额
	private BigDecimal payPostage;//支付邮费
	private BigDecimal deductionPrice;//抵扣金额
	private Integer couponId;//优惠券id
	private BigDecimal couponPrice;//优惠券金额
	private Integer paid;//支付状态
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date payTime;//支付时间
	private Integer payType;//支付方式
	private Integer status;//订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货，待评价；3：已完成；）
	private Integer refundStatus;//0 未退款 1 申请中 2 已退款
	private String refundReasonWapImg;//退款图片
	private String refundReasonWapExplain;//退款用户说明
	private String refundReasonWap;//前台退款原因
	private String refundReason;//不退款的理由
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date refundReasonTime;//退款时间
	private BigDecimal refundPrice;//退款金额
	private String deliveryName;//快递名称/送货人姓名
	private Integer deliveryType;//发货类型
	private String deliveryId;//快递单号/手机号
	private Integer gainIntegral;//消费赚取积分
	private Integer useIntegral;//使用积分
	private Integer backIntegral;//给用户退了多少积分
	private String mark;//备注
	private Integer isDel;//是否删除
	private String unique;//唯一id(md5加密)类似id
	private String remark;//管理员备注
	private Integer combinationId;//拼团商品id0一般商品
	private Integer pinkId;//拼团id 0没有拼团
	private Double cost;//成本价
	private Integer seckillId;//秒杀商品ID
	private Integer bargainId;//砍价id
	private Integer isChannel;//支付渠道(0微信公众号1微信小程序)
	private Integer isRemind;//是否消息提醒
	private Integer isSystemDel;//后台是否删除
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	private Integer orderType;//订单类型（1：普通，2：积分）

	private List<OrderProduct> orderProductList;//关联商品列表
	
}
