package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysDict;
import io.github.panxiaochao.system.domain.repository.ISysDictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictDomainService {

	/**
	 * SysDict Domain接口服务类
	 */
	private final ISysDictService sysDictService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysDict 实体
	 */
	public SysDict getById(String id) {
		return sysDictService.getById(id);
	}

	/**
	 * 保存
	 * @param sysDict SysDict 实体
	 * @return SysDict 实体
	 */
	public SysDict save(SysDict sysDict) {
		return sysDictService.save(sysDict);
	}

	/**
	 * 根据主键更新
	 * @param sysDict SysDict 实体
	 */
	public void update(SysDict sysDict) {
		sysDictService.update(sysDict);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysDictService.deleteById(id);
	}

}
