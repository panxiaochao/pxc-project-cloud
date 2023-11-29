package io.github.panxiaochao.system.infrastructure.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 用户表 持久化对象.
 * <p>
 *
 * @author Lypxc
 * @since 2023-11-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@Schema(name = "SysUserPO", description = "用户表")
public class SysUserPO {

	@Schema(description = "主键")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@Schema(description = "用户真实姓名")
	@TableField("real_name")
	private String realName;

	@Schema(description = "用户昵称（花名）")
	@TableField("nick_name")
	private String nickName;

	@Schema(description = "身份证")
	@TableField("id_card")
	private String idCard;

	@Schema(description = "用户头像")
	@TableField("avatar")
	private String avatar;

	@Schema(description = "性别：1男，0女")
	@TableField("sex")
	private String sex;

	@Schema(description = "地址")
	@TableField("address")
	private String address;

	@Schema(description = "邮箱")
	@TableField("email")
	private String email;

	@Schema(description = "手机号码")
	@TableField("mobile")
	private String mobile;

	@Schema(description = "电话号码")
	@TableField("tel")
	private String tel;

	@Schema(description = "传真号码")
	@TableField("fax")
	private String fax;

	@Schema(description = "排序")
	@TableField("sort")
	private Integer sort;

	@Schema(description = "备注")
	@TableField("remark")
	private String remark;

	@Schema(description = "人员状态：1正常，0不正常")
	@TableField("`status`")
	private String status;

	@Schema(description = "皮肤风格")
	@TableField("skins")
	private String skins;

	@Schema(description = "所在区域或者部门ID，多数据请用逗号隔开")
	@TableField("org_id")
	private Integer orgId;

	@Schema(description = "所在区域或者部门编码code，多数据请用逗号隔开")
	@TableField("org_code")
	private String orgCode;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;

	@Schema(description = "更新时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	@Schema(description = "登陆次数")
	@TableField("login_nums")
	private Integer loginNums;

	@Schema(description = "登录失败次数")
	@TableField("login_error_nums")
	private Integer loginErrorNums;

	@Schema(description = "登录时间")
	@TableField("login_time")
	private Date loginTime;

	@Schema(description = "帐号超时期限")
	@TableField("expire_time")
	private Date expireTime;

}
