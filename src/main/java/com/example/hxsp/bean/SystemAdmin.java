package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 系统管理员表
 * @author Administrator
 *
 */
@Data
public class SystemAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//后台管理员表ID
	private String account;//后台管理员账号
	private String pwd;//后台管理员密码
	private String realName;//后台管理员姓名
	private Integer roles;//后台管理员权限(menus_id)
	private String last_ip;//后台管理员最后一次登录ip
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer loginCount;//登录次数
	private Integer level;//后台管理员级别
	private Integer status;//后台管理员状态 1有效0无效
	private Integer is_del;	
	public SystemAdmin() {
		
	}
	public SystemAdmin(Integer id, String account, String pwd, String realName, Integer roles, String last_ip,
			Date createTime, Date updateTime, Integer loginCount, Integer level, Integer status, Integer is_del) {
		super();
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.realName = realName;
		this.roles = roles;
		this.last_ip = last_ip;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.loginCount = loginCount;
		this.level = level;
		this.status = status;
		this.is_del = is_del;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getRoles() {
		return roles;
	}
	public void setRoles(Integer roles) {
		this.roles = roles;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
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
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIs_del() {
		return is_del;
	}
	public void setIs_del(Integer is_del) {
		this.is_del = is_del;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_del == null) ? 0 : is_del.hashCode());
		result = prime * result + ((last_ip == null) ? 0 : last_ip.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((loginCount == null) ? 0 : loginCount.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SystemAdmin other = (SystemAdmin) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
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
		if (is_del == null) {
			if (other.is_del != null)
				return false;
		} else if (!is_del.equals(other.is_del))
			return false;
		if (last_ip == null) {
			if (other.last_ip != null)
				return false;
		} else if (!last_ip.equals(other.last_ip))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (loginCount == null) {
			if (other.loginCount != null)
				return false;
		} else if (!loginCount.equals(other.loginCount))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "SystemAdmin [id=" + id + ", account=" + account + ", pwd=" + pwd + ", realName=" + realName + ", roles="
				+ roles + ", last_ip=" + last_ip + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", loginCount=" + loginCount + ", level=" + level + ", status=" + status + ", is_del=" + is_del + "]";
	}
	
	
}
