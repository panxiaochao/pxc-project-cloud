package io.github.panxiaochao.system.application.api.request.sysparam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统参数更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "系统参数更新请求对象")
public class SysParamUpdateRequest {

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

}
