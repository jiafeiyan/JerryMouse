package io.jerry.modules.wechat.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import io.jerry.common.utils.UUIDUtils;
import io.jerry.modules.app.annotation.Login;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jerry.modules.wechat.entity.WxProductEntity;
import io.jerry.modules.wechat.service.WxProductService;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.R;



/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@RestController
@RequestMapping("wechat/wxproduct")
@Api("商品接口")
public class WxProductController {
    @Autowired
    private WxProductService wxProductService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = wxProductService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{productId}")
    public R info(@PathVariable("productId") String productId){
		WxProductEntity wxProduct = wxProductService.getById(productId);

        return R.ok().put("wxProduct", wxProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WxProductEntity wxProduct){
        wxProduct.setProductId(UUIDUtils.getUUID());
		wxProductService.save(wxProduct);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WxProductEntity wxProduct){
		wxProductService.updateById(wxProduct);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] productIds){
		wxProductService.removeByIds(Arrays.asList(productIds));

        return R.ok();
    }

}
