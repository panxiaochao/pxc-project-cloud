package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据库-数据源管理 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Getter
@Setter
@ToString
public class DatabaseSource {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 数据库名称
	 */
	private String dbName;

	/**
	 * 数据源编码
	 */
	private String dbCode;

	/**
	 * 主机
	 */
	private String dbHost;

	/**
	 * 端口
	 */
	private String dbPort;

	/**
	 * 数据库类型
	 */
	private String dbType;

	/**
	 * 驱动类
	 */
	private String dbDriver;

	/**
	 * 数据源地址
	 */
	private String dbJdbcUrl;

	/**
	 * 用户名
	 */
	private String dbUsername;

	/**
	 * 密码
	 */
	private String dbPassword;

	/**
	 * 测试连接是否成功
	 */
	private String testConn;

	/**
	 * 最近一次测试连接时间
	 */
	private LocalDateTime testConnTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 租户ID
	 */
	private String tenantId;

	/**
	 * 创建人
	 */
	private String createId;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

}