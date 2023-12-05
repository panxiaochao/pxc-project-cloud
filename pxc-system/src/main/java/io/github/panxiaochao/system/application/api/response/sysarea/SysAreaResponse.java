package io.github.panxiaochao.system.application.api.response.sysarea;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 全国5级行政区划响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "全国5级行政区划响应对象")
public class SysAreaResponse {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;
        
    /**
     * 父ID
    */
    @Schema(description = "父ID")
    private Integer parentId;
        
    /**
     * 区划名称
    */
    @Schema(description = "区划名称")
    private String areaName;
        
    /**
     * 区域简称
    */
    @Schema(description = "区域简称")
    private String areaNameAbbr;
        
    /**
     * 地区代码
    */
    @Schema(description = "地区代码")
    private String areaCode;
        
    /**
     * 行政编码
    */
    @Schema(description = "行政编码")
    private String cityCode;
        
    /**
     * 上级地区代码，组合路径
    */
    @Schema(description = "上级地区代码，组合路径")
    private String parentPath;
        
    /**
     * 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区
    */
    @Schema(description = "0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区")
    private Integer areaLevel;
        
    /**
     * 排序
    */
    @Schema(description = "排序")
    private Integer sort;
        
    /**
     * 英文名称
    */
    @Schema(description = "英文名称")
    private String areaNameEn;
        
    /**
     * 英文简称
    */
    @Schema(description = "英文简称")
    private String areaNameEnAbbr;
        
    /**
     * 经度
    */
    @Schema(description = "经度")
    private String longitude;
        
    /**
     * 纬度
    */
    @Schema(description = "纬度")
    private String latitude;
        
    /**
     * 创建时间
    */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
        
    /**
     * 更新时间
    */
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
