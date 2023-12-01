package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysRoleResponse;
import io.github.panxiaochao.system.application.convert.ISysRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysRole;
import io.github.panxiaochao.system.domain.service.SysRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 角色表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysRoleAppService {

    /**
     * 角色表 Domain服务类
     */
    private final SysRoleDomainService sysRoleDomainService;

    /**
     * 角色表 读模型服务
     */
    private final ISysRoleReadModelService sysRoleReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 角色表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysRoleQueryResponse> page(RequestPage pageRequest, SysRoleQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysRoleQueryResponse> list = sysRoleReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysRoleResponse> getById(String id) {
        SysRole sysRole = sysRoleDomainService.getById(id);
        SysRoleResponse sysRoleResponse = ISysRoleDTOConvert.INSTANCE.toResponse(sysRole);
        return R.ok(sysRoleResponse);
    }
    
    /**
     * 保存
     * @param sysRoleCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysRoleResponse> save(SysRoleCreateRequest sysRoleCreateRequest) {
        SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromCreateRequest(sysRoleCreateRequest);
        sysRole = sysRoleDomainService.save(sysRole);
        SysRoleResponse sysRoleResponse = ISysRoleDTOConvert.INSTANCE.toResponse(sysRole);
        return R.ok(sysRoleResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysRoleUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysRoleUpdateRequest sysRoleUpdateRequest) {
        SysRole sysRole = ISysRoleDTOConvert.INSTANCE.fromUpdateRequest(sysRoleUpdateRequest);
        sysRoleDomainService.update(sysRole);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysRoleDomainService.deleteById(id);
        return R.ok();
    }

}
