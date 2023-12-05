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
 * 用户表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserPO {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 用户真实姓名
	 */
	@TableField("real_name")
	private String realName;

	/**
	 * 用户昵称（花名）
	 */
	@TableField("nick_name")
	private String nickName;

	/**
	 * 身份证
	 */
	@TableField("id_card")
	private String idCard;

	/**
	 * 用户头像
	 */
	@TableField("avatar")
	private String avatar;

	/**
	 * 性别：1男，0女
	 */
	@TableField("sex")
	private String sex;

	/**
	 * 地址
	 */
	@TableField("address")
	private String address;

	/**
	 * 邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 手机号码
	 */
	@TableField("mobile")
	private String mobile;

	/**
	 * 电话号码
	 */
	@TableField("tel")
	private String tel;

	/**
	 * 传真号码
	 */
	@TableField("fax")
	private String fax;

	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;

	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 状态：1正常，0不正常
	 */
	@TableField("state")
	private String state;

	/**
	 * 皮肤风格
	 */
	@TableField("skins")
	private String skins;

	/**
	 * 所在区域或者部门ID，多数据请用逗号隔开
	 */
	@TableField("org_id")
	private Integer orgId;

	/**
	 * 所在区域或者部门编码code，多数据请用逗号隔开
	 */
	@TableField("org_code")
	private String orgCode;

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

	/**
	 * 登陆次数
	 */
	@TableField("login_nums")
	private Integer loginNums;

	/**
	 * 登录失败次数
	 */
	@TableField("login_error_nums")
	private Integer loginErrorNums;

	/**
	 * 登录时间
	 */
	@TableField("login_time")
	private LocalDateTime loginTime;

	/**
	 * 帐号超时期限
	 */
	@TableField("expire_time")
	private LocalDateTime expireTime;

}
