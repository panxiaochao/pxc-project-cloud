package io.github.panxiaochao.system.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>数据字典表查询响应对象.</p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@ToString
@Schema(description = "数据字典表查询响应对象")
public class SysDictQueryResponse {
    /**
     * 主键
     */
    @Schema(description = "主键")
    private String id;

    /**
    * 字典名称
    */
    @Schema(description = "字典名称")
    private String dictName;

    /**
    * 字典code
    */
    @Schema(description = "字典code")
    private String dictCode;

    /**
    * 字典类型：0为string,1为number
    */
    @Schema(description = "字典类型：0为string,1为number")
    private Integer dictType;

    /**
    * 描述
    */
    @Schema(description = "描述")
    private String description;

    /**
    * 排序
    */
    @Schema(description = "排序")
    private Integer sort;

    /**
    * 状态：1正常，0不正常
    */
    @Schema(description = "状态：1正常，0不正常")
    private String status;

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
