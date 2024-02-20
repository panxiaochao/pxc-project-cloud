package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysJob;
import io.github.panxiaochao.system.domain.repository.ISysJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysJobDomainService {

	/**
	 * SysJob Domain接口服务类
	 */
	private final ISysJobService sysJobService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysJob 实体
	 */
	public SysJob getById(String id) {
		return sysJobService.getById(id);
	}

	/**
	 * 保存
	 * @param sysJob SysJob 实体
	 * @return SysJob 实体
	 */
	public SysJob save(SysJob sysJob) {
		return sysJobService.save(sysJob);
	}

	/**
	 * 根据主键更新
	 * @param sysJob SysJob 实体
	 */
	public void update(SysJob sysJob) {
		sysJobService.update(sysJob);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysJobService.deleteById(id);
	}

}
