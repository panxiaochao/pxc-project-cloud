package io.github.panxiaochao.system.infrastructure.po;

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
 * 数据库-数据源管理 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2024-05-21
 */
@Getter
@Setter
@TableName("database_source")
public class DatabaseSourcePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 数据库名称
	 */
	@TableField("db_name")
	private String dbName;

	/**
	 * 数据源编码
	 */
	@TableField("db_code")
	private String dbCode;

	/**
	 * 主机
	 */
	@TableField("db_host")
	private String dbHost;

	/**
	 * 端口
	 */
	@TableField("db_port")
	private Integer dbPort;

	/**
	 * 数据库类型
	 */
	@TableField("db_type")
	private String dbType;

	/**
	 * 驱动类
	 */
	@TableField("db_driver")
	private String dbDriver;

	/**
	 * 数据源地址
	 */
	@TableField("db_jdbc_url")
	private String dbJdbcUrl;

	/**
	 * 用户名
	 */
	@TableField("db_username")
	private String dbUsername;

	/**
	 * 密码
	 */
	@TableField("db_password")
	private String dbPassword;

	/**
	 * 测试连接是否成功
	 */
	@TableField("test_conn")
	private String testConn;

	/**
	 * 最近一次测试连接时间
	 */
	@TableField("test_conn_time")
	private LocalDateTime testConnTime;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 租户ID
	 */
	@TableField("tenant_id")
	private Integer tenantId;

	/**
	 * 创建人
	 */
	@TableField("create_id")
	private Integer createId;

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
