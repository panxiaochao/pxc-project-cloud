package io.github.panxiaochao.system.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 实体.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@ToString
public class SysUser {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 用户真实姓名
	 */
	private String realName;

	/**
	 * 用户昵称（花名）
	 */
	private String nickName;

	/**
	 * 身份证
	 */
	private String idCard;

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 性别：1男，0女
	 */
	private String sex;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 电话号码
	 */
	private String tel;

	/**
	 * 传真号码
	 */
	private String fax;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 人员状态：1正常，0不正常
	 */
	private String status;

	/**
	 * 皮肤风格
	 */
	private String skins;

	/**
	 * 所在区域或者部门ID，多数据请用逗号隔开
	 */
	private Integer orgId;

	/**
	 * 所在区域或者部门编码code，多数据请用逗号隔开
	 */
	private String orgCode;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 登陆次数
	 */
	private Integer loginNums;

	/**
	 * 登录失败次数
	 */
	private Integer loginErrorNums;

	/**
	 * 登录时间
	 */
	private LocalDateTime loginTime;

	/**
	 * 帐号超时期限
	 */
	private LocalDateTime expireTime;

}
