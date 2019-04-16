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
@TableName("wx_categories")
public class WxCategoriesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品分类
	 */
	private String categoriesId;
	/**
	 * 商品分类父节点
	 */
	private String categoriesPid;
	/**
	 * 分类名称 
	 */
	private String categoriesName;

}
