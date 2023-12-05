package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.sysarea.SysAreaCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysarea.SysAreaQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysarea.SysAreaUpdateRequest;
import io.github.panxiaochao.system.application.api.response.sysarea.SysAreaQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysarea.SysAreaResponse;
import io.github.panxiaochao.system.application.convert.ISysAreaDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.system.domain.entity.SysArea;
import io.github.panxiaochao.system.domain.service.SysAreaDomainService;
import io.github.panxiaochao.system.infrastructure.utils.EasyTreeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 全国5级行政区划 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysAreaAppService {

	/**
	 * 全国5级行政区划 Domain服务类
	 */
	private final SysAreaDomainService sysAreaDomainService;

	/**
	 * 全国5级行政区划 读模型服务
	 */
	private final ISysAreaReadModelService sysAreaReadModelService;

	/**
	 * 查询分页
	 * @param pageRequest 请求分页参数对象
	 * @param queryRequest 全国5级行政区划查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysAreaQueryResponse> page(RequestPage pageRequest, SysAreaQueryRequest queryRequest) {
		Pagination pagination = new Pagination(pageRequest.getPageNo(), pageRequest.getPageSize());
		List<SysAreaQueryResponse> list = sysAreaReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysAreaResponse> getById(String id) {
		SysArea sysArea = sysAreaDomainService.getById(id);
		SysAreaResponse sysAreaResponse = ISysAreaDTOConvert.INSTANCE.toResponse(sysArea);
		return R.ok(sysAreaResponse);
	}

	/**
	 * 保存
	 * @param sysAreaCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysAreaResponse> save(SysAreaCreateRequest sysAreaCreateRequest) {
		SysArea sysArea = ISysAreaDTOConvert.INSTANCE.fromCreateRequest(sysAreaCreateRequest);
		sysArea = sysAreaDomainService.save(sysArea);
		SysAreaResponse sysAreaResponse = ISysAreaDTOConvert.INSTANCE.toResponse(sysArea);
		return R.ok(sysAreaResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysAreaUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysAreaUpdateRequest sysAreaUpdateRequest) {
		SysArea sysArea = ISysAreaDTOConvert.INSTANCE.fromUpdateRequest(sysAreaUpdateRequest);
		sysAreaDomainService.update(sysArea);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		sysAreaDomainService.deleteById(id);
		return R.ok();
	}

	/**
	 * 前2级的区域数据
	 * @param areaCode 区域code
	 * @return 区域数组
	 */
	public List<Map<String, Object>> listTree(String areaCode) {
		SysAreaQueryRequest queryRequest = new SysAreaQueryRequest();
		// 当区域code不为空的时候，说明是查询下级数据
		if (StringUtils.hasText(areaCode)) {
			// 设置父节点为当前区域code
			queryRequest.setParentCode(areaCode);
		}
		else {
			queryRequest.setAreaLevel(2);
		}
		List<SysArea> list = sysAreaDomainService.listTree(queryRequest);
		List<Map<String, Object>> mapList = new EasyTreeUtil<SysArea>().list(list)
			.entityFieldId("areaCode")
			.entityFieldParentId("parentCode")
			.extendKeys("{areaName: areaName, areaCode: areaCode, areaLevel: areaLevel, cityCode: cityCode,"
					+ "areaNameEn: areaNameEn, areaNameEnAbbr: areaNameEnAbbr, longitude: longitude, latitude: latitude, sort: sort}")
			.isNullChildrenAsEmpty(true)
			.build();
		return mapList;
	}

}