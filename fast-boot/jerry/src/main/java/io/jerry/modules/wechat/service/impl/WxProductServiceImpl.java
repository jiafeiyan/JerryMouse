package io.jerry.modules.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;
import io.jerry.modules.wechat.dao.WxProductDao;
import io.jerry.modules.wechat.dto.WxProductDTO;
import io.jerry.modules.wechat.entity.WxProductEntity;
import io.jerry.modules.wechat.service.WxProductService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("wxProductService")
public class WxProductServiceImpl extends ServiceImpl<WxProductDao, WxProductEntity> implements WxProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxProductDTO> page = new Query<WxProductDTO>().getPage(params);
        page.setRecords(this.baseMapper.queryProductWithStore(params));
        return new PageUtils(page);
    }

}