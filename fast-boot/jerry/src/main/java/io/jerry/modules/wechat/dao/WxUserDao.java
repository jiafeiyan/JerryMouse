package io.jerry.modules.wechat.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.jerry.modules.wechat.entity.WxUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-14 20:36:50
 */
@Mapper
public interface WxUserDao extends BaseMapper<WxUserEntity> {
	
}
