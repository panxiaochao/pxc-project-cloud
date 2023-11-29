package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 用户授权信息表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_auths")
@Schema(name = "SysUserAuthsPO", description = "用户授权信息表")
public class SysUserAuthsPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "关联用户ID")
	@TableField("user_id")
	private Integer userId;

	@Schema(description = "登录类型(手机号/邮箱/用户名/微信/微博/QQ）等")
	@TableField("identity_type")
	private String identityType;

	@Schema(description = "登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号")
	@TableField("identifier")
	private String identifier;

	@Schema(description = "密码凭证（自建密码，或者第三方access_token）")
	@TableField("credential")
	private String credential;

	@Schema(description = "是否已经验证：1验证，0未验证")
	@TableField("verified")
	private String verified;

	@Schema(description = "登录标识失效时间")
	@TableField("expire_time")
	private Date expireTime;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
