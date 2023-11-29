package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysRoleQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysRoleQueryResponse;

import java.util.List;

/**
 * <p>
 * 角色表 读模型服务
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
public interface ISysRoleReadModelService {

	List<SysRoleQueryResponse> page(Pagination pagination, RequestPage<SysRoleQueryRequest> pageRequest);

}
