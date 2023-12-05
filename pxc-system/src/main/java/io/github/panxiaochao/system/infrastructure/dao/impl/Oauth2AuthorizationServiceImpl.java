package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.oauth2authorizationconsent.Oauth2AuthorizationQueryRequest;
import io.github.panxiaochao.system.application.api.response.oauth2authorizationconsent.Oauth2AuthorizationQueryResponse;
import io.github.panxiaochao.system.application.repository.IOauth2AuthorizationReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2Authorization;
import io.github.panxiaochao.system.domain.repository.IOauth2AuthorizationService;
import io.github.panxiaochao.system.infrastructure.convert.IOauth2AuthorizationPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.Oauth2AuthorizationMapper;
import io.github.panxiaochao.system.infrastructure.po.Oauth2AuthorizationPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>  Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class Oauth2AuthorizationServiceImpl implements IOauth2AuthorizationService, IOauth2AuthorizationReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final Oauth2AuthorizationMapper oauth2AuthorizationMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<Oauth2AuthorizationQueryResponse> page(Pagination pagination, Oauth2AuthorizationQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<Oauth2AuthorizationPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<Oauth2AuthorizationPO> page = oauth2AuthorizationMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return IOauth2AuthorizationPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<Oauth2AuthorizationPO> lambdaQuery(Oauth2AuthorizationQueryRequest queryRequest) {
        LambdaQueryWrapper<Oauth2AuthorizationPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(Oauth2AuthorizationPO::getId);
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getRegisteredClientId())) {
                lqw.eq(Oauth2AuthorizationPO::getRegisteredClientId, queryRequest.getRegisteredClientId());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getPrincipalName())) {
                lqw.eq(Oauth2AuthorizationPO::getPrincipalName, queryRequest.getPrincipalName());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAuthorizationGrantType())) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizationGrantType, queryRequest.getAuthorizationGrantType());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAuthorizedScopes())) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizedScopes, queryRequest.getAuthorizedScopes());
            }
            // 如果  不为空
                if (queryRequest.getAttributes() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAttributes, queryRequest.getAttributes());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getState())) {
                lqw.eq(Oauth2AuthorizationPO::getState, queryRequest.getState());
            }
            // 如果  不为空
                if (queryRequest.getAuthorizationCodeValue() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizationCodeValue, queryRequest.getAuthorizationCodeValue());
            }
            // 如果  不为空
            if (queryRequest.getAuthorizationCodeIssuedAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizationCodeIssuedAt, queryRequest.getAuthorizationCodeIssuedAt());
            }
            // 如果  不为空
            if (queryRequest.getAuthorizationCodeExpiresAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizationCodeExpiresAt, queryRequest.getAuthorizationCodeExpiresAt());
            }
            // 如果  不为空
                if (queryRequest.getAuthorizationCodeMetadata() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAuthorizationCodeMetadata, queryRequest.getAuthorizationCodeMetadata());
            }
            // 如果  不为空
                if (queryRequest.getAccessTokenValue() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenValue, queryRequest.getAccessTokenValue());
            }
            // 如果  不为空
            if (queryRequest.getAccessTokenIssuedAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenIssuedAt, queryRequest.getAccessTokenIssuedAt());
            }
            // 如果  不为空
            if (queryRequest.getAccessTokenExpiresAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenExpiresAt, queryRequest.getAccessTokenExpiresAt());
            }
            // 如果  不为空
                if (queryRequest.getAccessTokenMetadata() != null) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenMetadata, queryRequest.getAccessTokenMetadata());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAccessTokenType())) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenType, queryRequest.getAccessTokenType());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAccessTokenScopes())) {
                lqw.eq(Oauth2AuthorizationPO::getAccessTokenScopes, queryRequest.getAccessTokenScopes());
            }
            // 如果  不为空
                if (queryRequest.getOidcIdTokenValue() != null) {
                lqw.eq(Oauth2AuthorizationPO::getOidcIdTokenValue, queryRequest.getOidcIdTokenValue());
            }
            // 如果  不为空
            if (queryRequest.getOidcIdTokenIssuedAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getOidcIdTokenIssuedAt, queryRequest.getOidcIdTokenIssuedAt());
            }
            // 如果  不为空
            if (queryRequest.getOidcIdTokenExpiresAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getOidcIdTokenExpiresAt, queryRequest.getOidcIdTokenExpiresAt());
            }
            // 如果  不为空
                if (queryRequest.getOidcIdTokenMetadata() != null) {
                lqw.eq(Oauth2AuthorizationPO::getOidcIdTokenMetadata, queryRequest.getOidcIdTokenMetadata());
            }
            // 如果  不为空
                if (queryRequest.getRefreshTokenValue() != null) {
                lqw.eq(Oauth2AuthorizationPO::getRefreshTokenValue, queryRequest.getRefreshTokenValue());
            }
            // 如果  不为空
            if (queryRequest.getRefreshTokenIssuedAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getRefreshTokenIssuedAt, queryRequest.getRefreshTokenIssuedAt());
            }
            // 如果  不为空
            if (queryRequest.getRefreshTokenExpiresAt() != null) {
                lqw.eq(Oauth2AuthorizationPO::getRefreshTokenExpiresAt, queryRequest.getRefreshTokenExpiresAt());
            }
            // 如果  不为空
                if (queryRequest.getRefreshTokenMetadata() != null) {
                lqw.eq(Oauth2AuthorizationPO::getRefreshTokenMetadata, queryRequest.getRefreshTokenMetadata());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return Oauth2Authorization 实体
     */
    @Override
    public Oauth2Authorization getById(String id) {
        Oauth2AuthorizationPO oauth2AuthorizationPO = oauth2AuthorizationMapper.selectById(id);
        return IOauth2AuthorizationPOConvert.INSTANCE.toEntity(oauth2AuthorizationPO);
    }

    /**
     * 保存
     * @param oauth2Authorization Oauth2Authorization 实体
     * @return Oauth2Authorization 实体
     */
    @Override
    public Oauth2Authorization save(Oauth2Authorization oauth2Authorization) {
        Oauth2AuthorizationPO oauth2AuthorizationPO = IOauth2AuthorizationPOConvert.INSTANCE.fromEntity(oauth2Authorization);
        oauth2AuthorizationMapper.insert(oauth2AuthorizationPO);
        return IOauth2AuthorizationPOConvert.INSTANCE.toEntity(oauth2AuthorizationPO);
    }

    /**
     * 根据主键更新
     * @param oauth2Authorization Oauth2Authorization 实体
     */
    @Override
    public void update(Oauth2Authorization oauth2Authorization) {
        Oauth2AuthorizationPO oauth2AuthorizationPO = IOauth2AuthorizationPOConvert.INSTANCE.fromEntity(oauth2Authorization);
        oauth2AuthorizationMapper.updateById(oauth2AuthorizationPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        oauth2AuthorizationMapper.deleteById(id);
    }

}
