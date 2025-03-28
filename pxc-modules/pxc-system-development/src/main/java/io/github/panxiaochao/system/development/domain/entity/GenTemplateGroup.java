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

	/**
	 * 构造方法
	 */
	public GenTemplateGroup() {
	}

	/**
	 * 构造方法
	 * @param groupId 分组id
	 * @param templateId 模板id
	 */
	public GenTemplateGroup(String groupId, String templateId) {
		this.groupId = groupId;
		this.templateId = templateId;
	}

}
