package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuserrole.SysUserRoleUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuserrole.SysUserRoleResponse;
import io.github.panxiaochao.system.application.convert.ISysUserRoleDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserRole;
import io.github.panxiaochao.system.domain.service.SysUserRoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 用户角色表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleAppService {

    /**
     * 用户角色表 Domain服务类
     */
    private final SysUserRoleDomainService sysUserRoleDomainService;

    /**
     * 用户角色表 读模型服务
     */
    private final ISysUserRoleReadModelService sysUserRoleReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 用户角色表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserRoleQueryResponse> page(RequestPage pageRequest, SysUserRoleQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysUserRoleQueryResponse> list = sysUserRoleReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserRoleResponse> getById(String id) {
        SysUserRole sysUserRole = sysUserRoleDomainService.getById(id);
        SysUserRoleResponse sysUserRoleResponse = ISysUserRoleDTOConvert.INSTANCE.toResponse(sysUserRole);
        return R.ok(sysUserRoleResponse);
    }
    
    /**
     * 保存
     * @param sysUserRoleCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserRoleResponse> save(SysUserRoleCreateRequest sysUserRoleCreateRequest) {
        SysUserRole sysUserRole = ISysUserRoleDTOConvert.INSTANCE.fromCreateRequest(sysUserRoleCreateRequest);
        sysUserRole = sysUserRoleDomainService.save(sysUserRole);
        SysUserRoleResponse sysUserRoleResponse = ISysUserRoleDTOConvert.INSTANCE.toResponse(sysUserRole);
        return R.ok(sysUserRoleResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysUserRoleUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserRoleUpdateRequest sysUserRoleUpdateRequest) {
        SysUserRole sysUserRole = ISysUserRoleDTOConvert.INSTANCE.fromUpdateRequest(sysUserRoleUpdateRequest);
        sysUserRoleDomainService.update(sysUserRole);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysUserRoleDomainService.deleteById(id);
        return R.ok();
    }

}
