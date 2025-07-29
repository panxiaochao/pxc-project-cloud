package io.github.panxiaochao.system.development.infrastructure.dao.po;

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
 * 【在线数据表】持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2025-07-29
 * @version 1.0
 */
@Getter
@Setter
@TableName("online_table")
public class OnlineTablePO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 表名
	 */
	@TableField("table_name")
	private String tableName;

	/**
	 * 说明
	 */
	@TableField("table_comment")
	private String tableComment;

	/**
	 * 项目版本号
	 */
	@TableField("version")
	private String version;

	/**
	 * 数据源ID
	 */
	@TableField("datasource_id")
	private Integer datasourceId;

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
