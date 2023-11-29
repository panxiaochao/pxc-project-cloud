package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统参数 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_param")
@Schema(name = "SysParamPO", description = "系统参数")
public class SysParamPO {

	@Schema(description = "ID")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "参数名称")
	@TableField("param_name")
	private String paramName;

	@Schema(description = "参数键")
	@TableField("param_key")
	private String paramKey;

	@Schema(description = "参数值")
	@TableField("param_value")
	private String paramValue;

	@Schema(description = "参数类型1-系统类 2-业务类")
	@TableField("param_type")
	private String paramType;

	@Schema(description = "状态1-正常 0-删除")
	@TableField("`status`")
	private String status;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
