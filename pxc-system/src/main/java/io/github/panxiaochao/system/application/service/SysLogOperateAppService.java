package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysLogOperateCreateRequest;
import io.github.panxiaochao.system.application.api.request.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.request.SysLogOperateUpdateRequest;
import io.github.panxiaochao.system.application.api.response.SysLogOperateQueryResponse;
import io.github.panxiaochao.system.application.api.response.SysLogOperateResponse;
import io.github.panxiaochao.system.application.convert.ISysLogOperateDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysLogOperateReadModelService;
import io.github.panxiaochao.system.domain.entity.SysLogOperate;
import io.github.panxiaochao.system.domain.service.SysLogOperateDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 系统日志操作表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateAppService {

    /**
     * 系统日志操作表 Domain服务类
     */
    private final SysLogOperateDomainService sysLogOperateDomainService;

    /**
     * 系统日志操作表 读模型服务
     */
    private final ISysLogOperateReadModelService sysLogOperateReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 系统日志操作表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysLogOperateQueryResponse> page(RequestPage pageRequest, SysLogOperateQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysLogOperateQueryResponse> list = sysLogOperateReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysLogOperateResponse> getById(String id) {
        SysLogOperate sysLogOperate = sysLogOperateDomainService.getById(id);
        SysLogOperateResponse sysLogOperateResponse = ISysLogOperateDTOConvert.INSTANCE.toResponse(sysLogOperate);
        return R.ok(sysLogOperateResponse);
    }
    
    /**
     * 保存
     * @param sysLogOperateCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysLogOperateResponse> save(SysLogOperateCreateRequest sysLogOperateCreateRequest) {
        SysLogOperate sysLogOperate = ISysLogOperateDTOConvert.INSTANCE.fromCreateRequest(sysLogOperateCreateRequest);
        sysLogOperate = sysLogOperateDomainService.save(sysLogOperate);
        SysLogOperateResponse sysLogOperateResponse = ISysLogOperateDTOConvert.INSTANCE.toResponse(sysLogOperate);
        return R.ok(sysLogOperateResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysLogOperateUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysLogOperateUpdateRequest sysLogOperateUpdateRequest) {
        SysLogOperate sysLogOperate = ISysLogOperateDTOConvert.INSTANCE.fromUpdateRequest(sysLogOperateUpdateRequest);
        sysLogOperateDomainService.update(sysLogOperate);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysLogOperateDomainService.deleteById(id);
        return R.ok();
    }

}
