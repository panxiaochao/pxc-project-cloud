package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysUserAuthsQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserAuthsQueryResponse;

import java.util.List;

/**
 * <p> 用户授权信息表 读模型服务. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysUserAuthsReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param queryRequest 用户授权信息表查询请求对象
     * @return 分页结果数组
     */
    List<SysUserAuthsQueryResponse> page(Pagination pagination, SysUserAuthsQueryRequest queryRequest);

}
