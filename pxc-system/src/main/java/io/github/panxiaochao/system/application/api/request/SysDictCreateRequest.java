package io.github.panxiaochao.system.application.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 数据字典表创建请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "数据字典表创建请求对象")
public class SysDictCreateRequest {

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
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;

    /**
     * 状态：1正常，0不正常
     */
    @Schema(description = "状态：1正常，0不正常")
	private String state;
}
