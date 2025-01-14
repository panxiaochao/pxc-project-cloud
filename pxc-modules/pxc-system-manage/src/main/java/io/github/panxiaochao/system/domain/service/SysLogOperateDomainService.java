package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysLogOperate;
import io.github.panxiaochao.system.domain.repository.ISysLogOperateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志操作表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysLogOperateDomainService {

	/**
	 * SysLogOperate Domain接口服务类
	 */
	private final ISysLogOperateService sysLogOperateService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysLogOperate 实体
	 */
	public SysLogOperate getById(String id) {
		return sysLogOperateService.getById(id);
	}

	/**
	 * 保存
	 * @param sysLogOperate SysLogOperate 实体
	 * @return SysLogOperate 实体
	 */
	public SysLogOperate save(SysLogOperate sysLogOperate) {
		return sysLogOperateService.save(sysLogOperate);
	}

	/**
	 * 根据主键更新
	 * @param sysLogOperate SysLogOperate 实体
	 */
	public void update(SysLogOperate sysLogOperate) {
		sysLogOperateService.update(sysLogOperate);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysLogOperateService.deleteById(id);
	}

}
