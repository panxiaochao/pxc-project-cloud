package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 附件表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("file_accessory")
@Schema(name = "FileAccessoryPO", description = "附件表")
public class FileAccessoryPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "原文件全名包括类型")
	@TableField("file_name")
	private String fileName;

	@Schema(description = "存储的文件全名包括类型")
	@TableField("real_name")
	private String realName;

	@Schema(description = "文件大小")
	@TableField("file_size")
	private Long fileSize;

	@Schema(description = "文件类型")
	@TableField("file_type")
	private String fileType;

	@Schema(description = "存储文件路径")
	@TableField("file_path")
	private String filePath;

	@Schema(description = "系统模块")
	@TableField("module")
	private String module;

	@Schema(description = "系统模块ID")
	@TableField("link_id")
	private Long linkId;

	@Schema(description = "附件状态1正常，0失效")
	@TableField("`status`")
	private String status;

	@Schema(description = "创建人")
	@TableField("create_id")
	private Long createId;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
