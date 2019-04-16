package io.jerry.modules.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.jerry.common.utils.PageUtils;
import io.jerry.modules.wechat.entity.WxCategoriesEntity;

import java.util.Map;

/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
public interface WxCategoriesService extends IService<WxCategoriesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

