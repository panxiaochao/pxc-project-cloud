package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据字典配置表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict_item")
public class SysDictItemPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 字典关联ID
	 */
	@TableField("dict_id")
	private Long dictId;

	/**
	 * 字典名称
	 */
	@TableField("dict_item_text")
	private String dictItemText;

	/**
	 * 字典code
	 */
	@TableField("dict_item_value")
	private String dictItemValue;

	/**
	 * 描述
	 */
	@TableField("`description`")
	private String description;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 状态：1正常，0不正常
	 */
	@TableField("state")
	private String state;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
}
