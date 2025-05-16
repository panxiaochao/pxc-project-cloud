package io.github.panxiaochao.system.development.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 模板分组关联表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@TableName("gen_template_group")
public class GenTemplateGroupPO {

	/**
	 * 分组id
	 */
	@TableId(value = "group_id", type = IdType.INPUT)
	private Long groupId;

	/**
	 * 模板id
	 */
	@TableField("template_id")
	private Long templateId;

}
