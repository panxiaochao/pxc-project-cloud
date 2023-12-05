package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.oauth2registeredclient.Oauth2RegisteredClientQueryRequest;
import io.github.panxiaochao.system.application.api.response.oauth2registeredclient.Oauth2RegisteredClientQueryResponse;
import io.github.panxiaochao.system.application.repository.IOauth2RegisteredClientReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2RegisteredClient;
import io.github.panxiaochao.system.domain.repository.IOauth2RegisteredClientService;
import io.github.panxiaochao.system.infrastructure.convert.IOauth2RegisteredClientPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.Oauth2RegisteredClientMapper;
import io.github.panxiaochao.system.infrastructure.po.Oauth2RegisteredClientPO;
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
public class Oauth2RegisteredClientServiceImpl implements IOauth2RegisteredClientService, IOauth2RegisteredClientReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final Oauth2RegisteredClientMapper oauth2RegisteredClientMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<Oauth2RegisteredClientQueryResponse> page(Pagination pagination, Oauth2RegisteredClientQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<Oauth2RegisteredClientPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<Oauth2RegisteredClientPO> page = oauth2RegisteredClientMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return IOauth2RegisteredClientPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<Oauth2RegisteredClientPO> lambdaQuery(Oauth2RegisteredClientQueryRequest queryRequest) {
        LambdaQueryWrapper<Oauth2RegisteredClientPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(Oauth2RegisteredClientPO::getId);
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getClientId())) {
                lqw.eq(Oauth2RegisteredClientPO::getClientId, queryRequest.getClientId());
            }
            // 如果  不为空
            if (queryRequest.getClientIdIssuedAt() != null) {
                lqw.eq(Oauth2RegisteredClientPO::getClientIdIssuedAt, queryRequest.getClientIdIssuedAt());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getClientSecret())) {
                lqw.eq(Oauth2RegisteredClientPO::getClientSecret, queryRequest.getClientSecret());
            }
            // 如果  不为空
            if (queryRequest.getClientSecretExpiresAt() != null) {
                lqw.eq(Oauth2RegisteredClientPO::getClientSecretExpiresAt, queryRequest.getClientSecretExpiresAt());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getClientName())) {
                lqw.eq(Oauth2RegisteredClientPO::getClientName, queryRequest.getClientName());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getClientAuthenticationMethods())) {
                lqw.eq(Oauth2RegisteredClientPO::getClientAuthenticationMethods, queryRequest.getClientAuthenticationMethods());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAuthorizationGrantTypes())) {
                lqw.eq(Oauth2RegisteredClientPO::getAuthorizationGrantTypes, queryRequest.getAuthorizationGrantTypes());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getRedirectUris())) {
                lqw.eq(Oauth2RegisteredClientPO::getRedirectUris, queryRequest.getRedirectUris());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getScopes())) {
                lqw.eq(Oauth2RegisteredClientPO::getScopes, queryRequest.getScopes());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getClientSettings())) {
                lqw.eq(Oauth2RegisteredClientPO::getClientSettings, queryRequest.getClientSettings());
            }
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getTokenSettings())) {
                lqw.eq(Oauth2RegisteredClientPO::getTokenSettings, queryRequest.getTokenSettings());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return Oauth2RegisteredClient 实体
     */
    @Override
    public Oauth2RegisteredClient getById(String id) {
        Oauth2RegisteredClientPO oauth2RegisteredClientPO = oauth2RegisteredClientMapper.selectById(id);
        return IOauth2RegisteredClientPOConvert.INSTANCE.toEntity(oauth2RegisteredClientPO);
    }

    /**
     * 保存
     * @param oauth2RegisteredClient Oauth2RegisteredClient 实体
     * @return Oauth2RegisteredClient 实体
     */
    @Override
    public Oauth2RegisteredClient save(Oauth2RegisteredClient oauth2RegisteredClient) {
        Oauth2RegisteredClientPO oauth2RegisteredClientPO = IOauth2RegisteredClientPOConvert.INSTANCE.fromEntity(oauth2RegisteredClient);
        oauth2RegisteredClientMapper.insert(oauth2RegisteredClientPO);
        return IOauth2RegisteredClientPOConvert.INSTANCE.toEntity(oauth2RegisteredClientPO);
    }

    /**
     * 根据主键更新
     * @param oauth2RegisteredClient Oauth2RegisteredClient 实体
     */
    @Override
    public void update(Oauth2RegisteredClient oauth2RegisteredClient) {
        Oauth2RegisteredClientPO oauth2RegisteredClientPO = IOauth2RegisteredClientPOConvert.INSTANCE.fromEntity(oauth2RegisteredClient);
        oauth2RegisteredClientMapper.updateById(oauth2RegisteredClientPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        oauth2RegisteredClientMapper.deleteById(id);
    }

}
