package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysjob.SysJobQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysjob.SysJobResponse;
import io.github.panxiaochao.system.application.convert.ISysJobDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysJobReadModelService;
import io.github.panxiaochao.system.domain.entity.SysJob;
import io.github.panxiaochao.system.domain.service.SysJobDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 定时任务调度表 App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysJobAppService {

    /**
     * 定时任务调度表 Domain服务类
     */
    private final SysJobDomainService sysJobDomainService;

    /**
     * 定时任务调度表 读模型服务
     */
    private final ISysJobReadModelService sysJobReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 定时任务调度表查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysJobQueryResponse> page(RequestPage pageRequest, SysJobQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<SysJobQueryResponse> list = sysJobReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysJobResponse> getById(String id) {
        SysJob sysJob = sysJobDomainService.getById(id);
        SysJobResponse sysJobResponse = ISysJobDTOConvert.INSTANCE.toResponse(sysJob);
        return R.ok(sysJobResponse);
    }
    
    /**
     * 保存
     * @param sysJobCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<SysJobResponse> save(SysJobCreateRequest sysJobCreateRequest) {
        SysJob sysJob = ISysJobDTOConvert.INSTANCE.fromCreateRequest(sysJobCreateRequest);
        sysJob = sysJobDomainService.save(sysJob);
        SysJobResponse sysJobResponse = ISysJobDTOConvert.INSTANCE.toResponse(sysJob);
        return R.ok(sysJobResponse);
    }
    
    /**
     * 根据主键更新
     * @param sysJobUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysJobUpdateRequest sysJobUpdateRequest) {
        SysJob sysJob = ISysJobDTOConvert.INSTANCE.fromUpdateRequest(sysJobUpdateRequest);
        sysJobDomainService.update(sysJob);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        sysJobDomainService.deleteById(id);
        return R.ok();
    }

}
