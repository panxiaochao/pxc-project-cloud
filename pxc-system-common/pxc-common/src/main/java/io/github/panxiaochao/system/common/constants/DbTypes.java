package io.github.panxiaochao.system.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 数据库 枚举
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-15
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum DbTypes {

	/**
	 * MySQL数据库类型
	 */
	MYSQL("com.mysql.jdbc.Driver",
			"jdbc:mysql://{dbHost}:{dbPort}/{dbName}?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true",
			"MYSQL"),

	/**
	 * Oracle数据库类型
	 */
	ORACLE("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@{dbHost}:{dbPort}:{dbName}", "ORACLE"),

	/**
	 * SQLServer 2000数据库类型
	 */
	SQLSERVER2000("com.microsoft.sqlserver.jdbc.SQLServerDriver",
			"jdbc:sqlserver://{dbHost}:{dbPort};DatabaseName={dbName}", "SQLSERVER2000"),

	/**
	 * SQLServer数据库类型
	 */
	SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://{dbHost}:{dbPort};DatabaseName={dbName}",
			"SQLSERVER"),

	/**
	 * PostgreSQL数据库类型
	 */
	POSTGRESQL("org.postgresql.Driver", "jdbc:postgresql://{dbHost}:{dbPort}/{dbName}", "POSTGRESQL"),

	/**
	 * Greenplum数据库类型
	 */
	GREENPLUM("com.pivotal.jdbc.GreenplumDriver", "jdbc:postgresql://{dbHost}:{dbPort}/{dbName}", "GREENPLUM"),

	/**
	 * MariaDB数据库类型
	 */
	MARIADB("org.mariadb.jdbc.Driver", "jdbc:mariadb://{dbHost}:{dbPort}/{dbName}", "MARIADB"),

	/**
	 * DB2数据库类型
	 */
	DB2("com.ibm.db2.jcc.DB2Driver", "jdbc:db2://{dbHost}:{dbPort}/{dbName}", "DB2"),

	/**
	 * [国产]达梦数据库类型
	 */
	DM("dm.jdbc.driver.DmDriver", "jdbc:dm://{dbHost}:{dbPort}/{dbName}", "DM"),

	/**
	 * [国产]人大金仓数据库类型
	 */
	KINGBASE("com.kingbase8.Driver", "jdbc:kingbase8://{dbHost}:{dbPort}/{dbName}", "KINGBASE"),

	/**
	 * [国产]神通数据库
	 */
	OSCAR("com.oscar.Driver", "jdbc:oscar://{dbHost}:{dbPort}/{dbName}", "OSCAR"),

	/**
	 * [国产]南大通用GBase8a数据库
	 */
	GBASE8A("com.gbase.jdbc.Driver", "jdbc:gbase://{dbHost}:{dbPort}/{dbName}", "GBASE8A"),

	/**
	 * HIVE数据库
	 */
	HIVE("org.apache.hive.jdbc.HiveDriver", "jdbc:hive2://{dbHost}:{dbPort}/{dbName}", "HIVE"),

	/**
	 * SQLite数据库
	 */
	SQLITE3("org.sqlite.JDBC", "jdbc:sqlite::resource:{file}", "SQLITE3"),

	/**
	 * Sybase数据库类型
	 */
	SYBASE("com.sybase.jdbc4.jdbc.SybDriver", "jdbc:sybase:Tds:{dbHost}:{dbPort}/{dbName}", "SYBASE"),

	/**
	 * MySQL数据库类型
	 */
	DORIS("com.mysql.jdbc.Driver",
			"jdbc:mysql://{dbHost}:{dbPort}/{dbName}?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true",
			"DORIS"),

	/**
	 * MySQL数据库类型
	 */
	CLICKHOUSE("com.clickhouse.jdbc.ClickHouseDriver", "jdbc:clickhouse://{dbHost}:{dbPort}/{dbName}", "CLICKHOUSE");

	/**
	 * 驱动名称
	 */
	private final String driverClassName;

	/**
	 * URL 占位符
	 */
	private final String url;

	/**
	 * 数据库名称
	 */
	private final String dbType;

	/**
	 * 获取数据库类型
	 * @param dbType 数据库类型字符串
	 */
	public static DbTypes getDbTypes(String dbType) {
		for (DbTypes type : DbTypes.values()) {
			if (type.dbType.equalsIgnoreCase(dbType)) {
				return type;
			}
		}
		return null;
	}

}
