package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysParamCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysParamUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysParamQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysParamResponse;
import io.github.panxiaochao.system.application.convert.ISysParamDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysParamReadModelService;
import io.github.panxiaochao.system.domain.entity.SysParam;
import io.github.panxiaochao.system.domain.service.SysParamDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 系统参数 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysParamAppService {

    /**
     * 系统参数 Domain服务类
     */
    private final SysParamDomainService sysParamDomainService;

    /**
     * 系统参数 读模型服务
     */
    private final ISysParamReadModelService sysParamReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 系统参数查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysParamQueryResponse> page(RequestPage pageRequest, SysParamQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysParamQueryResponse> list = sysParamReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysParamResponse> getById(String id) {
        SysParam sysParam = sysParamDomainService.getById(id);
        SysParamResponse sysParamResponse = ISysParamDTOConvert.INSTANCE.toResponse(sysParam);
        return R.ok(sysParamResponse);
    }
    
    /**
     * 保存
     * @param sysParamCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysParamResponse> save(SysParamCreateRequest sysParamCreateRequest) {
        SysParam sysParam = ISysParamDTOConvert.INSTANCE.fromCreateRequest(sysParamCreateRequest);
        sysParam = sysParamDomainService.save(sysParam);
        SysParamResponse sysParamResponse = ISysParamDTOConvert.INSTANCE.toResponse(sysParam);
        return R.ok(sysParamResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysParamUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysParamUpdateRequest sysParamUpdateRequest) {
        SysParam sysParam = ISysParamDTOConvert.INSTANCE.fromUpdateRequest(sysParamUpdateRequest);
        sysParamDomainService.update(sysParam);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysParamDomainService.deleteById(id);
        return R.ok();
    }

}
