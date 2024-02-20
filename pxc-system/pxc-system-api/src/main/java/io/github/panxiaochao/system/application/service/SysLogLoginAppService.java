package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysloglogin.SysLogLoginUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysloglogin.SysLogLoginQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysloglogin.SysLogLoginResponse;
import io.github.panxiaochao.system.application.convert.ISysLogLoginDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysLogLoginReadModelService;
import io.github.panxiaochao.system.domain.entity.SysLogLogin;
import io.github.panxiaochao.system.domain.service.SysLogLoginDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统日志登录/登出表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginAppService {

	/**
	 * 系统日志登录/登出表 Domain服务类
	 */
	private final SysLogLoginDomainService sysLogLoginDomainService;

	/**
	 * 系统日志登录/登出表 读模型服务
	 */
	private final ISysLogLoginReadModelService sysLogLoginReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 系统日志登录/登出表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysLogLoginQueryResponse> page(RequestPage pageRequest, SysLogLoginQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysLogLoginQueryResponse> list = sysLogLoginReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysLogLoginResponse> getById(String id) {
		SysLogLogin sysLogLogin = sysLogLoginDomainService.getById(id);
		SysLogLoginResponse sysLogLoginResponse = ISysLogLoginDTOConvert.INSTANCE.toResponse(sysLogLogin);
		return R.ok(sysLogLoginResponse);
	}

	/**
	 * 保存
	 * @param sysLogLoginCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysLogLoginResponse> save(SysLogLoginCreateRequest sysLogLoginCreateRequest) {
		SysLogLogin sysLogLogin = ISysLogLoginDTOConvert.INSTANCE.fromCreateRequest(sysLogLoginCreateRequest);
		sysLogLogin = sysLogLoginDomainService.save(sysLogLogin);
		SysLogLoginResponse sysLogLoginResponse = ISysLogLoginDTOConvert.INSTANCE.toResponse(sysLogLogin);
		return R.ok(sysLogLoginResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysLogLoginUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysLogLoginUpdateRequest sysLogLoginUpdateRequest) {
		SysLogLogin sysLogLogin = ISysLogLoginDTOConvert.INSTANCE.fromUpdateRequest(sysLogLoginUpdateRequest);
		sysLogLoginDomainService.update(sysLogLogin);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysLogLoginDomainService.deleteById(id);
		return R.ok();
	}

}
