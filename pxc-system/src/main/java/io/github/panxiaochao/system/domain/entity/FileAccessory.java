package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 附件表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
public class FileAccessory {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 原文件全名包括类型
	 */
	private String fileName;

	/**
	 * 存储的文件全名包括类型
	 */
	private String realName;

	/**
	 * 文件大小
	 */
	private Long fileSize;

	/**
	 * 文件类型
	 */
	private String fileType;

	/**
	 * 存储文件路径
	 */
	private String filePath;

	/**
	 * 系统模块
	 */
	private String module;

	/**
	 * 系统模块ID
	 */
	private Long linkId;

	/**
	 * 状态1正常，0失效
	 */
	private String state;

	/**
	 * 创建人
	 */
	private Long createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
}
