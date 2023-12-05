package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationCreateRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationQueryRequest;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationUpdateRequest;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationQueryResponse;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationResponse;
import io.github.panxiaochao.system.application.convert.IOauth2AuthorizationDTOConvert;
import io.github.panxiaochao.system.application.repository.IOauth2AuthorizationReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;
import io.github.panxiaochao.system.domain.service.Oauth2AuthorizationDomainService;
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
public class Oauth2AuthorizationAppService {

    /**
     *  Domain服务类
     */
    private final Oauth2AuthorizationDomainService oauth2AuthorizationDomainService;

    /**
     *  读模型服务
     */
    private final IOauth2AuthorizationReadModelService oauth2AuthorizationReadModelService;

    /**
     * 查询分页
     * @param pageRequest 请求分页参数对象
     * @param queryRequest 查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<Oauth2AuthorizationQueryResponse> page(RequestPage pageRequest, Oauth2AuthorizationQueryRequest queryRequest) {
        Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
        List<Oauth2AuthorizationQueryResponse> list = oauth2AuthorizationReadModelService.page(pagination, queryRequest);
        return new PageResponse<>(pagination, list);
    }
    
    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<Oauth2AuthorizationResponse> getById(String id) {
        Oauth2Authorization oauth2Authorization = oauth2AuthorizationDomainService.getById(id);
        Oauth2AuthorizationResponse oauth2AuthorizationResponse = IOauth2AuthorizationDTOConvert.INSTANCE.toResponse(oauth2Authorization);
        return R.ok(oauth2AuthorizationResponse);
    }
    
    /**
     * 保存
     * @param oauth2AuthorizationCreateRequest 创建请求对象
     * @return 返回保存对象
     */
    public R<Oauth2AuthorizationResponse> save(Oauth2AuthorizationCreateRequest oauth2AuthorizationCreateRequest) {
        Oauth2Authorization oauth2Authorization = IOauth2AuthorizationDTOConvert.INSTANCE.fromCreateRequest(oauth2AuthorizationCreateRequest);
        oauth2Authorization = oauth2AuthorizationDomainService.save(oauth2Authorization);
        Oauth2AuthorizationResponse oauth2AuthorizationResponse = IOauth2AuthorizationDTOConvert.INSTANCE.toResponse(oauth2Authorization);
        return R.ok(oauth2AuthorizationResponse);
    }
    
    /**
     * 根据主键更新
     * @param oauth2AuthorizationUpdateRequest 更新请求对象
     * @return 空返回
     */
    public R<Void> update(Oauth2AuthorizationUpdateRequest oauth2AuthorizationUpdateRequest) {
        Oauth2Authorization oauth2Authorization = IOauth2AuthorizationDTOConvert.INSTANCE.fromUpdateRequest(oauth2AuthorizationUpdateRequest);
        oauth2AuthorizationDomainService.update(oauth2Authorization);
        return R.ok();
    }
    
    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(String id) {
        oauth2AuthorizationDomainService.deleteById(id);
        return R.ok();
    }

}
