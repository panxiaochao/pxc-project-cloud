package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统参数 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class SysParam {

	/**
	 * ID
	 */
	private String id;

	/**
	 * 参数名称
	 */
	private String paramName;

	/**
	 * 参数键
	 */
	private String paramKey;

	/**
	 * 参数值
	 */
	private String paramValue;

	/**
	 * 参数类型1-系统类 2-业务类
	 */
	private String paramType;

	/**
	 * 状态1-正常 0-删除
	 */
	private String state;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}
