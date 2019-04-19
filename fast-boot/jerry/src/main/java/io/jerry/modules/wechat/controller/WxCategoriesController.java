package io.jerry.modules.wechat.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jerry.modules.wechat.entity.WxCategoriesEntity;
import io.jerry.modules.wechat.service.WxCategoriesService;
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
@RequestMapping("wechat/wxcategories")
public class WxCategoriesController {
    @Autowired
    private WxCategoriesService wxCategoriesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = wxCategoriesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoriesId}")
    public R info(@PathVariable("categoriesId") String categoriesId){
		WxCategoriesEntity wxCategories = wxCategoriesService.getById(categoriesId);

        return R.ok().put("wxCategories", wxCategories);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WxCategoriesEntity wxCategories){
		wxCategoriesService.save(wxCategories);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WxCategoriesEntity wxCategories){
		wxCategoriesService.updateById(wxCategories);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] categoriesIds){
		wxCategoriesService.removeByIds(Arrays.asList(categoriesIds));

        return R.ok();
    }

}
