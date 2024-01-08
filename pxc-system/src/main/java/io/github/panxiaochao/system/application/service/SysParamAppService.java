package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.enums.CommonConstants;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.core.utils.StringPools;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysparam.SysParamUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysparam.SysParamResponse;
import io.github.panxiaochao.system.application.convert.ISysParamDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysParamReadModelService;
import io.github.panxiaochao.system.application.runner.helper.CacheHelper;
import io.github.panxiaochao.system.domain.entity.SysParam;
import io.github.panxiaochao.system.domain.service.SysParamDomainService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 系统参数 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysParamAppService {

	/**
	 * LOGGER SysDictRunner.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SysParamAppService.class);

	/**
	 * 系统参数 Domain服务类
	 */
	private final SysParamDomainService sysParamDomainService;

	/**
	 * 系统参数 读模型服务
	 */
	private final ISysParamReadModelService sysParamReadModelService;

	/**
	 * 系统参数 常量名
	 */
	private static final String SYS_PARAM_TYPE = "PARAM_TYPE";

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 系统参数查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysParamQueryResponse> page(RequestPage pageRequest, SysParamQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysParamQueryResponse> list = sysParamReadModelService.page(pagination, queryRequest);
		list.forEach(s -> {
			SysDictItemQueryResponse sysDictItemQueryResponse = CacheHelper.getSysDictItemByValue(SYS_PARAM_TYPE,
					s.getParamType());
			if (Objects.isNull(sysDictItemQueryResponse)) {
				s.setParamTypeStr(StringPools.EMPTY);
			}
			else {
				s.setParamTypeStr(sysDictItemQueryResponse.getDictItemText());
			}
		});
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysParamResponse> getById(String id) {
		SysParam sysParam = sysParamDomainService.getById(id);
		SysParamResponse sysParamResponse = ISysParamDTOConvert.INSTANCE.toResponse(sysParam);
		return R.ok(sysParamResponse);
	}

	/**
	 * 保存
	 * @param sysParamCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysParamResponse> save(SysParamCreateRequest sysParamCreateRequest) {
		SysParam sysParam = ISysParamDTOConvert.INSTANCE.fromCreateRequest(sysParamCreateRequest);
		sysParam = sysParamDomainService.save(sysParam);
		SysParamResponse sysParamResponse = ISysParamDTOConvert.INSTANCE.toResponse(sysParam);
		return R.ok(sysParamResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysParamUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysParamUpdateRequest sysParamUpdateRequest) {
		SysParam sysParam = ISysParamDTOConvert.INSTANCE.fromUpdateRequest(sysParamUpdateRequest);
		sysParamDomainService.update(sysParam);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysParamDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 发布系统参数
	 */
	public void publishedData() {
		long startTime = System.currentTimeMillis();
		SysParamQueryRequest sysParamQueryRequest = new SysParamQueryRequest();
		sysParamQueryRequest.setState(CommonConstants.STATUS_NORMAL.toString());
		List<SysParamQueryResponse> list = sysParamReadModelService.list(sysParamQueryRequest);
		Map<String, SysParamQueryResponse> sysParamMap = new LinkedHashMap<>();
		list.forEach(s -> {
			sysParamMap.put(s.getId(), s);
		});
		CacheHelper.putAllSysParam(sysParamMap);
		LOGGER.info("[pxc-system] sys_param load is success, time consuming {} ms",
				(System.currentTimeMillis() - startTime));
	}

}
