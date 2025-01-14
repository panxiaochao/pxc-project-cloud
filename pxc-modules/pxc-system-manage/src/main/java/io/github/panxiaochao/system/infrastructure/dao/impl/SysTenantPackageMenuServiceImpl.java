package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.systenantpackagemenu.SysTenantPackageMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.systenantpackagemenu.SysTenantPackageMenuQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysTenantPackageMenu;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPackageMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysTenantPackageMenuMapper;
import io.github.panxiaochao.system.infrastructure.po.SysTenantPackageMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户套餐菜单表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2024-06-28
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageMenuServiceImpl
		implements ISysTenantPackageMenuService, ISysTenantPackageMenuReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysTenantPackageMenuMapper sysTenantPackageMenuMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysTenantPackageMenuQueryResponse> page(Pagination pagination,
			SysTenantPackageMenuQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = lambdaQuery(queryRequest);
		// 分页查询
		Page<SysTenantPackageMenuPO> page = sysTenantPackageMenuMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询数组
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 结果数组
	 */
	@Override
	public List<SysTenantPackageMenuQueryResponse> selectList(SysTenantPackageMenuQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = lambdaQuery(queryRequest);
		return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryResponse(sysTenantPackageMenuMapper.selectList(lqw));
	}

	/**
	 * 查询单条记录
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 租户套餐菜单表查询响应对象
	 */
	@Override
	public SysTenantPackageMenuQueryResponse getOne(SysTenantPackageMenuQueryRequest queryRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = lambdaQuery(queryRequest);
		try {
			SysTenantPackageMenuPO sysTenantPackageMenuPO = sysTenantPackageMenuMapper.selectOne(lqw);
			return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryResponse(sysTenantPackageMenuPO);
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * 查询条件
	 * @param queryRequest 租户套餐菜单表查询请求对象
	 * @return 租户套餐菜单表Lambda表达式
	 */
	private LambdaQueryWrapper<SysTenantPackageMenuPO> lambdaQuery(SysTenantPackageMenuQueryRequest queryRequest) {
		LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 租户套餐id 不为空
			if (StringUtils.isNotBlank(queryRequest.getPackageId())) {
				lqw.eq(SysTenantPackageMenuPO::getPackageId, queryRequest.getPackageId());
			}
			// 如果 菜单ID 不为空
			if (StringUtils.isNotBlank(queryRequest.getMenuId())) {
				lqw.eq(SysTenantPackageMenuPO::getMenuId, queryRequest.getMenuId());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysTenantPackageMenu 实体
	 */
	@Override
	public SysTenantPackageMenu getById(String id) {
		SysTenantPackageMenuPO sysTenantPackageMenuPO = sysTenantPackageMenuMapper.selectById(id);
		return ISysTenantPackageMenuPOConvert.INSTANCE.toEntity(sysTenantPackageMenuPO);
	}

	/**
	 * 保存
	 * @param sysTenantPackageMenu SysTenantPackageMenu 实体
	 * @return SysTenantPackageMenu 实体
	 */
	@Override
	public SysTenantPackageMenu save(SysTenantPackageMenu sysTenantPackageMenu) {
		SysTenantPackageMenuPO sysTenantPackageMenuPO = ISysTenantPackageMenuPOConvert.INSTANCE
			.fromEntity(sysTenantPackageMenu);
		sysTenantPackageMenuMapper.insert(sysTenantPackageMenuPO);
		return ISysTenantPackageMenuPOConvert.INSTANCE.toEntity(sysTenantPackageMenuPO);
	}

	/**
	 * 根据主键更新
	 * @param sysTenantPackageMenu SysTenantPackageMenu 实体
	 */
	@Override
	public void update(SysTenantPackageMenu sysTenantPackageMenu) {
		SysTenantPackageMenuPO sysTenantPackageMenuPO = ISysTenantPackageMenuPOConvert.INSTANCE
			.fromEntity(sysTenantPackageMenu);
		sysTenantPackageMenuMapper.updateById(sysTenantPackageMenuPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysTenantPackageMenuMapper.deleteById(id);
	}

	/**
	 * 删除当前租户套餐的所有关联数据
	 * @param packageId 租户套餐Id
	 */
	@Override
	public void deleteByPackageId(String packageId) {
		sysTenantPackageMenuMapper.delete(
				new LambdaQueryWrapper<SysTenantPackageMenuPO>().eq(SysTenantPackageMenuPO::getPackageId, packageId));
	}

	/**
	 * 批量保存
	 * @param list SysTenantPackageMenu 数据实体
	 */
	@Override
	public void saveBath(List<SysTenantPackageMenu> list) {
		List<SysTenantPackageMenuPO> sysRoleMenuPOList = ISysTenantPackageMenuPOConvert.INSTANCE.fromEntity(list);
		Db.saveBatch(sysRoleMenuPOList);
	}

}
