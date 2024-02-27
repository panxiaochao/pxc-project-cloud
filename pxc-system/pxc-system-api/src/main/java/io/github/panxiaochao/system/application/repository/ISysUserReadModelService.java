package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;

import java.util.List;

/**
 * <p>
 * 用户表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 用户表查询请求对象
	 * @return 分页结果数组
	 */
	List<SysUserQueryResponse> page(Pagination pagination, SysUserQueryRequest queryRequest);

	/**
	 * 查询单条记录
	 * @param queryRequest 用户表查询请求对象
	 * @return 结果单条记录
	 */
	SysUserQueryResponse getOne(SysUserQueryRequest queryRequest);

	/**
	 * 根据用户名的登录类型查找用户
	 * @param username 登录名
	 * @param identityType 登录类型
	 * @return 用户综合信息
	 */
	SysUserLogin loadUserByIdentityType(String username, String identityType);

}
