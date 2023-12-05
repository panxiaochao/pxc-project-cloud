package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysmenu.SysMenuUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysmenu.SysMenuResponse;
import io.github.panxiaochao.system.application.convert.ISysMenuDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.SysMenu;
import io.github.panxiaochao.system.domain.service.SysMenuDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 菜单配置 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysMenuAppService {

    /**
     * 菜单配置 Domain服务类
     */
    private final SysMenuDomainService sysMenuDomainService;

    /**
     * 菜单配置 读模型服务
     */
    private final ISysMenuReadModelService sysMenuReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 菜单配置查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysMenuQueryResponse> page(RequestPage pageRequest, SysMenuQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysMenuQueryResponse> list = sysMenuReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysMenuResponse> getById(String id) {
        SysMenu sysMenu = sysMenuDomainService.getById(id);
        SysMenuResponse sysMenuResponse = ISysMenuDTOConvert.INSTANCE.toResponse(sysMenu);
        return R.ok(sysMenuResponse);
    }
    
    /**
     * 保存
     * @param sysMenuCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysMenuResponse> save(SysMenuCreateRequest sysMenuCreateRequest) {
        SysMenu sysMenu = ISysMenuDTOConvert.INSTANCE.fromCreateRequest(sysMenuCreateRequest);
        sysMenu = sysMenuDomainService.save(sysMenu);
        SysMenuResponse sysMenuResponse = ISysMenuDTOConvert.INSTANCE.toResponse(sysMenu);
        return R.ok(sysMenuResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysMenuUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysMenuUpdateRequest sysMenuUpdateRequest) {
        SysMenu sysMenu = ISysMenuDTOConvert.INSTANCE.fromUpdateRequest(sysMenuUpdateRequest);
        sysMenuDomainService.update(sysMenu);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysMenuDomainService.deleteById(id);
        return R.ok();
    }

}
