package io.jerry.modules.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@Data
@TableName("wx_product")
public class WxProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品ID
	 */
	private String productId;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品型号
	 */
	private String productModel;
	/**
	 * 商品价格
	 */
	private String productPrice;
	/**
	 * 商品描述
	 */
	private String productIntroduce;
	/**
	 * 商品类型
	 */
	private String productCategoriesId;
	/**
	 * 商品轮播图
	 */
	private String productLoopimgurl;
	/**
	 * 商品详情图
	 */
	private String productImgurl;

}
