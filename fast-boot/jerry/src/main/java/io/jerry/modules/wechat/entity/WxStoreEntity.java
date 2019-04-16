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
@TableName("wx_store")
public class WxStoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 门店ID
	 */
	private String storeId;
	/**
	 * 门店名称
	 */
	private String storeName;
	/**
	 * 门店联系职员
	 */
	private String storeStaff;
	/**
	 * 门店地址
	 */
	private String storeAddr;
	/**
	 * 门店电话
	 */
	private String storePhone;
	/**
	 * 门店经度
	 */
	private String storeLongitude;
	/**
	 * 门店维度
	 */
	private String storeLatitude;

}
