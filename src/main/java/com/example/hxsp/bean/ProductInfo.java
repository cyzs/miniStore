package com.example.hxsp.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 商品表
 * @author Administrator
 *
 */
@Data
public class ProductInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//	商品id
	private String image;//	商品图片
	private String sliderImage;//	轮播图
	private String productName;//	商品名称
	private String productInfo;//	商品简介
	private String keyword;//	关键字
	private Integer cateId;//	分类id
	private Double price;//	商品价格、兑换所需积分
	private Double vipPrice;//	会员价格
	private Double otPrice;//	市场价
	private Integer productType;//	0-普通商品 1-积分商品
	private String unitName;//	单位名
	private Integer sort;//	排序
	private Integer sales;//	销量
	private Integer stock;//	库存
	private Integer isShow;//	状态（0：未上架，1：上架）
	private Integer isHot;//	是否热卖
	private Integer isBenefit;//	是否优惠
	private Integer isBest;//	是否精品
	private Integer isNew;//	是否新品
	private Date addTime;//	添加时间
	private Integer isPostage;//	是否包邮
	private Integer isDel;//	是否删除
	private Integer giveIntegral;	//获得积分
	private Double cost;//	成本价
	private Integer isSeckill;//	秒杀状态 0 未开启 1已开启
	private Integer isbargain;//	砍价状态 0未开启 1开启
	private Integer isGood;//	是否优品推荐
	private Integer fakeSales;//	虚拟销量
	private Integer browse;//	浏览量
	private String codePath;//	商品二维码地址(用户小程序海报)
	private String barCode;//	商品条码（一维码）
	private String sourceLink;//	淘宝京东1688类型外链
	private String videoLink;//	主图视频链接
	private Integer tempId;//	运费模板ID
	private Integer specType;//	规格 0单 1多
	private Integer activity;//	活动显示排序1=秒杀，2=砍价，3=拼团
	private Date createTime;//	创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;//	更新时间
	public ProductInfo() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSliderImage() {
		return sliderImage;
	}
	public void setSliderImage(String sliderImage) {
		this.sliderImage = sliderImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public Double getOtPrice() {
		return otPrice;
	}
	public void setOtPrice(Double otPrice) {
		this.otPrice = otPrice;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public Integer getIsBenefit() {
		return isBenefit;
	}
	public void setIsBenefit(Integer isBenefit) {
		this.isBenefit = isBenefit;
	}
	public Integer getIsBest() {
		return isBest;
	}
	public void setIsBest(Integer isBest) {
		this.isBest = isBest;
	}
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getIsPostage() {
		return isPostage;
	}
	public void setIsPostage(Integer isPostage) {
		this.isPostage = isPostage;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public Integer getGiveIntegral() {
		return giveIntegral;
	}
	public void setGiveIntegral(Integer giveIntegral) {
		this.giveIntegral = giveIntegral;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getIsSeckill() {
		return isSeckill;
	}
	public void setIsSeckill(Integer isSeckill) {
		this.isSeckill = isSeckill;
	}
	public Integer getIsbargain() {
		return isbargain;
	}
	public void setIsbargain(Integer isbargain) {
		this.isbargain = isbargain;
	}
	public Integer getIsGood() {
		return isGood;
	}
	public void setIsGood(Integer isGood) {
		this.isGood = isGood;
	}
	public Integer getFakeSales() {
		return fakeSales;
	}
	public void setFakeSales(Integer fakeSales) {
		this.fakeSales = fakeSales;
	}
	public Integer getBrowse() {
		return browse;
	}
	public void setBrowse(Integer browse) {
		this.browse = browse;
	}
	public String getCodePath() {
		return codePath;
	}
	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getSourceLink() {
		return sourceLink;
	}
	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public Integer getTempId() {
		return tempId;
	}
	public void setTempId(Integer tempId) {
		this.tempId = tempId;
	}
	public Integer getSpecType() {
		return specType;
	}
	public void setSpecType(Integer specType) {
		this.specType = specType;
	}
	public Integer getActivity() {
		return activity;
	}
	public void setActivity(Integer activity) {
		this.activity = activity;
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
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((addTime == null) ? 0 : addTime.hashCode());
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		result = prime * result + ((browse == null) ? 0 : browse.hashCode());
		result = prime * result + ((cateId == null) ? 0 : cateId.hashCode());
		result = prime * result + ((codePath == null) ? 0 : codePath.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((fakeSales == null) ? 0 : fakeSales.hashCode());
		result = prime * result + ((giveIntegral == null) ? 0 : giveIntegral.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((isBenefit == null) ? 0 : isBenefit.hashCode());
		result = prime * result + ((isBest == null) ? 0 : isBest.hashCode());
		result = prime * result + ((isDel == null) ? 0 : isDel.hashCode());
		result = prime * result + ((isGood == null) ? 0 : isGood.hashCode());
		result = prime * result + ((isHot == null) ? 0 : isHot.hashCode());
		result = prime * result + ((isNew == null) ? 0 : isNew.hashCode());
		result = prime * result + ((isPostage == null) ? 0 : isPostage.hashCode());
		result = prime * result + ((isSeckill == null) ? 0 : isSeckill.hashCode());
		result = prime * result + ((isShow == null) ? 0 : isShow.hashCode());
		result = prime * result + ((isbargain == null) ? 0 : isbargain.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((otPrice == null) ? 0 : otPrice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((sliderImage == null) ? 0 : sliderImage.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((sourceLink == null) ? 0 : sourceLink.hashCode());
		result = prime * result + ((specType == null) ? 0 : specType.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((tempId == null) ? 0 : tempId.hashCode());
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((videoLink == null) ? 0 : videoLink.hashCode());
		result = prime * result + ((vipPrice == null) ? 0 : vipPrice.hashCode());
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
		ProductInfo other = (ProductInfo) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (addTime == null) {
			if (other.addTime != null)
				return false;
		} else if (!addTime.equals(other.addTime))
			return false;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		if (browse == null) {
			if (other.browse != null)
				return false;
		} else if (!browse.equals(other.browse))
			return false;
		if (cateId == null) {
			if (other.cateId != null)
				return false;
		} else if (!cateId.equals(other.cateId))
			return false;
		if (codePath == null) {
			if (other.codePath != null)
				return false;
		} else if (!codePath.equals(other.codePath))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (fakeSales == null) {
			if (other.fakeSales != null)
				return false;
		} else if (!fakeSales.equals(other.fakeSales))
			return false;
		if (giveIntegral == null) {
			if (other.giveIntegral != null)
				return false;
		} else if (!giveIntegral.equals(other.giveIntegral))
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
		if (isBenefit == null) {
			if (other.isBenefit != null)
				return false;
		} else if (!isBenefit.equals(other.isBenefit))
			return false;
		if (isBest == null) {
			if (other.isBest != null)
				return false;
		} else if (!isBest.equals(other.isBest))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (isGood == null) {
			if (other.isGood != null)
				return false;
		} else if (!isGood.equals(other.isGood))
			return false;
		if (isHot == null) {
			if (other.isHot != null)
				return false;
		} else if (!isHot.equals(other.isHot))
			return false;
		if (isNew == null) {
			if (other.isNew != null)
				return false;
		} else if (!isNew.equals(other.isNew))
			return false;
		if (isPostage == null) {
			if (other.isPostage != null)
				return false;
		} else if (!isPostage.equals(other.isPostage))
			return false;
		if (isSeckill == null) {
			if (other.isSeckill != null)
				return false;
		} else if (!isSeckill.equals(other.isSeckill))
			return false;
		if (isShow == null) {
			if (other.isShow != null)
				return false;
		} else if (!isShow.equals(other.isShow))
			return false;
		if (isbargain == null) {
			if (other.isbargain != null)
				return false;
		} else if (!isbargain.equals(other.isbargain))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (otPrice == null) {
			if (other.otPrice != null)
				return false;
		} else if (!otPrice.equals(other.otPrice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (sliderImage == null) {
			if (other.sliderImage != null)
				return false;
		} else if (!sliderImage.equals(other.sliderImage))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (sourceLink == null) {
			if (other.sourceLink != null)
				return false;
		} else if (!sourceLink.equals(other.sourceLink))
			return false;
		if (specType == null) {
			if (other.specType != null)
				return false;
		} else if (!specType.equals(other.specType))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (tempId == null) {
			if (other.tempId != null)
				return false;
		} else if (!tempId.equals(other.tempId))
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (videoLink == null) {
			if (other.videoLink != null)
				return false;
		} else if (!videoLink.equals(other.videoLink))
			return false;
		if (vipPrice == null) {
			if (other.vipPrice != null)
				return false;
		} else if (!vipPrice.equals(other.vipPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", image=" + image + ", sliderImage=" + sliderImage + ", productName="
				+ productName + ", productInfo=" + productInfo + ", keyword=" + keyword + ", cateId=" + cateId
				+ ", price=" + price + ", vipPrice=" + vipPrice + ", otPrice=" + otPrice + ", productType="
				+ productType + ", unitName=" + unitName + ", sort=" + sort + ", sales=" + sales + ", stock=" + stock
				+ ", isShow=" + isShow + ", isHot=" + isHot + ", isBenefit=" + isBenefit + ", isBest=" + isBest
				+ ", isNew=" + isNew + ", addTime=" + addTime + ", isPostage=" + isPostage + ", isDel=" + isDel
				+ ", giveIntegral=" + giveIntegral + ", cost=" + cost + ", isSeckill=" + isSeckill + ", isbargain="
				+ isbargain + ", isGood=" + isGood + ", fakeSales=" + fakeSales + ", browse=" + browse + ", codePath="
				+ codePath + ", barCode=" + barCode + ", sourceLink=" + sourceLink + ", videoLink=" + videoLink
				+ ", tempId=" + tempId + ", specType=" + specType + ", activity=" + activity + ", createTime="
				+ createTime + ", updateTime=" + updateTime + "]";
	}
	public ProductInfo(Integer id, String image, String sliderImage, String productName, String productInfo,
			String keyword, Integer cateId, Double price, Double vipPrice, Double otPrice, Integer productType,
			String unitName, Integer sort, Integer sales, Integer stock, Integer isShow, Integer isHot,
			Integer isBenefit, Integer isBest, Integer isNew, Date addTime, Integer isPostage, Integer isDel,
			Integer giveIntegral, Double cost, Integer isSeckill, Integer isbargain, Integer isGood, Integer fakeSales,
			Integer browse, String codePath, String barCode, String sourceLink, String videoLink, Integer tempId,
			Integer specType, Integer activity, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.image = image;
		this.sliderImage = sliderImage;
		this.productName = productName;
		this.productInfo = productInfo;
		this.keyword = keyword;
		this.cateId = cateId;
		this.price = price;
		this.vipPrice = vipPrice;
		this.otPrice = otPrice;
		this.productType = productType;
		this.unitName = unitName;
		this.sort = sort;
		this.sales = sales;
		this.stock = stock;
		this.isShow = isShow;
		this.isHot = isHot;
		this.isBenefit = isBenefit;
		this.isBest = isBest;
		this.isNew = isNew;
		this.addTime = addTime;
		this.isPostage = isPostage;
		this.isDel = isDel;
		this.giveIntegral = giveIntegral;
		this.cost = cost;
		this.isSeckill = isSeckill;
		this.isbargain = isbargain;
		this.isGood = isGood;
		this.fakeSales = fakeSales;
		this.browse = browse;
		this.codePath = codePath;
		this.barCode = barCode;
		this.sourceLink = sourceLink;
		this.videoLink = videoLink;
		this.tempId = tempId;
		this.specType = specType;
		this.activity = activity;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	
}
