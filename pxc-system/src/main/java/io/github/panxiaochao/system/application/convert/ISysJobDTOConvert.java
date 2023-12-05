package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.sysjob.SysJobCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysjob.SysJobUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysjob.SysJobQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysjob.SysJobResponse;
import io.github.panxiaochao.system.domain.entity.SysJob;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务调度表数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysJobDTOConvert {

	/**
	 * 定时任务调度表数据传输对象结构映射实例
	 */
	ISysJobDTOConvert INSTANCE = Mappers.getMapper(ISysJobDTOConvert.class);

	/**
	 * 定时任务调度表创建请求数据传输对象 转 定时任务调度表实体
	 * @param createRequest 定时任务调度表创建请求数据传输对象
	 * @return 定时任务调度表实体
	 */
	SysJob fromCreateRequest(SysJobCreateRequest createRequest);

	/**
	 * 定时任务调度表更新请求数据传输对象 转 定时任务调度表实体
	 * @param updateRequest 定时任务调度表更新请求数据传输对象
	 * @return 定时任务调度表实体
	 */
	SysJob fromUpdateRequest(SysJobUpdateRequest updateRequest);

	/**
	 * 定时任务调度表查询请求数据传输对象 转 定时任务调度表实体
	 * @param queryRequest 定时任务调度表查询请求数据传输对象
	 * @return 定时任务调度表实体
	 */
	SysJob fromQueryRequest(SysJobQueryRequest queryRequest);

	/**
	 * 定时任务调度表实体 转 定时任务调度表响应数据传输对象
	 * @param sysJob 定时任务调度表实体
	 * @return 定时任务调度表响应数据传输对象
	 */
	SysJobResponse toResponse(SysJob sysJob);

	/**
	 * 定时任务调度表实体 转 定时任务调度表查询响应数据传输对象
	 * @param sysJob 定时任务调度表实体
	 * @return 定时任务调度表查询响应数据传输对象
	 */
	SysJobQueryResponse toQueryResponse(SysJob sysJob);

	/**
	 * 定时任务调度表实体列表 转 定时任务调度表查询响应数据传输对象列表
	 * @param sysJobList 定时任务调度表实体列表
	 * @return 定时任务调度表查询响应数据传输对象列表
	 */
	List<SysJobQueryResponse> toQueryResponse(List<SysJob> sysJobList);
}
