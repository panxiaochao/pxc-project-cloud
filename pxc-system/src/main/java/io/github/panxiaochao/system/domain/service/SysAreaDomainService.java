package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysArea;
import io.github.panxiaochao.system.domain.repository.ISysAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 全国5级行政区划 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysAreaDomainService {

	/**
	 * SysArea Domain接口服务类
	 */
	private final ISysAreaService sysAreaService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysArea 实体
	 */
	public SysArea getById(String id) {
		return sysAreaService.getById(id);
	}

	/**
	 * 保存
	 * @param sysArea SysArea 实体
	 * @return SysArea 实体
	 */
	public SysArea save(SysArea sysArea) {
		return sysAreaService.save(sysArea);
	}

	/**
	 * 根据主键更新
	 * @param sysArea SysArea 实体
	 */
	public void update(SysArea sysArea) {
		sysAreaService.update(sysArea);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysAreaService.deleteById(id);
	}

}
