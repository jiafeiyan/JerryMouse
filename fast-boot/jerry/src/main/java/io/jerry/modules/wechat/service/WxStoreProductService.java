package io.jerry.modules.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.jerry.common.utils.PageUtils;
import io.jerry.modules.wechat.entity.WxStoreProductEntity;

import java.util.Map;

/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
public interface WxStoreProductService extends IService<WxStoreProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

