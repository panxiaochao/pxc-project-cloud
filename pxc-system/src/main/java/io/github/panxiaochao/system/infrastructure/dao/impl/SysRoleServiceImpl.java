package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import io.github.panxiaochao.system.infrastructure.convert.ISysRolePOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysRoleMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRolePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements ISysRoleService, ISysRoleReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysRoleMapper sysRoleMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 角色表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysRoleQueryResponse> page(Pagination pagination, SysRoleQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysRolePO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysRolePO> page = sysRoleMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysRolePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysRolePO> lambdaQuery(SysRoleQueryRequest queryRequest) {
		LambdaQueryWrapper<SysRolePO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照排序升序
			lqw.orderByAsc(SysRolePO::getSort);
			// 如果 角色名称 不为空
			if (StringUtils.isNotBlank(queryRequest.getRoleName())) {
				lqw.like(SysRolePO::getRoleName, queryRequest.getRoleName());
			}
			// 如果 角色code 不为空
			if (StringUtils.isNotBlank(queryRequest.getRoleCode())) {
				lqw.eq(SysRolePO::getRoleCode, queryRequest.getRoleCode());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysRole 实体
	 */
	@Override
	public SysRole getById(String id) {
		SysRolePO sysRolePO = sysRoleMapper.selectById(id);
		return ISysRolePOConvert.INSTANCE.toEntity(sysRolePO);
	}

	/**
	 * 保存
	 * @param sysRole SysRole 实体
	 * @return SysRole 实体
	 */
	@Override
	public SysRole save(SysRole sysRole) {
		SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
		sysRoleMapper.insert(sysRolePO);
		return ISysRolePOConvert.INSTANCE.toEntity(sysRolePO);
	}

	/**
	 * 根据主键更新
	 * @param sysRole SysRole 实体
	 */
	@Override
	public void update(SysRole sysRole) {
		SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
		sysRoleMapper.updateById(sysRolePO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysRoleMapper.deleteById(id);
	}

}
