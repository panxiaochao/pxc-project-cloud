package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.exception.ServerRuntimeException;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.common.exception.UserLoginException;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.domain.entity.SysUserLogin;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 用户表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements ISysUserService, ISysUserReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysUserMapper sysUserMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 用户表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysUserQueryResponse> page(Pagination pagination, SysUserQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysUserPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysUserPO> page = sysUserMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysUserPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 用户表查询请求对象
	 * @return 结果单条记录
	 */
	@Override
	public SysUserQueryResponse getOne(SysUserQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysUserPO> lqw = lambdaQuery(queryRequest);
		try {
			SysUserPO sysUserPO = sysUserMapper.selectOne(lqw);
			return ISysUserPOConvert.INSTANCE.toQueryResponse(sysUserPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据用户名的登录类型查找用户
	 * @param username 登录名
	 * @param identityType 登录类型
	 * @return 用户综合信息
	 */
	@Override
	public SysUserLogin loadUserByIdentityType(String username, String identityType) {
		List<SysUserLogin> sysUserLoginList = sysUserMapper.loadUserByIdentityType(username, identityType);
		if (!CollectionUtils.isEmpty(sysUserLoginList)) {
			if (sysUserLoginList.size() > 1) {
				throw new ServerRuntimeException(UserLoginException.USER_MULTIPLE_EXCEPTION);
			}
			else {
				return sysUserLoginList.get(0);
			}
		}
		return null;
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysUserPO> lambdaQuery(SysUserQueryRequest queryRequest) {
		LambdaQueryWrapper<SysUserPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysUserPO::getId);
			// 如果 用户真实姓名 不为空
			if (StringUtils.isNotBlank(queryRequest.getRealName())) {
				lqw.like(SysUserPO::getRealName, queryRequest.getRealName());
			}
			// 如果 用户昵称（花名） 不为空
			if (StringUtils.isNotBlank(queryRequest.getNickName())) {
				lqw.eq(SysUserPO::getNickName, queryRequest.getNickName());
			}
			// 如果 身份证 不为空
			if (StringUtils.isNotBlank(queryRequest.getIdCard())) {
				lqw.eq(SysUserPO::getIdCard, queryRequest.getIdCard());
			}
			// 如果 性别：1男，0女 不为空
			if (StringUtils.isNotBlank(queryRequest.getSex())) {
				lqw.eq(SysUserPO::getSex, queryRequest.getSex());
			}
			// 如果 状态：1正常，0不正常 不为空
			if (StringUtils.isNotBlank(queryRequest.getState())) {
				lqw.eq(SysUserPO::getState, queryRequest.getState());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUser 实体
	 */
	@Override
	public SysUser getById(String id) {
		SysUserPO sysUserPO = sysUserMapper.selectById(id);
		return ISysUserPOConvert.INSTANCE.toEntity(sysUserPO);
	}

	/**
	 * 保存
	 * @param sysUser SysUser 实体
	 * @return SysUser 实体
	 */
	@Override
	public SysUser save(SysUser sysUser) {
		SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
		sysUserMapper.insert(sysUserPO);
		return ISysUserPOConvert.INSTANCE.toEntity(sysUserPO);
	}

	/**
	 * 根据主键更新
	 * @param sysUser SysUser 实体
	 */
	@Override
	public void update(SysUser sysUser) {
		SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
		sysUserMapper.updateById(sysUserPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysUserMapper.deleteById(id);
	}

	/**
	 * 记录用户登录信息
	 * @param userId 用户ID
	 * @param loginTime 登录信息
	 */
	@Override
	public void updateUserLogin(String userId, LocalDateTime loginTime) {
		sysUserMapper.update(new LambdaUpdateWrapper<SysUserPO>().eq(SysUserPO::getId, userId)
			.set(SysUserPO::getLoginTime, loginTime)
			.setSql("login_nums = login_nums + 1"));
	}

}
