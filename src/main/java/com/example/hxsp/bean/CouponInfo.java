package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 优惠券表
 * @author Administrator
 *
 */
@Data
public class CouponInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//	优惠券表ID
	private String name;//	优惠券名称
	private Double money;//	兑换的优惠券面值
	private Integer isLimited;//	是否限量, 默认0 不限量， 1限量
	private Integer total;//	发放总数
	private Integer lastTotal;//	剩余数量
	private Integer useType;//	使用类型 1 全场通用, 2 商品券, 3 品类券
	private Integer primaryKey;//	所属商品id / 分类id
	private Double minPrice;//	最低消费，0代表不限制
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date receiveStartTime;//	可领取开始时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date receiveEndTime;//	可领取结束时间
	private Integer isFixedTime;//	是否固定使用时间, 默认0 否， 1是
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date useStartTime;//	可使用时间范围 开始时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date useEndTime;//	可使用时间范围 结束时间
	private Integer day;//	天数
	private Integer type;//	优惠券类型 1 手动领取, 2 新人券, 3 赠送券
	private Integer sort;//	排序
	private Integer status;//	状态（0：关闭，1：开启）
	private Integer isDel;//	是否删除 状态（0：否，1：是）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;//	创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;//	更新时间
	public CouponInfo() {
	}
	public CouponInfo(Integer id, String name, Double money, Integer isLimited, Integer total, Integer lastTotal,
			Integer useType, Integer primaryKey, Double minPrice, Date receiveStartTime, Date receiveEndTime,
			Integer isFixedTime, Date useStartTime, Date useEndTime, Integer day, Integer type, Integer sort,
			Integer status, Integer isDel, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
		this.isLimited = isLimited;
		this.total = total;
		this.lastTotal = lastTotal;
		this.useType = useType;
		this.primaryKey = primaryKey;
		this.minPrice = minPrice;
		this.receiveStartTime = receiveStartTime;
		this.receiveEndTime = receiveEndTime;
		this.isFixedTime = isFixedTime;
		this.useStartTime = useStartTime;
		this.useEndTime = useEndTime;
		this.day = day;
		this.type = type;
		this.sort = sort;
		this.status = status;
		this.isDel = isDel;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDel == null) ? 0 : isDel.hashCode());
		result = prime * result + ((isFixedTime == null) ? 0 : isFixedTime.hashCode());
		result = prime * result + ((isLimited == null) ? 0 : isLimited.hashCode());
		result = prime * result + ((lastTotal == null) ? 0 : lastTotal.hashCode());
		result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
		result = prime * result + ((receiveEndTime == null) ? 0 : receiveEndTime.hashCode());
		result = prime * result + ((receiveStartTime == null) ? 0 : receiveStartTime.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((useEndTime == null) ? 0 : useEndTime.hashCode());
		result = prime * result + ((useStartTime == null) ? 0 : useStartTime.hashCode());
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
		CouponInfo other = (CouponInfo) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (isFixedTime == null) {
			if (other.isFixedTime != null)
				return false;
		} else if (!isFixedTime.equals(other.isFixedTime))
			return false;
		if (isLimited == null) {
			if (other.isLimited != null)
				return false;
		} else if (!isLimited.equals(other.isLimited))
			return false;
		if (lastTotal == null) {
			if (other.lastTotal != null)
				return false;
		} else if (!lastTotal.equals(other.lastTotal))
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
		if (receiveEndTime == null) {
			if (other.receiveEndTime != null)
				return false;
		} else if (!receiveEndTime.equals(other.receiveEndTime))
			return false;
		if (receiveStartTime == null) {
			if (other.receiveStartTime != null)
				return false;
		} else if (!receiveStartTime.equals(other.receiveStartTime))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (useEndTime == null) {
			if (other.useEndTime != null)
				return false;
		} else if (!useEndTime.equals(other.useEndTime))
			return false;
		if (useStartTime == null) {
			if (other.useStartTime != null)
				return false;
		} else if (!useStartTime.equals(other.useStartTime))
			return false;
		if (useType == null) {
			if (other.useType != null)
				return false;
		} else if (!useType.equals(other.useType))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getIsLimited() {
		return isLimited;
	}
	public void setIsLimited(Integer isLimited) {
		this.isLimited = isLimited;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getLastTotal() {
		return lastTotal;
	}
	public void setLastTotal(Integer lastTotal) {
		this.lastTotal = lastTotal;
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
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Date getReceiveStartTime() {
		return receiveStartTime;
	}
	public void setReceiveStartTime(Date receiveStartTime) {
		this.receiveStartTime = receiveStartTime;
	}
	public Date getReceiveEndTime() {
		return receiveEndTime;
	}
	public void setReceiveEndTime(Date receiveEndTime) {
		this.receiveEndTime = receiveEndTime;
	}
	public Integer getIsFixedTime() {
		return isFixedTime;
	}
	public void setIsFixedTime(Integer isFixedTime) {
		this.isFixedTime = isFixedTime;
	}
	public Date getUseStartTime() {
		return useStartTime;
	}
	public void setUseStartTime(Date useStartTime) {
		this.useStartTime = useStartTime;
	}
	public Date getUseEndTime() {
		return useEndTime;
	}
	public void setUseEndTime(Date useEndTime) {
		this.useEndTime = useEndTime;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CouponInfo [id=" + id + ", name=" + name + ", money=" + money + ", isLimited=" + isLimited + ", total="
				+ total + ", lastTotal=" + lastTotal + ", useType=" + useType + ", primaryKey=" + primaryKey
				+ ", minPrice=" + minPrice + ", receiveStartTime=" + receiveStartTime + ", receiveEndTime="
				+ receiveEndTime + ", isFixedTime=" + isFixedTime + ", useStartTime=" + useStartTime + ", useEndTime="
				+ useEndTime + ", day=" + day + ", type=" + type + ", sort=" + sort + ", status=" + status + ", isDel="
				+ isDel + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
