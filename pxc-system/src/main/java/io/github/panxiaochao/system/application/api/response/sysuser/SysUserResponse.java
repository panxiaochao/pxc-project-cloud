package io.github.panxiaochao.system.application.api.response.sysuser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表响应对象
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@ToString
@Schema(description = "用户表响应对象")
public class SysUserResponse {

	/**
	 * 主键
	 */
	@Schema(description = "主键")
	private String id;

	/**
	 * 用户真实姓名
	 */
	@Schema(description = "用户真实姓名")
	private String realName;

	/**
	 * 用户昵称（花名）
	 */
	@Schema(description = "用户昵称（花名）")
	private String nickName;

	/**
	 * 身份证
	 */
	@Schema(description = "身份证")
	private String idCard;

	/**
	 * 用户头像
	 */
	@Schema(description = "用户头像")
	private String avatar;

	/**
	 * 性别：1男，0女
	 */
	@Schema(description = "性别：1男，0女")
	private String sex;

	/**
	 * 性别字符串：男，女
	 */
	@Schema(description = "性别：男，女")
	private String sexStr;

	/**
	 * 地址
	 */
	@Schema(description = "地址")
	private String address;

	/**
	 * 邮箱
	 */
	@Schema(description = "邮箱")
	private String email;

	/**
	 * 手机号码
	 */
	@Schema(description = "手机号码")
	private String mobile;

	/**
	 * 电话号码
	 */
	@Schema(description = "电话号码")
	private String tel;

	/**
	 * 传真号码
	 */
	@Schema(description = "传真号码")
	private String fax;

	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	/**
	 * 状态：1正常，0不正常
	 */
	@Schema(description = "状态：1正常，0不正常")
	private String state;

	/**
	 * 皮肤风格
	 */
	@Schema(description = "皮肤风格")
	private String skins;

	/**
	 * 所在区域或者部门ID，多数据请用逗号隔开
	 */
	@Schema(description = "所在区域或者部门ID，多数据请用逗号隔开")
	private String orgId;

	/**
	 * 所在区域或者部门编码code，多数据请用逗号隔开
	 */
	@Schema(description = "所在区域或者部门编码code，多数据请用逗号隔开")
	private String orgCode;

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

	/**
	 * 登陆次数
	 */
	@Schema(description = "登陆次数")
	private Integer loginNums;

	/**
	 * 登录失败次数
	 */
	@Schema(description = "登录失败次数")
	private Integer loginErrorNums;

	/**
	 * 登录时间
	 */
	@Schema(description = "登录时间")
	private LocalDateTime loginTime;

	/**
	 * 帐号超时期限
	 */
	@Schema(description = "帐号超时期限")
	private LocalDateTime expireTime;

}
