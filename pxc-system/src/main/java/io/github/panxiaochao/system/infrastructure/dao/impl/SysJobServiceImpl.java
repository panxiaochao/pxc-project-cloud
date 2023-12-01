package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysJobQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysJobReadModelService;
import io.github.panxiaochao.system.domain.entity.SysJob;
import io.github.panxiaochao.system.domain.repository.ISysJobService;
import io.github.panxiaochao.system.infrastructure.convert.ISysJobPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysJobMapper;
import io.github.panxiaochao.system.infrastructure.po.SysJobPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 定时任务调度表 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysJobServiceImpl implements ISysJobService, ISysJobReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysJobMapper sysJobMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 定时任务调度表查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysJobQueryResponse> page(Pagination pagination, SysJobQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysJobPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysJobPO> page = sysJobMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysJobPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysJobPO> lambdaQuery(SysJobQueryRequest queryRequest) {
        LambdaQueryWrapper<SysJobPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysJobPO::getId);
            // 如果 任务编码 不为空
            if (StringUtils.isNotBlank(queryRequest.getJobCode())) {
                lqw.eq(SysJobPO::getJobCode, queryRequest.getJobCode());
            }
            // 如果 任务名称 不为空
            if (StringUtils.isNotBlank(queryRequest.getJobName())) {
                lqw.eq(SysJobPO::getJobName, queryRequest.getJobName());
            }
            // 如果 任务组 不为空
            if (StringUtils.isNotBlank(queryRequest.getJobGroup())) {
                lqw.eq(SysJobPO::getJobGroup, queryRequest.getJobGroup());
            }
            // 如果 调用目标：可以是Bean 不为空
            if (StringUtils.isNotBlank(queryRequest.getInvokeBean())) {
                lqw.eq(SysJobPO::getInvokeBean, queryRequest.getInvokeBean());
            }
            // 如果 调用目标方法 不为空
            if (StringUtils.isNotBlank(queryRequest.getInvokeMethod())) {
                lqw.eq(SysJobPO::getInvokeMethod, queryRequest.getInvokeMethod());
            }
            // 如果 目标方法参数 不为空
            if (StringUtils.isNotBlank(queryRequest.getMethodParams())) {
                lqw.eq(SysJobPO::getMethodParams, queryRequest.getMethodParams());
            }
            // 如果 参数类型：string,int,boolean,long,float 不为空
            if (StringUtils.isNotBlank(queryRequest.getParamsType())) {
                lqw.eq(SysJobPO::getParamsType, queryRequest.getParamsType());
            }
            // 如果 cron执行表达式 不为空
            if (StringUtils.isNotBlank(queryRequest.getCronExpression())) {
                lqw.eq(SysJobPO::getCronExpression, queryRequest.getCronExpression());
            }
            // 如果 任务状态：1=正常 0=停用 不为空
            if (StringUtils.isNotBlank(queryRequest.getJobState())) {
                lqw.eq(SysJobPO::getJobState, queryRequest.getJobState());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(queryRequest.getRemark())) {
                lqw.eq(SysJobPO::getRemark, queryRequest.getRemark());
            }
            // 如果 创建人 不为空
            if (queryRequest.getCreateId() != null) {
                lqw.eq(SysJobPO::getCreateId, queryRequest.getCreateId());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysJobPO::getCreateTime, queryRequest.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (queryRequest.getUpdateTime() != null) {
                lqw.eq(SysJobPO::getUpdateTime, queryRequest.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysJob 实体
     */
    @Override
    public SysJob getById(String id) {
        SysJobPO sysJobPO = sysJobMapper.selectById(id);
        return ISysJobPOConvert.INSTANCE.toEntity(sysJobPO);
    }

    /**
     * 保存
     * @param sysJob SysJob 实体
     * @return SysJob 实体
     */
    @Override
    public SysJob save(SysJob sysJob) {
        SysJobPO sysJobPO = ISysJobPOConvert.INSTANCE.fromEntity(sysJob);
        sysJobMapper.insert(sysJobPO);
        return ISysJobPOConvert.INSTANCE.toEntity(sysJobPO);
    }

    /**
     * 根据主键更新
     * @param sysJob SysJob 实体
     */
    @Override
    public void update(SysJob sysJob) {
        SysJobPO sysJobPO = ISysJobPOConvert.INSTANCE.fromEntity(sysJob);
        sysJobMapper.updateById(sysJobPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysJobMapper.deleteById(id);
    }

}
