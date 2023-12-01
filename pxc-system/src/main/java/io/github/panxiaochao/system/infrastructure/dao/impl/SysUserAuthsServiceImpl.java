package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserAuthsQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserAuths;
import io.github.panxiaochao.system.domain.repository.ISysUserAuthsService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserAuthsPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserAuthsMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserAuthsPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 用户授权信息表 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserAuthsServiceImpl implements ISysUserAuthsService, ISysUserAuthsReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysUserAuthsMapper sysUserAuthsMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 用户授权信息表查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserAuthsQueryResponse> page(Pagination pagination, SysUserAuthsQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserAuthsPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysUserAuthsPO> page = sysUserAuthsMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserAuthsPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysUserAuthsPO> lambdaQuery(SysUserAuthsQueryRequest queryRequest) {
        LambdaQueryWrapper<SysUserAuthsPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserAuthsPO::getId);
            // 如果 关联用户ID 不为空
            if (queryRequest.getUserId() != null) {
                lqw.eq(SysUserAuthsPO::getUserId, queryRequest.getUserId());
            }
            // 如果 登录类型(手机号/邮箱/用户名/微信/微博/QQ）等 不为空
            if (StringUtils.isNotBlank(queryRequest.getIdentityType())) {
                lqw.eq(SysUserAuthsPO::getIdentityType, queryRequest.getIdentityType());
            }
            // 如果 登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号 不为空
            if (StringUtils.isNotBlank(queryRequest.getIdentifier())) {
                lqw.eq(SysUserAuthsPO::getIdentifier, queryRequest.getIdentifier());
            }
            // 如果 密码凭证（自建密码，或者第三方access_token） 不为空
            if (StringUtils.isNotBlank(queryRequest.getCredential())) {
                lqw.eq(SysUserAuthsPO::getCredential, queryRequest.getCredential());
            }
            // 如果 是否已经验证：1验证，0未验证 不为空
            if (StringUtils.isNotBlank(queryRequest.getVerified())) {
                lqw.eq(SysUserAuthsPO::getVerified, queryRequest.getVerified());
            }
            // 如果 登录标识失效时间 不为空
            if (queryRequest.getExpireTime() != null) {
                lqw.eq(SysUserAuthsPO::getExpireTime, queryRequest.getExpireTime());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysUserAuthsPO::getCreateTime, queryRequest.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (queryRequest.getUpdateTime() != null) {
                lqw.eq(SysUserAuthsPO::getUpdateTime, queryRequest.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserAuths 实体
     */
    @Override
    public SysUserAuths getById(String id) {
        SysUserAuthsPO sysUserAuthsPO = sysUserAuthsMapper.selectById(id);
        return ISysUserAuthsPOConvert.INSTANCE.toEntity(sysUserAuthsPO);
    }

    /**
     * 保存
     * @param sysUserAuths SysUserAuths 实体
     * @return SysUserAuths 实体
     */
    @Override
    public SysUserAuths save(SysUserAuths sysUserAuths) {
        SysUserAuthsPO sysUserAuthsPO = ISysUserAuthsPOConvert.INSTANCE.fromEntity(sysUserAuths);
        sysUserAuthsMapper.insert(sysUserAuthsPO);
        return ISysUserAuthsPOConvert.INSTANCE.toEntity(sysUserAuthsPO);
    }

    /**
     * 根据主键更新
     * @param sysUserAuths SysUserAuths 实体
     */
    @Override
    public void update(SysUserAuths sysUserAuths) {
        SysUserAuthsPO sysUserAuthsPO = ISysUserAuthsPOConvert.INSTANCE.fromEntity(sysUserAuths);
        sysUserAuthsMapper.updateById(sysUserAuthsPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysUserAuthsMapper.deleteById(id);
    }

}
