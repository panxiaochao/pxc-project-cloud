package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysLogLoginQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysLogLoginQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysLogLoginReadModelService;
import io.github.panxiaochao.system.domain.entity.SysLogLogin;
import io.github.panxiaochao.system.domain.repository.ISysLogLoginService;
import io.github.panxiaochao.system.infrastructure.convert.ISysLogLoginPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysLogLoginMapper;
import io.github.panxiaochao.system.infrastructure.po.SysLogLoginPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 系统日志登录/登出表 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginServiceImpl implements ISysLogLoginService, ISysLogLoginReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysLogLoginMapper sysLogLoginMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 系统日志登录/登出表查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysLogLoginQueryResponse> page(Pagination pagination, SysLogLoginQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysLogLoginPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysLogLoginPO> page = sysLogLoginMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysLogLoginPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysLogLoginPO> lambdaQuery(SysLogLoginQueryRequest queryRequest) {
        LambdaQueryWrapper<SysLogLoginPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysLogLoginPO::getId);
            // 如果 日志内容 不为空
            if (StringUtils.isNotBlank(queryRequest.getLoginName())) {
                lqw.eq(SysLogLoginPO::getLoginName, queryRequest.getLoginName());
            }
            // 如果 登录类型: 1-登录 2-登出 不为空
            if (queryRequest.getLoginType() != null) {
                lqw.eq(SysLogLoginPO::getLoginType, queryRequest.getLoginType());
            }
            // 如果 IP 不为空
            if (StringUtils.isNotBlank(queryRequest.getIp())) {
                lqw.eq(SysLogLoginPO::getIp, queryRequest.getIp());
            }
            // 如果 地点 不为空
            if (StringUtils.isNotBlank(queryRequest.getAddress())) {
                lqw.eq(SysLogLoginPO::getAddress, queryRequest.getAddress());
            }
            // 如果 浏览器 不为空
            if (StringUtils.isNotBlank(queryRequest.getBrowser())) {
                lqw.eq(SysLogLoginPO::getBrowser, queryRequest.getBrowser());
            }
            // 如果 操作系统 不为空
            if (StringUtils.isNotBlank(queryRequest.getOs())) {
                lqw.eq(SysLogLoginPO::getOs, queryRequest.getOs());
            }
            // 如果 状态: 1-成功 0-失败 不为空
            if (StringUtils.isNotBlank(queryRequest.getState())) {
                lqw.eq(SysLogLoginPO::getState, queryRequest.getState());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysLogLoginPO::getCreateTime, queryRequest.getCreateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysLogLogin 实体
     */
    @Override
    public SysLogLogin getById(String id) {
        SysLogLoginPO sysLogLoginPO = sysLogLoginMapper.selectById(id);
        return ISysLogLoginPOConvert.INSTANCE.toEntity(sysLogLoginPO);
    }

    /**
     * 保存
     * @param sysLogLogin SysLogLogin 实体
     * @return SysLogLogin 实体
     */
    @Override
    public SysLogLogin save(SysLogLogin sysLogLogin) {
        SysLogLoginPO sysLogLoginPO = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLogin);
        sysLogLoginMapper.insert(sysLogLoginPO);
        return ISysLogLoginPOConvert.INSTANCE.toEntity(sysLogLoginPO);
    }

    /**
     * 根据主键更新
     * @param sysLogLogin SysLogLogin 实体
     */
    @Override
    public void update(SysLogLogin sysLogLogin) {
        SysLogLoginPO sysLogLoginPO = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLogin);
        sysLogLoginMapper.updateById(sysLogLoginPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysLogLoginMapper.deleteById(id);
    }

}
