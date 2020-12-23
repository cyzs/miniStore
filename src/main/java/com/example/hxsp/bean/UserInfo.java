package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 用户表
 * @author Administrator
 *
 */
@Data
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer uid;//	用户id
	private String account;//	用户账号
	private String pwd;//	用户密码
	private String realName;//	真实姓名
	private Date birthday;//	生日
	private String mark;//	用户备注
	private Integer partnerId;//	合伙人id
	private Integer groupId;//	用户分组id
	private String tagName;//	标签名称
	private String nickname;//	用户昵称
	private String avatar;//	用户头像
	private String phone;//	手机号码
	private String openid;//	添加ip
	private String lastIp;//	最后一次登录ip
	private Double nowMoney;//	用户余额
	private Integer integral;//	用户剩余积分
	private Integer experience;//	用户剩余经验
	private Integer signNum;//	连续签到天数
	private Integer status;//	1为正常，0为禁止
	private Integer level;//	等级
	private Integer userType;//	用户类型
	private Integer payCount;//	用户购买次数
	private String address;//	详细地址
	private Integer loginType;//	用户登陆类型，h5,wechat,routine
	private Date createTime;//	创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;//	更新时间
	private Date lastLoginTime;//	最后一次登录时间
	private Date cleanTime;//	清除时间
	private Integer subscribe;//	是否关注公众号
	private Date subscribeTime;//	关注公众号时间
	private Integer sex;//	性别，0未知，1男，2女，3保密
	private String country;//	国家，中国CN，其他OTHER
	public UserInfo() {
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Double getNowMoney() {
		return nowMoney;
	}
	public void setNowMoney(Double nowMoney) {
		this.nowMoney = nowMoney;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Integer getSignNum() {
		return signNum;
	}
	public void setSignNum(Integer signNum) {
		this.signNum = signNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getPayCount() {
		return payCount;
	}
	public void setPayCount(Integer payCount) {
		this.payCount = payCount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getLoginType() {
		return loginType;
	}
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getCleanTime() {
		return cleanTime;
	}
	public void setCleanTime(Date cleanTime) {
		this.cleanTime = cleanTime;
	}
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	public Date getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((cleanTime == null) ? 0 : cleanTime.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((integral == null) ? 0 : integral.hashCode());
		result = prime * result + ((lastIp == null) ? 0 : lastIp.hashCode());
		result = prime * result + ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((loginType == null) ? 0 : loginType.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((nowMoney == null) ? 0 : nowMoney.hashCode());
		result = prime * result + ((openid == null) ? 0 : openid.hashCode());
		result = prime * result + ((partnerId == null) ? 0 : partnerId.hashCode());
		result = prime * result + ((payCount == null) ? 0 : payCount.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((signNum == null) ? 0 : signNum.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subscribe == null) ? 0 : subscribe.hashCode());
		result = prime * result + ((subscribeTime == null) ? 0 : subscribeTime.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (cleanTime == null) {
			if (other.cleanTime != null)
				return false;
		} else if (!cleanTime.equals(other.cleanTime))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (integral == null) {
			if (other.integral != null)
				return false;
		} else if (!integral.equals(other.integral))
			return false;
		if (lastIp == null) {
			if (other.lastIp != null)
				return false;
		} else if (!lastIp.equals(other.lastIp))
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (loginType == null) {
			if (other.loginType != null)
				return false;
		} else if (!loginType.equals(other.loginType))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (nowMoney == null) {
			if (other.nowMoney != null)
				return false;
		} else if (!nowMoney.equals(other.nowMoney))
			return false;
		if (openid == null) {
			if (other.openid != null)
				return false;
		} else if (!openid.equals(other.openid))
			return false;
		if (partnerId == null) {
			if (other.partnerId != null)
				return false;
		} else if (!partnerId.equals(other.partnerId))
			return false;
		if (payCount == null) {
			if (other.payCount != null)
				return false;
		} else if (!payCount.equals(other.payCount))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
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
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (signNum == null) {
			if (other.signNum != null)
				return false;
		} else if (!signNum.equals(other.signNum))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subscribe == null) {
			if (other.subscribe != null)
				return false;
		} else if (!subscribe.equals(other.subscribe))
			return false;
		if (subscribeTime == null) {
			if (other.subscribeTime != null)
				return false;
		} else if (!subscribeTime.equals(other.subscribeTime))
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
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
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserInfo [uid=" + uid + ", account=" + account + ", pwd=" + pwd + ", realName=" + realName
				+ ", birthday=" + birthday + ", mark=" + mark + ", partnerId=" + partnerId + ", groupId=" + groupId
				+ ", tagName=" + tagName + ", nickname=" + nickname + ", avatar=" + avatar + ", phone=" + phone
				+ ", openid=" + openid + ", lastIp=" + lastIp + ", nowMoney=" + nowMoney + ", integral=" + integral
				+ ", experience=" + experience + ", signNum=" + signNum + ", status=" + status + ", level=" + level
				+ ", userType=" + userType + ", payCount=" + payCount + ", address=" + address + ", loginType="
				+ loginType + ", createTime=" + createTime + ", updateTime=" + updateTime + ", lastLoginTime="
				+ lastLoginTime + ", cleanTime=" + cleanTime + ", subscribe=" + subscribe + ", subscribeTime="
				+ subscribeTime + ", sex=" + sex + ", country=" + country + "]";
	}
	public UserInfo(Integer uid, String account, String pwd, String realName, Date birthday, String mark,
			Integer partnerId, Integer groupId, String tagName, String nickname, String avatar, String phone,
			String openid, String lastIp, Double nowMoney, Integer integral, Integer experience, Integer signNum,
			Integer status, Integer level, Integer userType, Integer payCount, String address, Integer loginType,
			Date createTime, Date updateTime, Date lastLoginTime, Date cleanTime, Integer subscribe, Date subscribeTime,
			Integer sex, String country) {
		super();
		this.uid = uid;
		this.account = account;
		this.pwd = pwd;
		this.realName = realName;
		this.birthday = birthday;
		this.mark = mark;
		this.partnerId = partnerId;
		this.groupId = groupId;
		this.tagName = tagName;
		this.nickname = nickname;
		this.avatar = avatar;
		this.phone = phone;
		this.openid = openid;
		this.lastIp = lastIp;
		this.nowMoney = nowMoney;
		this.integral = integral;
		this.experience = experience;
		this.signNum = signNum;
		this.status = status;
		this.level = level;
		this.userType = userType;
		this.payCount = payCount;
		this.address = address;
		this.loginType = loginType;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastLoginTime = lastLoginTime;
		this.cleanTime = cleanTime;
		this.subscribe = subscribe;
		this.subscribeTime = subscribeTime;
		this.sex = sex;
		this.country = country;
	}
	
}
