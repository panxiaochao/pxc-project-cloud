package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;

import java.util.List;

/**
 * <p> 角色表 读模型服务. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysRoleReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param queryRequest 角色表查询请求对象
     * @return 分页结果数组
     */
    List<SysRoleQueryResponse> page(Pagination pagination, SysRoleQueryRequest queryRequest);

}
