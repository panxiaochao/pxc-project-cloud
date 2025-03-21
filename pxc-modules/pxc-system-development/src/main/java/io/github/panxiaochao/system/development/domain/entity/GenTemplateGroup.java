package io.github.panxiaochao.system.development.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 模板分组关联表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@ToString
public class GenTemplateGroup {

	/**
	 * 分组id
	 */
	private String groupId;

	/**
	 * 模板id
	 */
	private String templateId;

}
