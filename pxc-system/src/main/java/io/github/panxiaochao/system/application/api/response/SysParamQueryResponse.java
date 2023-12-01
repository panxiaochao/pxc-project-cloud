package io.github.panxiaochao.system.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统参数查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "系统参数查询响应对象")
public class SysParamQueryResponse {
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
    * 参数名称
    */
    @Schema(description = "参数名称")
    private String paramName;

    /**
    * 参数键
    */
    @Schema(description = "参数键")
    private String paramKey;

    /**
    * 参数值
    */
    @Schema(description = "参数值")
    private String paramValue;

    /**
    * 参数类型1-系统类 2-业务类
    */
    @Schema(description = "参数类型1-系统类 2-业务类")
    private String paramType;

    /**
    * 状态1-正常 0-删除
    */
    @Schema(description = "状态1-正常 0-删除")
	private String state;

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
