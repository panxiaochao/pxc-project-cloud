package io.github.panxiaochao.system.application.api.request.fileaccessory;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 附件表更新请求对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "附件表更新请求对象")
public class FileAccessoryUpdateRequest {

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
	private Long fileSize;

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
	private Long linkId;

	/**
	 * 状态1正常，0失效
	 */
	@Schema(description = "状态1正常，0失效")
	private String state;

	/**
	 * 创建人
	 */
	@Schema(description = "创建人")
	private Integer createId;

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
