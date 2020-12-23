package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 优惠券记录表
 * @author Administrator
 *
 */
@Data
public class CouponUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private Integer couponId;//	优惠券发布id
	private Integer cid;// 兑换的项目id
	private Integer uid;//	领取人id
	private String name;//	优惠券名称
	private Double money;//	优惠券的面值
	private Double minPrice;//	最低消费多少金额可用优惠券
	private Integer type;//	获取方式，send后台发放, 用户领取 get
	private Integer status;//	状态（0：未使用，1：已使用, 2:已失效）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;//	创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;//	更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;//	开始使用时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;//	过期时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date useTime;//	使用时间
	private Integer useType;//	使用类型 1 全场通用, 2 商品券, 3 品类券
	private Integer primaryKey;//	所属商品id / 分类id
	public CouponUser() {
	}
	public CouponUser(Integer id, Integer couponId, Integer cid, Integer uid, String name, Double money,
			Double minPrice, Integer type, Integer status, Date createTime, Date updateTime, Date startTime,
			Date endTime, Date useTime, Integer useType, Integer primaryKey) {
		super();
		this.id = id;
		this.couponId = couponId;
		this.cid = cid;
		this.uid = uid;
		this.name = name;
		this.money = money;
		this.minPrice = minPrice;
		this.type = type;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.useTime = useTime;
		this.useType = useType;
		this.primaryKey = primaryKey;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	public Integer getUseType() {
		return useType;
	}
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((couponId == null) ? 0 : couponId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((useTime == null) ? 0 : useTime.hashCode());
		result = prime * result + ((useType == null) ? 0 : useType.hashCode());
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
		CouponUser other = (CouponUser) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (couponId == null) {
			if (other.couponId != null)
				return false;
		} else if (!couponId.equals(other.couponId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (minPrice == null) {
			if (other.minPrice != null)
				return false;
		} else if (!minPrice.equals(other.minPrice))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primaryKey == null) {
			if (other.primaryKey != null)
				return false;
		} else if (!primaryKey.equals(other.primaryKey))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
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
		if (useTime == null) {
			if (other.useTime != null)
				return false;
		} else if (!useTime.equals(other.useTime))
			return false;
		if (useType == null) {
			if (other.useType != null)
				return false;
		} else if (!useType.equals(other.useType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CouponUser [id=" + id + ", couponId=" + couponId + ", cid=" + cid + ", uid=" + uid + ", name=" + name
				+ ", money=" + money + ", minPrice=" + minPrice + ", type=" + type + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", useTime=" + useTime + ", useType=" + useType + ", primaryKey="
				+ primaryKey + "]";
	}
	
}
