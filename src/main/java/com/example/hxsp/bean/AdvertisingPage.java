package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 活动广告页
 * 
 * @author Administrator
 *
 */
@Data
public class AdvertisingPage implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer productId;// 商品id
	private Integer type;//类型：1.商品，2.优惠券3.文章等
	private String path;// 路径链接
	private String image;// 图片
	private Integer sort;// 排序
	private Integer isShow;// 状态（0：未上架，1：上架）
	private Date createTime;// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;// 更新时间

	public AdvertisingPage() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((isShow == null) ? 0 : isShow.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		AdvertisingPage other = (AdvertisingPage) obj;
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isShow == null) {
			if (other.isShow != null)
				return false;
		} else if (!isShow.equals(other.isShow))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
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
		return true;
	}

	@Override
	public String toString() {
		return "AdvertisingPage [id=" + id + ", productId=" + productId + ", type=" + type + ", path=" + path
				+ ", image=" + image + ", sort=" + sort + ", isShow=" + isShow + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

	public AdvertisingPage(Integer id, Integer productId, Integer type, String path, String image, Integer sort,
			Integer isShow, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.productId = productId;
		this.type = type;
		this.path = path;
		this.image = image;
		this.sort = sort;
		this.isShow = isShow;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	

	}
