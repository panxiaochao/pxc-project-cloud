package io.github.panxiaochao.system.development.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 模板 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2025-03-19
 */
@Getter
@Setter
@TableName("gen_template")
public class GenTemplatePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 模板名称
	 */
	@TableField("template_name")
	private String templateName;

	/**
	 * 模板路径
	 */
	@TableField("generator_path")
	private String generatorPath;

	/**
	 * 模板描述
	 */
	@TableField("template_desc")
	private String templateDesc;

	/**
	 * 模板代码
	 */
	@TableField("template_code")
	private String templateCode;

	/**
	 * 模板类型
	 */
	@TableField("template_type")
	private String templateType;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	 * 创建人
	 */
	@TableField(value = "create_id", fill = FieldFill.INSERT)
	private Integer createId;

	/**
	 * 修改人
	 */
	@TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
	private Integer updateId;

}
