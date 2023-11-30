package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户授权信息表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user_auths")
public class SysUserAuthsPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 关联用户ID
	 */
	@TableField("user_id")
	private Integer userId;

	/**
	 * 登录类型(手机号/邮箱/用户名/微信/微博/QQ）等
	 */
	@TableField("identity_type")
	private String identityType;

	/**
	 * 登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号
	 */
	@TableField("identifier")
	private String identifier;

	/**
	 * 密码凭证（自建密码，或者第三方access_token）
	 */
	@TableField("credential")
	private String credential;

	/**
	 * 是否已经验证：1验证，0未验证
	 */
	@TableField("verified")
	private String verified;

	/**
	 * 登录标识失效时间
	 */
	@TableField("expire_time")
	private LocalDateTime expireTime;

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
