package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysMenu;
import io.github.panxiaochao.system.domain.repository.ISysMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysMenuMapper;
import io.github.panxiaochao.system.infrastructure.po.SysMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 菜单配置 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl implements ISysMenuService, ISysMenuReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysMenuMapper sysMenuMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 菜单配置查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysMenuQueryResponse> page(Pagination pagination, SysMenuQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysMenuPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysMenuPO> page = sysMenuMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysMenuPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysMenuPO> lambdaQuery(SysMenuQueryRequest queryRequest) {
        LambdaQueryWrapper<SysMenuPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysMenuPO::getId);
            // 如果 父id 不为空
            if (queryRequest.getParentId() != null) {
                lqw.eq(SysMenuPO::getParentId, queryRequest.getParentId());
            }
            // 如果 菜单名称 不为空
            if (StringUtils.isNotBlank(queryRequest.getMenuName())) {
                lqw.eq(SysMenuPO::getMenuName, queryRequest.getMenuName());
            }
            // 如果 链接地址 不为空
            if (StringUtils.isNotBlank(queryRequest.getUrl())) {
                lqw.eq(SysMenuPO::getUrl, queryRequest.getUrl());
            }
            // 如果 一级菜单默认跳转地址 不为空
            if (StringUtils.isNotBlank(queryRequest.getRedirectUrl())) {
                lqw.eq(SysMenuPO::getRedirectUrl, queryRequest.getRedirectUrl());
            }
            // 如果 前端组件 不为空
            if (StringUtils.isNotBlank(queryRequest.getComponent())) {
                lqw.eq(SysMenuPO::getComponent, queryRequest.getComponent());
            }
            // 如果 前端组件名字 不为空
            if (StringUtils.isNotBlank(queryRequest.getComponentName())) {
                lqw.eq(SysMenuPO::getComponentName, queryRequest.getComponentName());
            }
            // 如果 菜单权限编码 不为空
            if (StringUtils.isNotBlank(queryRequest.getPermissionCode())) {
                lqw.eq(SysMenuPO::getPermissionCode, queryRequest.getPermissionCode());
            }
            // 如果 菜单权限状态：1显示，2禁用 不为空
            if (StringUtils.isNotBlank(queryRequest.getPermissionStatus())) {
                lqw.eq(SysMenuPO::getPermissionStatus, queryRequest.getPermissionStatus());
            }
            // 如果 菜单图标 不为空
            if (StringUtils.isNotBlank(queryRequest.getIcon())) {
                lqw.eq(SysMenuPO::getIcon, queryRequest.getIcon());
            }
            // 如果 类型：0-一级菜单；1-子菜单 ；2-按钮权限 不为空
            if (StringUtils.isNotBlank(queryRequest.getMenuType())) {
                lqw.eq(SysMenuPO::getMenuType, queryRequest.getMenuType());
            }
            // 如果 打开页面方式： 0-内部；1-外链（默认值0） 不为空
            if (StringUtils.isNotBlank(queryRequest.getOpenType())) {
                lqw.eq(SysMenuPO::getOpenType, queryRequest.getOpenType());
            }
            // 如果 是否显示：0-否；1-是（默认值1） 不为空
            if (StringUtils.isNotBlank(queryRequest.getIsDisplay())) {
                lqw.eq(SysMenuPO::getIsDisplay, queryRequest.getIsDisplay());
            }
            // 如果 是否路由菜单：0-不是 1-是（默认值1） 不为空
            if (StringUtils.isNotBlank(queryRequest.getIsRoute())) {
                lqw.eq(SysMenuPO::getIsRoute, queryRequest.getIsRoute());
            }
            // 如果 是否缓存页面：0-不是 1-是（默认值0） 不为空
            if (StringUtils.isNotBlank(queryRequest.getKeepAlive())) {
                lqw.eq(SysMenuPO::getKeepAlive, queryRequest.getKeepAlive());
            }
            // 如果 是否隐藏路由菜单：0-不是 1-是（默认值0） 不为空
            if (StringUtils.isNotBlank(queryRequest.getIsHidden())) {
                lqw.eq(SysMenuPO::getIsHidden, queryRequest.getIsHidden());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(queryRequest.getRemark())) {
                lqw.eq(SysMenuPO::getRemark, queryRequest.getRemark());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(queryRequest.getState())) {
                lqw.eq(SysMenuPO::getState, queryRequest.getState());
            }
            // 如果 排序 不为空
            if (queryRequest.getSort() != null) {
                lqw.eq(SysMenuPO::getSort, queryRequest.getSort());
            }
            // 如果 创建人 不为空
            if (queryRequest.getCreateId() != null) {
                lqw.eq(SysMenuPO::getCreateId, queryRequest.getCreateId());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysMenuPO::getCreateTime, queryRequest.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (queryRequest.getUpdateTime() != null) {
                lqw.eq(SysMenuPO::getUpdateTime, queryRequest.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysMenu 实体
     */
    @Override
    public SysMenu getById(String id) {
        SysMenuPO sysMenuPO = sysMenuMapper.selectById(id);
        return ISysMenuPOConvert.INSTANCE.toEntity(sysMenuPO);
    }

    /**
     * 保存
     * @param sysMenu SysMenu 实体
     * @return SysMenu 实体
     */
    @Override
    public SysMenu save(SysMenu sysMenu) {
        SysMenuPO sysMenuPO = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenu);
        sysMenuMapper.insert(sysMenuPO);
        return ISysMenuPOConvert.INSTANCE.toEntity(sysMenuPO);
    }

    /**
     * 根据主键更新
     * @param sysMenu SysMenu 实体
     */
    @Override
    public void update(SysMenu sysMenu) {
        SysMenuPO sysMenuPO = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenu);
        sysMenuMapper.updateById(sysMenuPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysMenuMapper.deleteById(id);
    }

}
