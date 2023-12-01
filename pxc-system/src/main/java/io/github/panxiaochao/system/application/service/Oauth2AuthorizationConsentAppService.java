package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentCreateRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentQueryRequest;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentUpdateRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentQueryResponse;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentResponse;
import io.github.panxiaochao.system.application.convert.IOauth2AuthorizationConsentDTOConvert;
import io.github.panxiaochao.system.application.repository.IOauth2AuthorizationConsentReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2AuthorizationConsent;
import io.github.panxiaochao.system.domain.service.Oauth2AuthorizationConsentDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>  App服务类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class Oauth2AuthorizationConsentAppService {

    /**
     *  Domain服务类
     */
    private final Oauth2AuthorizationConsentDomainService oauth2AuthorizationConsentDomainService;

    /**
     *  读模型服务
     */
    private final IOauth2AuthorizationConsentReadModelService oauth2AuthorizationConsentReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<Oauth2AuthorizationConsentQueryResponse> page(RequestPage pageRequest, Oauth2AuthorizationConsentQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<Oauth2AuthorizationConsentQueryResponse> list = oauth2AuthorizationConsentReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<Oauth2AuthorizationConsentResponse> getById(String id) {
        Oauth2AuthorizationConsent oauth2AuthorizationConsent = oauth2AuthorizationConsentDomainService.getById(id);
        Oauth2AuthorizationConsentResponse oauth2AuthorizationConsentResponse = IOauth2AuthorizationConsentDTOConvert.INSTANCE.toResponse(oauth2AuthorizationConsent);
        return R.ok(oauth2AuthorizationConsentResponse);
    }
    
    /**
     * 保存
     * @param oauth2AuthorizationConsentCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<Oauth2AuthorizationConsentResponse> save(Oauth2AuthorizationConsentCreateRequest oauth2AuthorizationConsentCreateRequest) {
        Oauth2AuthorizationConsent oauth2AuthorizationConsent = IOauth2AuthorizationConsentDTOConvert.INSTANCE.fromCreateRequest(oauth2AuthorizationConsentCreateRequest);
        oauth2AuthorizationConsent = oauth2AuthorizationConsentDomainService.save(oauth2AuthorizationConsent);
        Oauth2AuthorizationConsentResponse oauth2AuthorizationConsentResponse = IOauth2AuthorizationConsentDTOConvert.INSTANCE.toResponse(oauth2AuthorizationConsent);
        return R.ok(oauth2AuthorizationConsentResponse);
    }
    
    /**
     * 根据主键更新
     * @param oauth2AuthorizationConsentUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(Oauth2AuthorizationConsentUpdateRequest oauth2AuthorizationConsentUpdateRequest) {
        Oauth2AuthorizationConsent oauth2AuthorizationConsent = IOauth2AuthorizationConsentDTOConvert.INSTANCE.fromUpdateRequest(oauth2AuthorizationConsentUpdateRequest);
        oauth2AuthorizationConsentDomainService.update(oauth2AuthorizationConsent);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        oauth2AuthorizationConsentDomainService.deleteById(id);
        return R.ok();
    }

}
