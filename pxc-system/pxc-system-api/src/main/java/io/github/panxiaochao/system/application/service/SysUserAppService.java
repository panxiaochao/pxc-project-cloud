package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.enums.CommonResponseEnum;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StrUtil;
import io.github.panxiaochao.core.utils.date.LocalDateTimeUtil;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserUpdateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserauths.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserResponse;
import io.github.panxiaochao.system.application.api.response.sysuserauths.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.application.convert.ISysUserDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.common.constants.GlobalConstant;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import io.github.panxiaochao.system.domain.service.SysOrgDomainService;
import io.github.panxiaochao.system.domain.service.SysUserAuthsDomainService;
import io.github.panxiaochao.system.domain.service.SysUserDomainService;
import io.github.panxiaochao.system.domain.service.SysUserOrgDomainService;
import io.github.panxiaochao.system.domain.service.SysUserRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 用户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAppService {

	/**
	 * 用户表 Domain服务类
	 */
	private final SysUserDomainService sysUserDomainService;

	/**
	 * 机构部门表 Domain服务类
	 */
	private final SysOrgDomainService sysOrgDomainService;

	/**
	 * 用户机构/部门表 Domain服务类
	 */
	private final SysUserOrgDomainService sysUserOrgDomainService;

	/**
	 * 用户角色表 Domain服务类
	 */
	private final SysUserRoleDomainService sysUserRoleDomainService;

	/**
	 * 用户授权信息表 Domain服务类
	 */
	private final SysUserAuthsDomainService sysUserAuthsDomainService;

	/**
	 * 用户授权信息表 App服务类
	 */
	private final SysUserAuthsAppService sysUserAuthsAppService;

	/**
	 * 用户表 读模型服务
	 */
	private final ISysUserReadModelService sysUserReadModelService;

	/**
	 * 用户授权信息表 读模型服务
	 */
	private final ISysUserAuthsReadModelService sysUserAuthsReadModelService;

	/**
	 * 登录类型 常量名
	 */
	private static final String IDENTITY_TYPE_USERNAME = "USERNAME";

	/**
	 * 初始密码 常量名
	 */
	private static final String SYS_USER_PASSWORD = "sys.user.password";

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 用户表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysUserQueryResponse> page(RequestPage pageRequest, SysUserQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysUserQueryResponse> list = sysUserReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysUserResponse> getById(String id) {
		SysUser sysUser = sysUserDomainService.getById(id);
		SysUserResponse sysUserResponse = ISysUserDTOConvert.INSTANCE.toResponse(sysUser);
		return R.ok(sysUserResponse);
	}

	/**
	 * 保存
	 * @param sysUserCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysUserResponse> save(SysUserCreateRequest sysUserCreateRequest) {
		SysUser sysUser = ISysUserDTOConvert.INSTANCE.fromCreateRequest(sysUserCreateRequest);
		// 判断登录账号是否唯一. 判断条件：登录类型+登录账号
		SysUserAuthsQueryRequest queryRequest = new SysUserAuthsQueryRequest();
		queryRequest.setIdentifier(sysUserCreateRequest.getLoginName());
		queryRequest.setIdentityType(IDENTITY_TYPE_USERNAME);
		SysUserAuthsQueryResponse one = sysUserAuthsReadModelService.geOne(queryRequest, false);
		if (Objects.nonNull(one)) {
			return R.fail("登录账号[" + sysUserCreateRequest.getLoginName() + "]已存在");
		}
		// 判断并且获取组织信息
		if (StringUtils.hasText(sysUser.getOrgId())) {
			SysOrg sysOrg = sysOrgDomainService.getById(sysUser.getOrgId());
			sysUser.setOrgCode(sysOrg.getOrgCode());
		}
		sysUser = sysUserDomainService.save(sysUser);
		// 初始化密码，默认生成账号密码类型一条记录
		SysUserAuthsCreateRequest sysUserAuthsCreateRequest = new SysUserAuthsCreateRequest();
		sysUserAuthsCreateRequest.setUserId(sysUser.getId());
		sysUserAuthsCreateRequest.setIdentityType(IDENTITY_TYPE_USERNAME);
		sysUserAuthsCreateRequest.setIdentifier(sysUserCreateRequest.getLoginName());
		if (StringUtils.hasText(sysUserCreateRequest.getPassword())) {
			sysUserAuthsCreateRequest.setCredential(sysUserCreateRequest.getPassword());
		}
		else {
			SysParamQueryResponse sysParamQueryResponse = Optional
				.ofNullable(CacheHelper.getSysParamByKey(SYS_USER_PASSWORD))
				.orElseThrow(() -> new ServerRuntimeException(CommonResponseEnum.INTERNAL_SERVER_ERROR,
						"请在系统参数中设置键值为[sys.user.password], 值为初始化默认密码!"));
			sysUserAuthsCreateRequest.setCredential(sysParamQueryResponse.getParamValue());
		}
		sysUserAuthsCreateRequest.setVerified(CommonConstant.STATUS_NORMAL.toString());
		sysUserAuthsCreateRequest.setExpireTime(LocalDateTimeUtil.stringToLocalDateTime(GlobalConstant.EXPIRE_TIME));
		sysUserAuthsAppService.save(sysUserAuthsCreateRequest);
		// 存储用户组织关联关系
		if (StringUtils.hasText(sysUser.getOrgId())) {
			SysUserOrg sysUserOrg = new SysUserOrg();
			sysUserOrg.setUserId(sysUser.getId());
			sysUserOrg.setOrgId(sysUser.getOrgId());
			sysUserOrgDomainService.save(sysUserOrg);
		}
		// 返回用户数据
		SysUserResponse sysUserResponse = ISysUserDTOConvert.INSTANCE.toResponse(sysUser);
		return R.ok(sysUserResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysUserUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysUserUpdateRequest sysUserUpdateRequest) {
		SysUser sysUser = ISysUserDTOConvert.INSTANCE.fromUpdateRequest(sysUserUpdateRequest);
		// fix(update)[2024-10-25 17:28:40]: 解决前端传空字符串的问题
		if (StrUtil.isBlank(sysUser.getOrgId())) {
			sysUser.setOrgId(null);
		}
		sysUserDomainService.update(sysUser);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		// 1.删除用户信息
		sysUserDomainService.deleteById(id);
		// 2.删除组织关联信息
		sysUserOrgDomainService.deleteByUserId(id);
		// 3.删除角色关联信息
		sysUserRoleDomainService.deleteByUserId(id);
		// 4.删除密码管理信息
		sysUserAuthsDomainService.deleteByUserId(id);
		return R.ok();
	}

	/**
	 * 记录用户登录信息
	 * @param userId 用户ID
	 * @param loginTime 登录信息
	 */
	public R<Void> updateUserLogin(String userId, LocalDateTime loginTime) {
		sysUserDomainService.updateUserLogin(userId, loginTime);
		return R.ok();
	}

}
