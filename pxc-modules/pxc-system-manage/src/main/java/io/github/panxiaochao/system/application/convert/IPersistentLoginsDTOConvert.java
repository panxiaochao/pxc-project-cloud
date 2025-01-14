package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsCreateRequest;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsQueryRequest;
import io.github.panxiaochao.system.application.api.request.persistentlogins.PersistentLoginsUpdateRequest;
import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsQueryResponse;
import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsResponse;
import io.github.panxiaochao.system.domain.entity.PersistentLogins;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2023-12-01
 */
@Mapper
public interface IPersistentLoginsDTOConvert {

	/**
	 * 数据传输对象结构映射实例
	 */
	IPersistentLoginsDTOConvert INSTANCE = Mappers.getMapper(IPersistentLoginsDTOConvert.class);

	/**
	 * 创建请求数据传输对象 转 实体
	 * @param createRequest 创建请求数据传输对象
	 * @return 实体
	 */
	PersistentLogins fromCreateRequest(PersistentLoginsCreateRequest createRequest);

	/**
	 * 更新请求数据传输对象 转 实体
	 * @param updateRequest 更新请求数据传输对象
	 * @return 实体
	 */
	PersistentLogins fromUpdateRequest(PersistentLoginsUpdateRequest updateRequest);

	/**
	 * 查询请求数据传输对象 转 实体
	 * @param queryRequest 查询请求数据传输对象
	 * @return 实体
	 */
	PersistentLogins fromQueryRequest(PersistentLoginsQueryRequest queryRequest);

	/**
	 * 实体 转 响应数据传输对象
	 * @param persistentLogins 实体
	 * @return 响应数据传输对象
	 */
	PersistentLoginsResponse toResponse(PersistentLogins persistentLogins);

	/**
	 * 实体 转 查询响应数据传输对象
	 * @param persistentLogins 实体
	 * @return 查询响应数据传输对象
	 */
	PersistentLoginsQueryResponse toQueryResponse(PersistentLogins persistentLogins);

	/**
	 * 实体列表 转 查询响应数据传输对象列表
	 * @param persistentLoginsList 实体列表
	 * @return 查询响应数据传输对象列表
	 */
	List<PersistentLoginsQueryResponse> toQueryResponse(List<PersistentLogins> persistentLoginsList);

}
