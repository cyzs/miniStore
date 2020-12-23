package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 消息通知模板
 * @author Administrator
 *
 */
@Data
public class TemplateMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//模板id
	private Integer type;//应用场景：0=订阅消息,1=微信模板消息
	private String tempKey;//模板关键字id，多个逗号分割
	private String title;//模板标题
	private String content;//内容
	private String extra;//扩展字段
	private Integer status;//状态 0，禁用，1启用
	private Date createTime;	
	private Date updateTime;	
	public TemplateMessage() {
	}
	public TemplateMessage(Integer id, Integer type, String tempKey, String title, String content, String extra,
			Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.type = type;
		this.tempKey = tempKey;
		this.title = title;
		this.content = content;
		this.extra = extra;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTempKey() {
		return tempKey;
	}
	public void setTempKey(String tempKey) {
		this.tempKey = tempKey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((extra == null) ? 0 : extra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tempKey == null) ? 0 : tempKey.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		TemplateMessage other = (TemplateMessage) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (extra == null) {
			if (other.extra != null)
				return false;
		} else if (!extra.equals(other.extra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tempKey == null) {
			if (other.tempKey != null)
				return false;
		} else if (!tempKey.equals(other.tempKey))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "TemplateMessage [id=" + id + ", type=" + type + ", tempKey=" + tempKey + ", title=" + title
				+ ", content=" + content + ", extra=" + extra + ", status=" + status + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
}
