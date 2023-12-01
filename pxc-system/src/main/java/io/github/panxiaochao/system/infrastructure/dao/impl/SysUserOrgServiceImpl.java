package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysUserOrgQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserOrgQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUserOrg;
import io.github.panxiaochao.system.domain.repository.ISysUserOrgService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserOrgPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserOrgMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserOrgPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 用户机构/部门表 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgServiceImpl implements ISysUserOrgService, ISysUserOrgReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysUserOrgMapper sysUserOrgMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 用户机构/部门表查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserOrgQueryResponse> page(Pagination pagination, SysUserOrgQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserOrgPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysUserOrgPO> page = sysUserOrgMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserOrgPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysUserOrgPO> lambdaQuery(SysUserOrgQueryRequest queryRequest) {
        LambdaQueryWrapper<SysUserOrgPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserOrgPO::getId);
            // 如果 用户ID 不为空
            if (queryRequest.getUserId() != null) {
                lqw.eq(SysUserOrgPO::getUserId, queryRequest.getUserId());
            }
            // 如果 机构ID 不为空
            if (queryRequest.getDepartId() != null) {
                lqw.eq(SysUserOrgPO::getDepartId, queryRequest.getDepartId());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysUserOrgPO::getCreateTime, queryRequest.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (queryRequest.getUpdateTime() != null) {
                lqw.eq(SysUserOrgPO::getUpdateTime, queryRequest.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserOrg 实体
     */
    @Override
    public SysUserOrg getById(String id) {
        SysUserOrgPO sysUserOrgPO = sysUserOrgMapper.selectById(id);
        return ISysUserOrgPOConvert.INSTANCE.toEntity(sysUserOrgPO);
    }

    /**
     * 保存
     * @param sysUserOrg SysUserOrg 实体
     * @return SysUserOrg 实体
     */
    @Override
    public SysUserOrg save(SysUserOrg sysUserOrg) {
        SysUserOrgPO sysUserOrgPO = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrg);
        sysUserOrgMapper.insert(sysUserOrgPO);
        return ISysUserOrgPOConvert.INSTANCE.toEntity(sysUserOrgPO);
    }

    /**
     * 根据主键更新
     * @param sysUserOrg SysUserOrg 实体
     */
    @Override
    public void update(SysUserOrg sysUserOrg) {
        SysUserOrgPO sysUserOrgPO = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrg);
        sysUserOrgMapper.updateById(sysUserOrgPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysUserOrgMapper.deleteById(id);
    }

}
