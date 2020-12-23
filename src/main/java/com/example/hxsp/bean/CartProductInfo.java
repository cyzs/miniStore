package com.example.hxsp.bean;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * 购物车商品关系表
 * @author Administrator
 *
 */
@Data
public class CartProductInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//ID
	private Integer cartId;//购物车表ID
	 private Integer uid;//用户ID
	 private Integer type;//类型
	 private Integer productId;//商品ID
	 private String productAttrUnique;//商品属性
	 private Integer cartNum;//商品数量
	 private Integer combinationId;//拼团id
	 private Integer seckillId;//秒杀商品ID
	 private Integer bargainId;//砍价id
	 private Date createTime;//添加时间
	 private Date updateTime;//更新时间
	 private Integer status;//已添加的商品是否有效状态
	 public CartProductInfo() {
	}
	public CartProductInfo(Integer id, Integer cartId, Integer uid, Integer type, Integer productId,
			String productAttrUnique, Integer cartNum, Integer combinationId, Integer seckillId, Integer bargainId,
			Date createTime, Date updateTime, Integer status) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.uid = uid;
		this.type = type;
		this.productId = productId;
		this.productAttrUnique = productAttrUnique;
		this.cartNum = cartNum;
		this.combinationId = combinationId;
		this.seckillId = seckillId;
		this.bargainId = bargainId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductAttrUnique() {
		return productAttrUnique;
	}
	public void setProductAttrUnique(String productAttrUnique) {
		this.productAttrUnique = productAttrUnique;
	}
	public Integer getCartNum() {
		return cartNum;
	}
	public void setCartNum(Integer cartNum) {
		this.cartNum = cartNum;
	}
	public Integer getCombinationId() {
		return combinationId;
	}
	public void setCombinationId(Integer combinationId) {
		this.combinationId = combinationId;
	}
	public Integer getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(Integer seckillId) {
		this.seckillId = seckillId;
	}
	public Integer getBargainId() {
		return bargainId;
	}
	public void setBargainId(Integer bargainId) {
		this.bargainId = bargainId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bargainId == null) ? 0 : bargainId.hashCode());
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartNum == null) ? 0 : cartNum.hashCode());
		result = prime * result + ((combinationId == null) ? 0 : combinationId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productAttrUnique == null) ? 0 : productAttrUnique.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((seckillId == null) ? 0 : seckillId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartProductInfo other = (CartProductInfo) obj;
		if (bargainId == null) {
			if (other.bargainId != null)
				return false;
		} else if (!bargainId.equals(other.bargainId))
			return false;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartNum == null) {
			if (other.cartNum != null)
				return false;
		} else if (!cartNum.equals(other.cartNum))
			return false;
		if (combinationId == null) {
			if (other.combinationId != null)
				return false;
		} else if (!combinationId.equals(other.combinationId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productAttrUnique == null) {
			if (other.productAttrUnique != null)
				return false;
		} else if (!productAttrUnique.equals(other.productAttrUnique))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (seckillId == null) {
			if (other.seckillId != null)
				return false;
		} else if (!seckillId.equals(other.seckillId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CartProductInfo [id=" + id + ", cartId=" + cartId + ", uid=" + uid + ", type=" + type + ", productId="
				+ productId + ", productAttrUnique=" + productAttrUnique + ", cartNum=" + cartNum + ", combinationId="
				+ combinationId + ", seckillId=" + seckillId + ", bargainId=" + bargainId + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", status=" + status + "]";
	}
	
	 
}
