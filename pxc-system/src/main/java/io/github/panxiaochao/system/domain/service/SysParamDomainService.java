package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysParam;
import io.github.panxiaochao.system.domain.repository.ISysParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统参数 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysParamDomainService {

	/**
	 * SysParam Domain接口服务类
	 */
	private final ISysParamService sysParamService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysParam 实体
	 */
	public SysParam getById(String id) {
		return sysParamService.getById(id);
	}

	/**
	 * 保存
	 * @param sysParam SysParam 实体
	 * @return SysParam 实体
	 */
	public SysParam save(SysParam sysParam) {
		return sysParamService.save(sysParam);
	}

	/**
	 * 根据主键更新
	 * @param sysParam SysParam 实体
	 */
	public void update(SysParam sysParam) {
		sysParamService.update(sysParam);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysParamService.deleteById(id);
	}

}
