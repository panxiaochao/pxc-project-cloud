package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.Oauth2AuthorizationConsentQueryRequest;
import io.github.panxiaochao.system.application.api.response.Oauth2AuthorizationConsentQueryResponse;
import io.github.panxiaochao.system.application.repository.IOauth2AuthorizationConsentReadModelService;
import io.github.panxiaochao.system.domain.entity.Oauth2AuthorizationConsent;
import io.github.panxiaochao.system.domain.repository.IOauth2AuthorizationConsentService;
import io.github.panxiaochao.system.infrastructure.convert.IOauth2AuthorizationConsentPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.Oauth2AuthorizationConsentMapper;
import io.github.panxiaochao.system.infrastructure.po.Oauth2AuthorizationConsentPO;
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
public class Oauth2AuthorizationConsentServiceImpl implements IOauth2AuthorizationConsentService, IOauth2AuthorizationConsentReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final Oauth2AuthorizationConsentMapper oauth2AuthorizationConsentMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<Oauth2AuthorizationConsentQueryResponse> page(Pagination pagination, Oauth2AuthorizationConsentQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<Oauth2AuthorizationConsentPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<Oauth2AuthorizationConsentPO> page = oauth2AuthorizationConsentMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return IOauth2AuthorizationConsentPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<Oauth2AuthorizationConsentPO> lambdaQuery(Oauth2AuthorizationConsentQueryRequest queryRequest) {
        LambdaQueryWrapper<Oauth2AuthorizationConsentPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(Oauth2AuthorizationConsentPO::getRegisteredClientId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(Oauth2AuthorizationConsentPO::getPrincipalName);
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getAuthorities())) {
                lqw.eq(Oauth2AuthorizationConsentPO::getAuthorities, queryRequest.getAuthorities());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return Oauth2AuthorizationConsent 实体
     */
    @Override
    public Oauth2AuthorizationConsent getById(String id) {
        Oauth2AuthorizationConsentPO oauth2AuthorizationConsentPO = oauth2AuthorizationConsentMapper.selectById(id);
        return IOauth2AuthorizationConsentPOConvert.INSTANCE.toEntity(oauth2AuthorizationConsentPO);
    }

    /**
     * 保存
     * @param oauth2AuthorizationConsent Oauth2AuthorizationConsent 实体
     * @return Oauth2AuthorizationConsent 实体
     */
    @Override
    public Oauth2AuthorizationConsent save(Oauth2AuthorizationConsent oauth2AuthorizationConsent) {
        Oauth2AuthorizationConsentPO oauth2AuthorizationConsentPO = IOauth2AuthorizationConsentPOConvert.INSTANCE.fromEntity(oauth2AuthorizationConsent);
        oauth2AuthorizationConsentMapper.insert(oauth2AuthorizationConsentPO);
        return IOauth2AuthorizationConsentPOConvert.INSTANCE.toEntity(oauth2AuthorizationConsentPO);
    }

    /**
     * 根据主键更新
     * @param oauth2AuthorizationConsent Oauth2AuthorizationConsent 实体
     */
    @Override
    public void update(Oauth2AuthorizationConsent oauth2AuthorizationConsent) {
        Oauth2AuthorizationConsentPO oauth2AuthorizationConsentPO = IOauth2AuthorizationConsentPOConvert.INSTANCE.fromEntity(oauth2AuthorizationConsent);
        oauth2AuthorizationConsentMapper.updateById(oauth2AuthorizationConsentPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        oauth2AuthorizationConsentMapper.deleteById(id);
    }

}
