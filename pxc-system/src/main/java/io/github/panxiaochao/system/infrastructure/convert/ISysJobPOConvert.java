package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.sysjob.SysJobQueryResponse;
import io.github.panxiaochao.system.domain.entity.SysJob;
import io.github.panxiaochao.system.infrastructure.po.SysJobPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务调度表持久化对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface ISysJobPOConvert {

	/**
	 * 定时任务调度表持久化对象结构映射实例
	 */
	ISysJobPOConvert INSTANCE = Mappers.getMapper(ISysJobPOConvert.class);

	/**
	 * 定时任务调度表实体 转 定时任务调度表持久化对象
	 * @param sysJob 定时任务调度表实体
	 * @return 定时任务调度表持久化对象
	 */
	SysJobPO fromEntity(SysJob sysJob);

	/**
	 * 定时任务调度表实体 转 定时任务调度表持久化对象
	 * @param sysJobList 定时任务调度表实体
	 * @return 定时任务调度表持久化对象
	 */
	List<SysJobPO> fromEntity(List<SysJob> sysJobList);

	/**
	 * 定时任务调度表持久化对象 转 定时任务调度表实体
	 * @param sysJobPO 定时任务调度表持久化对象
	 * @return 定时任务调度表实体
	 */
	SysJob toEntity(SysJobPO sysJobPO);

	/**
	 * 定时任务调度表持久化对象 转 定时任务调度表实体
	 * @param sysJobPOList 定时任务调度表持久化对象
	 * @return 定时任务调度表实体
	 */
	List<SysJob> toEntity(List<SysJobPO> sysJobPOList);

	/**
	 * 定时任务调度表持久化对象 转 定时任务调度表查询响应数据传输对象
	 * @param sysJobPO 定时任务调度表持久化对象
	 * @return 定时任务调度表查询响应数据传输对象
	 */
	SysJobQueryResponse toQueryResponse(SysJobPO sysJobPO);

	/**
	 * 定时任务调度表持久化对象列表 转 定时任务调度表查询响应数据传输对象列表
	 * @param sysJobPOList 定时任务调度表持久化对象列表
	 * @return 定时任务调度表查询响应数据传输对象列表
	 */
	List<SysJobQueryResponse> toQueryResponse(List<SysJobPO> sysJobPOList);
}
