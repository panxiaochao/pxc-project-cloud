package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysuser.SysUserUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysuser.SysUserResponse;
import io.github.panxiaochao.system.application.convert.ISysUserDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.domain.service.SysUserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 用户表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAppService {

    /**
     * 用户表 Domain服务类
     */
    private final SysUserDomainService sysUserDomainService;

    /**
     * 用户表 读模型服务
     */
    private final ISysUserReadModelService sysUserReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 用户表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserQueryResponse> page(RequestPage pageRequest, SysUserQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysUserQueryResponse> list = sysUserReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserResponse> getById(String id) {
        SysUser sysUser = sysUserDomainService.getById(id);
        SysUserResponse sysUserResponse = ISysUserDTOConvert.INSTANCE.toResponse(sysUser);
        return R.ok(sysUserResponse);
    }
    
    /**
     * 保存
     * @param sysUserCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserResponse> save(SysUserCreateRequest sysUserCreateRequest) {
        SysUser sysUser = ISysUserDTOConvert.INSTANCE.fromCreateRequest(sysUserCreateRequest);
        sysUser = sysUserDomainService.save(sysUser);
        SysUserResponse sysUserResponse = ISysUserDTOConvert.INSTANCE.toResponse(sysUser);
        return R.ok(sysUserResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysUserUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserUpdateRequest sysUserUpdateRequest) {
        SysUser sysUser = ISysUserDTOConvert.INSTANCE.fromUpdateRequest(sysUserUpdateRequest);
        sysUserDomainService.update(sysUser);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysUserDomainService.deleteById(id);
        return R.ok();
    }

}
