package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.sysarea.SysAreaQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysarea.SysAreaQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.system.domain.entity.SysArea;
import io.github.panxiaochao.system.domain.repository.ISysAreaService;
import io.github.panxiaochao.system.infrastructure.convert.ISysAreaPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysAreaMapper;
import io.github.panxiaochao.system.infrastructure.po.SysAreaPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 全国5级行政区划 Dao服务实现类. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysAreaServiceImpl implements ISysAreaService, ISysAreaReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final SysAreaMapper sysAreaMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 全国5级行政区划查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysAreaQueryResponse> page(Pagination pagination, SysAreaQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<SysAreaPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<SysAreaPO> page = sysAreaMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysAreaPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<SysAreaPO> lambdaQuery(SysAreaQueryRequest queryRequest) {
        LambdaQueryWrapper<SysAreaPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysAreaPO::getId);
            // 如果 父ID 不为空
            if (queryRequest.getParentId() != null) {
                lqw.eq(SysAreaPO::getParentId, queryRequest.getParentId());
            }
            // 如果 区划名称 不为空
            if (StringUtils.isNotBlank(queryRequest.getAreaName())) {
                lqw.eq(SysAreaPO::getAreaName, queryRequest.getAreaName());
            }
            // 如果 区域简称 不为空
            if (StringUtils.isNotBlank(queryRequest.getAreaNameAbbr())) {
                lqw.eq(SysAreaPO::getAreaNameAbbr, queryRequest.getAreaNameAbbr());
            }
            // 如果 地区代码 不为空
            if (StringUtils.isNotBlank(queryRequest.getAreaCode())) {
                lqw.eq(SysAreaPO::getAreaCode, queryRequest.getAreaCode());
            }
            // 如果 行政编码 不为空
            if (StringUtils.isNotBlank(queryRequest.getCityCode())) {
                lqw.eq(SysAreaPO::getCityCode, queryRequest.getCityCode());
            }
            // 如果 上级地区代码，组合路径 不为空
            if (StringUtils.isNotBlank(queryRequest.getParentPath())) {
                lqw.eq(SysAreaPO::getParentPath, queryRequest.getParentPath());
            }
            // 如果 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区 不为空
            if (queryRequest.getAreaLevel() != null) {
                lqw.eq(SysAreaPO::getAreaLevel, queryRequest.getAreaLevel());
            }
            // 如果 排序 不为空
            if (queryRequest.getSort() != null) {
                lqw.eq(SysAreaPO::getSort, queryRequest.getSort());
            }
            // 如果 英文名称 不为空
            if (StringUtils.isNotBlank(queryRequest.getAreaNameEn())) {
                lqw.eq(SysAreaPO::getAreaNameEn, queryRequest.getAreaNameEn());
            }
            // 如果 英文简称 不为空
            if (StringUtils.isNotBlank(queryRequest.getAreaNameEnAbbr())) {
                lqw.eq(SysAreaPO::getAreaNameEnAbbr, queryRequest.getAreaNameEnAbbr());
            }
            // 如果 经度 不为空
            if (StringUtils.isNotBlank(queryRequest.getLongitude())) {
                lqw.eq(SysAreaPO::getLongitude, queryRequest.getLongitude());
            }
            // 如果 纬度 不为空
            if (StringUtils.isNotBlank(queryRequest.getLatitude())) {
                lqw.eq(SysAreaPO::getLatitude, queryRequest.getLatitude());
            }
            // 如果 创建时间 不为空
            if (queryRequest.getCreateTime() != null) {
                lqw.eq(SysAreaPO::getCreateTime, queryRequest.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (queryRequest.getUpdateTime() != null) {
                lqw.eq(SysAreaPO::getUpdateTime, queryRequest.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysArea 实体
     */
    @Override
    public SysArea getById(String id) {
        SysAreaPO sysAreaPO = sysAreaMapper.selectById(id);
        return ISysAreaPOConvert.INSTANCE.toEntity(sysAreaPO);
    }

    /**
     * 保存
     * @param sysArea SysArea 实体
     * @return SysArea 实体
     */
    @Override
    public SysArea save(SysArea sysArea) {
        SysAreaPO sysAreaPO = ISysAreaPOConvert.INSTANCE.fromEntity(sysArea);
        sysAreaMapper.insert(sysAreaPO);
        return ISysAreaPOConvert.INSTANCE.toEntity(sysAreaPO);
    }

    /**
     * 根据主键更新
     * @param sysArea SysArea 实体
     */
    @Override
    public void update(SysArea sysArea) {
        SysAreaPO sysAreaPO = ISysAreaPOConvert.INSTANCE.fromEntity(sysArea);
        sysAreaMapper.updateById(sysAreaPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysAreaMapper.deleteById(id);
    }

}
