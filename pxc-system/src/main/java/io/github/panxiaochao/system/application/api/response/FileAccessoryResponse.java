package io.github.panxiaochao.system.application.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 附件表响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
@Schema(description = "附件表响应对象")
public class FileAccessoryResponse {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 原文件全名包括类型
	 */
	@Schema(description = "原文件全名包括类型")
	private String fileName;

	/**
	 * 存储的文件全名包括类型
	 */
	@Schema(description = "存储的文件全名包括类型")
	private String realName;

	/**
	 * 文件大小
	 */
	@Schema(description = "文件大小")
	private String fileSize;

	/**
	 * 文件类型
	 */
	@Schema(description = "文件类型")
	private String fileType;

	/**
	 * 存储文件路径
	 */
	@Schema(description = "存储文件路径")
	private String filePath;

	/**
	 * 系统模块
	 */
	@Schema(description = "系统模块")
	private String module;

	/**
	 * 系统模块ID
	 */
	@Schema(description = "系统模块ID")
	private String linkId;

	/**
	 * 附件状态1正常，0失效
	 */
	@Schema(description = "附件状态1正常，0失效")
	private String status;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private String createId;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

}
