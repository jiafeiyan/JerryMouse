package io.jerry.modules.wechat.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.jerry.modules.wechat.dto.WxProductDTO;
import io.jerry.modules.wechat.entity.WxProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.convert.EntityWriter;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@Mapper
public interface WxProductDao extends BaseMapper<WxProductEntity> {

    //查询店铺产品
	List<WxProductDTO> queryProductWithStore(Map<String, Object> params);
}
