package ${application}.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import ${application}.api.request.${entity?lower_case}.${entity}QueryRequest;
import ${application}.api.response.${entity?lower_case}.${entity}QueryResponse;

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
     * @param queryRequest ${table.comment!}查询请求对象
     * @return 分页结果数组
     */
    List<${entity}QueryResponse> page(Pagination pagination, ${entity}QueryRequest queryRequest);

    /**
     * 查询数组
     * @param queryRequest ${table.comment!}查询请求对象
     * @return 结果数组
     */
    List<${entity}QueryResponse> selectList(${entity}QueryRequest queryRequest);

    /**
     * 查询单条记录
     * @param queryRequest ${table.comment!}查询请求对象
     * @return ${table.comment!}查询响应对象
     */
    ${entity}QueryResponse getOne(${entity}QueryRequest queryRequest);

}
