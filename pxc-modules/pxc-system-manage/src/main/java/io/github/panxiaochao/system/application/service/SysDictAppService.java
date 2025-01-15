package io.github.panxiaochao.system.application.service;

import io.github.panxiaochao.core.constants.CommonConstant;
import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.response.page.PageResponse;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.redis.utils.RedissonUtil;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictCreateRequest;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictQueryRequest;
import io.github.panxiaochao.system.application.api.request.sysdict.SysDictUpdateRequest;
import io.github.panxiaochao.system.application.api.request.sysdictitem.SysDictItemQueryRequest;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictQueryResponse;
import io.github.panxiaochao.system.application.api.response.sysdict.SysDictResponse;
import io.github.panxiaochao.system.application.api.response.sysdictitem.SysDictItemQueryResponse;
import io.github.panxiaochao.system.application.convert.ISysDictDTOConvert;
import io.github.panxiaochao.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.system.application.repository.ISysDictReadModelService;
import io.github.panxiaochao.system.common.constants.RedisConstant;
import io.github.panxiaochao.system.domain.entity.SysDict;
import io.github.panxiaochao.system.domain.service.SysDictDomainService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBatch;
import org.redisson.api.RMapAsync;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 数据字典表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Service
@RequiredArgsConstructor
public class SysDictAppService {

	/**
	 * LOGGER SysDictRunner.class
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SysDictAppService.class);

	/**
	 * 数据字典表 Domain服务类
	 */
	private final SysDictDomainService sysDictDomainService;

	/**
	 * 数据字典表 读模型服务
	 */
	private final ISysDictReadModelService sysDictReadModelService;

	/**
	 * 数据字典配置表 读模型服务
	 */
	private final ISysDictItemReadModelService sysDictItemReadModelService;

	/**
	 * 查询分页
	 * @param requestPage 请求分页参数对象
	 * @param queryRequest 数据字典表查询请求对象
	 * @return 分页数组响应实体
	 */
	public PageResponse<SysDictQueryResponse> page(RequestPage requestPage, SysDictQueryRequest queryRequest) {
		Pagination pagination = new Pagination(requestPage.getPageNo(), requestPage.getPageSize());
		List<SysDictQueryResponse> list = sysDictReadModelService.page(pagination, queryRequest);
		return new PageResponse<>(pagination, list);
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return 响应对象
	 */
	public R<SysDictResponse> getById(String id) {
		SysDict sysDict = sysDictDomainService.getById(id);
		SysDictResponse sysDictResponse = ISysDictDTOConvert.INSTANCE.toResponse(sysDict);
		return R.ok(sysDictResponse);
	}

	/**
	 * 保存
	 * @param sysDictCreateRequest 创建请求对象
	 * @return 返回保存对象
	 */
	public R<SysDictResponse> save(SysDictCreateRequest sysDictCreateRequest) {
		SysDict sysDict = ISysDictDTOConvert.INSTANCE.fromCreateRequest(sysDictCreateRequest);
		SysDictQueryRequest queryRequest = new SysDictQueryRequest();
		queryRequest.setDictCode(sysDict.getDictCode());
		queryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		SysDictQueryResponse one = sysDictReadModelService.getOne(queryRequest);
		if (Objects.nonNull(one)) {
			return R.fail("数据字典[" + sysDict.getDictCode() + "]已存在");
		}
		sysDict = sysDictDomainService.save(sysDict);
		SysDictResponse sysDictResponse = ISysDictDTOConvert.INSTANCE.toResponse(sysDict);
		return R.ok(sysDictResponse);
	}

	/**
	 * 根据主键更新
	 * @param sysDictUpdateRequest 更新请求对象
	 * @return 空返回
	 */
	public R<Void> update(SysDictUpdateRequest sysDictUpdateRequest) {
		SysDict sysDict = ISysDictDTOConvert.INSTANCE.fromUpdateRequest(sysDictUpdateRequest);
		sysDictDomainService.update(sysDict);
		return R.ok();
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 * @return 空返回
	 */
	public R<Void> deleteById(String id) {
		SysDictItemQueryRequest queryRequest = new SysDictItemQueryRequest();
		queryRequest.setDictId(id);
		List<SysDictItemQueryResponse> list = sysDictItemReadModelService.list(queryRequest);
		if (CollectionUtils.isEmpty(list)) {
			sysDictDomainService.deleteById(id);
		}
		else {
			return R.fail("存在关联数据，请删除完全！");
		}
		return R.ok();
	}

	/**
	 * 发布数据字典
	 */
	public void publishedData() {
		RedissonClient redissonClient = RedissonUtil.ofRedissonClient();
		RBatch batch = redissonClient.createBatch();
		long startTime = System.currentTimeMillis();
		// 1.数据字典主表
		SysDictQueryRequest sysDictQueryRequest = new SysDictQueryRequest();
		sysDictQueryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysDictQueryResponse> sysDictQueryResponseList = sysDictReadModelService.list(sysDictQueryRequest);
		// 2.数据字典配置表
		SysDictItemQueryRequest sysDictItemQueryRequest = new SysDictItemQueryRequest();
		sysDictItemQueryRequest.setState(CommonConstant.STATUS_NORMAL.toString());
		List<SysDictItemQueryResponse> sysDictItemQueryResponseList = sysDictItemReadModelService
			.list(sysDictItemQueryRequest);
		RedissonUtil.deleteKeyByPattern(RedisConstant.KEY_ALL_SYS_DICT);
		sysDictQueryResponseList.forEach(s -> {
			RMapAsync<String, Object> sysDictMap = batch.getMap(RedisConstant.KEY_SYS_DICT + s.getDictCode());
			sysDictMap.putAsync("id", s.getId());
			sysDictMap.putAsync("dictName", s.getDictName());
			sysDictMap.putAsync("dictCode", s.getDictCode());
			sysDictMap.putAsync("dictType", s.getDictType());
			sysDictMap.putAsync("sort", s.getSort());
			List<Map<String, Object>> sysDictItemList = sysDictItemQueryResponseList.stream()
				.filter(sd -> sd.getDictId().equals(s.getId()))
				.map(sd -> {
					Map<String, Object> map = new HashMap<>();
					map.put("id", sd.getId());
					map.put("dictId", sd.getDictId());
					map.put("dictItemText", sd.getDictItemText());
					map.put("dictItemValue", sd.getDictItemValue());
					map.put("sort", sd.getSort());
					return map;
				})
				.collect(Collectors.toList());
			sysDictMap.putAsync("sysDictItemList", sysDictItemList);
		});
		batch.execute();
		LOGGER.info("[pxc-system] dict load is success, time consuming {} ms",
				(System.currentTimeMillis() - startTime));
	}

}
