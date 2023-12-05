package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.syslogoperate.SysLogOperateQueryRequest;
import io.github.panxiaochao.system.application.api.response.syslogoperate.SysLogOperateQueryResponse;

import java.util.List;

/**
 * <p> 系统日志操作表 读模型服务. </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface ISysLogOperateReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param queryRequest 系统日志操作表查询请求对象
     * @return 分页结果数组
     */
    List<SysLogOperateQueryResponse> page(Pagination pagination, SysLogOperateQueryRequest queryRequest);

}
