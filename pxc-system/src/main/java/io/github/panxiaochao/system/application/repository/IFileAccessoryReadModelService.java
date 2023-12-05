package io.github.panxiaochao.system.application.repository;

import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.request.fileaccessory.FileAccessoryQueryRequest;
import io.github.panxiaochao.system.application.api.response.fileaccessory.FileAccessoryQueryResponse;

import java.util.List;

/**
 * <p>
 * 附件表 读模型服务.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
public interface IFileAccessoryReadModelService {

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param queryRequest 附件表查询请求对象
	 * @return 分页结果数组
	 */
	List<FileAccessoryQueryResponse> page(Pagination pagination, FileAccessoryQueryRequest queryRequest);

}
