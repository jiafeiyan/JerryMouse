package io.jerry.modules.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@Data
@TableName("wx_store_product")
public class WxStoreProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 门店ID
	 */
	private String storeId;
	/**
	 * 商品ID
	 */
	private String productId;
	/**
	 * 是否上架
	 */
	private String productUpper;
	/**
	 * 上架时间
	 */
	private String productUpperTime;

}
