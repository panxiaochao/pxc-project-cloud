package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsQueryRequest;
import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsQueryResponse;
import io.github.panxiaochao.system.application.repository.IPersistentLoginsReadModelService;
import io.github.panxiaochao.system.domain.entity.PersistentLogins;
import io.github.panxiaochao.system.domain.repository.IPersistentLoginsService;
import io.github.panxiaochao.system.infrastructure.convert.IPersistentLoginsPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.PersistentLoginsMapper;
import io.github.panxiaochao.system.infrastructure.po.PersistentLoginsPO;
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
public class PersistentLoginsServiceImpl implements IPersistentLoginsService, IPersistentLoginsReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final PersistentLoginsMapper persistentLoginsMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param queryRequest 查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<PersistentLoginsQueryResponse> page(Pagination pagination, PersistentLoginsQueryRequest queryRequest) {
        // 构造查询条件
        LambdaQueryWrapper<PersistentLoginsPO> lqw = lambdaQuery(queryRequest);
        // 分页查询
        Page<PersistentLoginsPO> page = persistentLoginsMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return IPersistentLoginsPOConvert.INSTANCE.toQueryResponse(page.getRecords());
    }

    /**
     * 查询条件
     * @param queryRequest 角色表查询请求对象
     * @return 角色表Lambda表达式
     */
    private LambdaQueryWrapper<PersistentLoginsPO> lambdaQuery(PersistentLoginsQueryRequest queryRequest) {
        LambdaQueryWrapper<PersistentLoginsPO> lqw = Wrappers.lambdaQuery();
        if (queryRequest != null) {
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getUsername())) {
                lqw.eq(PersistentLoginsPO::getUsername, queryRequest.getUsername());
            }
            // 默认按照主键倒序排序
            lqw.orderByDesc(PersistentLoginsPO::getSeries);
            // 如果  不为空
            if (StringUtils.isNotBlank(queryRequest.getToken())) {
                lqw.eq(PersistentLoginsPO::getToken, queryRequest.getToken());
            }
            // 如果  不为空
            if (queryRequest.getLastUsed() != null) {
                lqw.eq(PersistentLoginsPO::getLastUsed, queryRequest.getLastUsed());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return PersistentLogins 实体
     */
    @Override
    public PersistentLogins getById(String id) {
        PersistentLoginsPO persistentLoginsPO = persistentLoginsMapper.selectById(id);
        return IPersistentLoginsPOConvert.INSTANCE.toEntity(persistentLoginsPO);
    }

    /**
     * 保存
     * @param persistentLogins PersistentLogins 实体
     * @return PersistentLogins 实体
     */
    @Override
    public PersistentLogins save(PersistentLogins persistentLogins) {
        PersistentLoginsPO persistentLoginsPO = IPersistentLoginsPOConvert.INSTANCE.fromEntity(persistentLogins);
        persistentLoginsMapper.insert(persistentLoginsPO);
        return IPersistentLoginsPOConvert.INSTANCE.toEntity(persistentLoginsPO);
    }

    /**
     * 根据主键更新
     * @param persistentLogins PersistentLogins 实体
     */
    @Override
    public void update(PersistentLogins persistentLogins) {
        PersistentLoginsPO persistentLoginsPO = IPersistentLoginsPOConvert.INSTANCE.fromEntity(persistentLogins);
        persistentLoginsMapper.updateById(persistentLoginsPO);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        persistentLoginsMapper.deleteById(id);
    }

}
