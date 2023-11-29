package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
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
import java.util.Optional;

/**
 * <p>
 * 角色表 服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements ISysRoleService, ISysRoleReadModelService {

	private final SysRoleMapper sysRoleMapper;

	@Override
	public List<SysRoleQueryResponse> page(Pagination pagination, RequestPage<SysRoleQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysRolePO> lqw = Wrappers.lambdaQuery();
		SysRoleQueryRequest sysRoleQueryRequest = Optional.ofNullable(pageRequest.getParamsObject())
			.orElse(new SysRoleQueryRequest());
		//
		if (StringUtils.isNotBlank(sysRoleQueryRequest.getRoleName())) {
			lqw.eq(SysRolePO::getRoleName, sysRoleQueryRequest.getRoleName());
		}
		//
		if (StringUtils.isNotBlank(sysRoleQueryRequest.getRoleCode())) {
			lqw.eq(SysRolePO::getRoleCode, sysRoleQueryRequest.getRoleCode());
		}
		//
		if (StringUtils.isNotBlank(sysRoleQueryRequest.getStatus())) {
			lqw.eq(SysRolePO::getStatus, sysRoleQueryRequest.getStatus());
		}
		// 默认按照主键倒序排序
		lqw.orderByDesc(SysRolePO::getId);
		// 分页查询
		Page<SysRolePO> page = sysRoleMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysRolePOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	@Override
	public SysRole getById(String id) {
		SysRolePO sysRolePO = sysRoleMapper.selectById(id);
		return ISysRolePOConvert.INSTANCE.toEntity(sysRolePO);
	}

	@Override
	public SysRole save(SysRole sysRole) {
		SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
		sysRoleMapper.insert(sysRolePO);
		return ISysRolePOConvert.INSTANCE.toEntity(sysRolePO);
	}

	@Override
	public void update(SysRole sysRole) {
		SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
		sysRoleMapper.updateById(sysRolePO);
	}

	@Override
	public void deleteById(String id) {
		sysRoleMapper.deleteById(id);
	}

}
