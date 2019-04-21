package io.jerry.modules.wechat.dto;

import io.jerry.modules.wechat.entity.WxProductEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper=true)
public class WxProductDTO extends WxProductEntity {
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
    /**
     * 是否上架
     */
    private String productUpper;
    /**
     * 上架时间
     */
    private String productUpperTime;
}
