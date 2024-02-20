package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysrolemenu.SysRoleMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysrolemenu.SysRoleMenuQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysRoleMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRoleMenu;
import io.github.panxiaochao.system.domain.repository.ISysRoleMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysRoleMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysRoleMenuMapper;
import io.github.panxiaochao.system.infrastructure.po.SysRoleMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色菜单表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuServiceImpl implements ISysRoleMenuService, ISysRoleMenuReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysRoleMenuMapper sysRoleMenuMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysRoleMenuQueryResponse> page(Pagination pagination, SysRoleMenuQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysRoleMenuPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysRoleMenuPO> page = sysRoleMenuMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysRoleMenuPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 角色菜单表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<SysRoleMenuQueryResponse> selectList(SysRoleMenuQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysRoleMenuPO> lqw = lambdaQuery(queryRequest);
		return ISysRoleMenuPOConvert.INSTANCE.toQueryResponse(sysRoleMenuMapper.selectList(lqw));
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysRoleMenuPO> lambdaQuery(SysRoleMenuQueryRequest queryRequest) {
		LambdaQueryWrapper<SysRoleMenuPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 默认按照主键倒序排序
			lqw.orderByDesc(SysRoleMenuPO::getMenuId);
			if (StringUtils.isNoneBlank(queryRequest.getRoleId())) {
				lqw.eq(SysRoleMenuPO::getRoleId, queryRequest.getRoleId());
			}
			if (StringUtils.isNoneBlank(queryRequest.getMenuId())) {
				lqw.eq(SysRoleMenuPO::getMenuId, queryRequest.getMenuId());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysRoleMenu 实体
	 */
	@Override
	public SysRoleMenu getById(String id) {
		SysRoleMenuPO sysRoleMenuPO = sysRoleMenuMapper.selectById(id);
		return ISysRoleMenuPOConvert.INSTANCE.toEntity(sysRoleMenuPO);
	}

	/**
	 * 保存
	 * @param sysRoleMenu SysRoleMenu 实体
	 * @return SysRoleMenu 实体
	 */
	@Override
	public SysRoleMenu save(SysRoleMenu sysRoleMenu) {
		SysRoleMenuPO sysRoleMenuPO = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenu);
		sysRoleMenuMapper.insert(sysRoleMenuPO);
		return ISysRoleMenuPOConvert.INSTANCE.toEntity(sysRoleMenuPO);
	}

	/**
	 * 根据主键更新
	 * @param sysRoleMenu SysRoleMenu 实体
	 */
	@Override
	public void update(SysRoleMenu sysRoleMenu) {
		SysRoleMenuPO sysRoleMenuPO = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenu);
		sysRoleMenuMapper.updateById(sysRoleMenuPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysRoleMenuMapper.deleteById(id);
	}

	/**
	 * 删除当前角色的所有关联数据
	 * @param roleId 角色Id
	 */
	@Override
	public void deleteByRoleId(String roleId) {
		sysRoleMenuMapper.delete(new LambdaQueryWrapper<SysRoleMenuPO>().eq(SysRoleMenuPO::getRoleId, roleId));
	}

	/**
	 * 批量保存
	 * @param list SysRoleMenu 数据实体
	 */
	@Override
	public void saveBath(List<SysRoleMenu> list) {
		List<SysRoleMenuPO> sysRoleMenuPOList = ISysRoleMenuPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(sysRoleMenuPOList);
	}

}
