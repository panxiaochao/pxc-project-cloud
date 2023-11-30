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
 * 数据字典表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict")
public class SysDictPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 字典名称
	 */
	@TableField("dict_name")
	private String dictName;

	/**
	 * 字典code
	 */
	@TableField("dict_code")
	private String dictCode;

	/**
	 * 字典类型：0为string,1为number
	 */
	@TableField("dict_type")
	private Integer dictType;

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
	@TableField("`status`")
	private String status;

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
