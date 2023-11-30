package io.github.panxiaochao.system.domain.service;

import io.github.panxiaochao.system.domain.entity.SysPost;
import io.github.panxiaochao.system.domain.repository.ISysPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位表 Domain服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysPostDomainService {

	/**
	 * SysPost Domain接口服务类
	 */
	private final ISysPostService sysPostService;

	/**
	 * 详情
	 * @param id 主键
	 * @return SysPost 实体
	 */
	public SysPost getById(String id) {
		return sysPostService.getById(id);
	}

	/**
	 * 保存
	 * @param sysPost SysPost 实体
	 * @return SysPost 实体
	 */
	public SysPost save(SysPost sysPost) {
		return sysPostService.save(sysPost);
	}

	/**
	 * 根据主键更新
	 * @param sysPost SysPost 实体
	 */
	public void update(SysPost sysPost) {
		sysPostService.update(sysPost);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	public void deleteById(String id) {
		sysPostService.deleteById(id);
	}

}
