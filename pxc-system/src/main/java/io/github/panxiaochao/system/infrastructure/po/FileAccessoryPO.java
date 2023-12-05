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
 * 附件表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("file_accessory")
public class FileAccessoryPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 原文件全名包括类型
	 */
	@TableField("file_name")
	private String fileName;

	/**
	 * 存储的文件全名包括类型
	 */
	@TableField("real_name")
	private String realName;

	/**
	 * 文件大小
	 */
	@TableField("file_size")
	private Long fileSize;

	/**
	 * 文件类型
	 */
	@TableField("file_type")
	private String fileType;

	/**
	 * 存储文件路径
	 */
	@TableField("file_path")
	private String filePath;

	/**
	 * 系统模块
	 */
	@TableField("module")
	private String module;

	/**
	 * 系统模块ID
	 */
	@TableField("link_id")
	private Long linkId;

	/**
	 * 状态1正常，0失效
	 */
	@TableField("state")
	private String state;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Long createId;

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
