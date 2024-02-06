package io.github.panxiaochao.system.infrastructure.convert;

import io.github.panxiaochao.system.application.api.response.persistentlogins.PersistentLoginsQueryResponse;
import io.github.panxiaochao.system.domain.entity.PersistentLogins;
import io.github.panxiaochao.system.infrastructure.po.PersistentLoginsPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 持久化对象结构映射.
 * </p>
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface IPersistentLoginsPOConvert {

	/**
	 * 持久化对象结构映射实例
	 */
	IPersistentLoginsPOConvert INSTANCE = Mappers.getMapper(IPersistentLoginsPOConvert.class);

	/**
	 * 实体 转 持久化对象
	 * @param persistentLogins 实体
	 * @return 持久化对象
	 */
	PersistentLoginsPO fromEntity(PersistentLogins persistentLogins);

	/**
	 * 实体 转 持久化对象
	 * @param persistentLoginsList 实体
	 * @return 持久化对象
	 */
	List<PersistentLoginsPO> fromEntity(List<PersistentLogins> persistentLoginsList);

	/**
	 * 持久化对象 转 实体
	 * @param persistentLoginsPO 持久化对象
	 * @return 实体
	 */
	PersistentLogins toEntity(PersistentLoginsPO persistentLoginsPO);

	/**
	 * 持久化对象 转 实体
	 * @param persistentLoginsPOList 持久化对象
	 * @return 实体
	 */
	List<PersistentLogins> toEntity(List<PersistentLoginsPO> persistentLoginsPOList);

	/**
	 * 持久化对象 转 查询响应数据传输对象
	 * @param persistentLoginsPO 持久化对象
	 * @return 查询响应数据传输对象
	 */
	PersistentLoginsQueryResponse toQueryResponse(PersistentLoginsPO persistentLoginsPO);

	/**
	 * 持久化对象列表 转 查询响应数据传输对象列表
	 * @param persistentLoginsPOList 持久化对象列表
	 * @return 查询响应数据传输对象列表
	 */
	List<PersistentLoginsQueryResponse> toQueryResponse(List<PersistentLoginsPO> persistentLoginsPOList);

}
