package ${application}.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${application}.api.request.${entity}QueryRequest;
import ${application}.api.response.${entity}QueryResponse;

import java.util.List;

/**
 * <p> ${table.comment!} 读模型服务. </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface I${entity}ReadModelService {

    /**
     * 查询分页
     * @param pagination  分页属性对象
     * @param pageRequest 请求分页参数对象
     * @return 分页结果数组
     */
    List<${entity}QueryResponse> page(Pagination pagination, RequestPage<${entity}QueryRequest> pageRequest);

}
