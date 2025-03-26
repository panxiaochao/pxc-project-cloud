package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 模板 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@ToString
public class GenTemplate {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 模板名称
	 */
	private String templateName;

	/**
	 * 模板路径
	 */
	private String generatorPath;

	/**
	 * 模板描述
	 */
	private String templateDesc;

	/**
	 * 模板代码
	 */
	private String templateCode;

	/**
	 * 模板类型
	 */
	private String templateType;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新
	 */
	private LocalDateTime updateTime;

	/**
	 * 创建人
	 */
	private String createId;

	/**
	 * 修改人
	 */
	private String updateId;

}
