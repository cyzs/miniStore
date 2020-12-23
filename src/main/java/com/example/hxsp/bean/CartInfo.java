package com.example.hxsp.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * 购物车表
 * 
 * @author Administrator
 *
 */
@Data
public class CartInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;// 购物车表ID
	private Integer uid;// 用户ID

	public CartInfo() {
	}

	public CartInfo(Integer id, Integer uid) {
		super();
		this.id = id;
		this.uid = uid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
		CartInfo other = (CartInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartInfo [id=" + id + ", uid=" + uid + "]";
	}

}
