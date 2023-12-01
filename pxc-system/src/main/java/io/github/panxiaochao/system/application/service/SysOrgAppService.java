package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysOrgCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysOrgQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysOrgUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysOrgQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysOrgResponse;
import io.github.panxiaochao.system.application.convert.ISysOrgDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.SysOrg;
import io.github.panxiaochao.system.domain.service.SysOrgDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 机构部门表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysOrgAppService {

    /**
     * 机构部门表 Domain服务类
     */
    private final SysOrgDomainService sysOrgDomainService;

    /**
     * 机构部门表 读模型服务
     */
    private final ISysOrgReadModelService sysOrgReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 机构部门表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysOrgQueryResponse> page(RequestPage pageRequest, SysOrgQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysOrgQueryResponse> list = sysOrgReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysOrgResponse> getById(String id) {
        SysOrg sysOrg = sysOrgDomainService.getById(id);
        SysOrgResponse sysOrgResponse = ISysOrgDTOConvert.INSTANCE.toResponse(sysOrg);
        return R.ok(sysOrgResponse);
    }
    
    /**
     * 保存
     * @param sysOrgCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysOrgResponse> save(SysOrgCreateRequest sysOrgCreateRequest) {
        SysOrg sysOrg = ISysOrgDTOConvert.INSTANCE.fromCreateRequest(sysOrgCreateRequest);
        sysOrg = sysOrgDomainService.save(sysOrg);
        SysOrgResponse sysOrgResponse = ISysOrgDTOConvert.INSTANCE.toResponse(sysOrg);
        return R.ok(sysOrgResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysOrgUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysOrgUpdateRequest sysOrgUpdateRequest) {
        SysOrg sysOrg = ISysOrgDTOConvert.INSTANCE.fromUpdateRequest(sysOrgUpdateRequest);
        sysOrgDomainService.update(sysOrg);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysOrgDomainService.deleteById(id);
        return R.ok();
    }

}
