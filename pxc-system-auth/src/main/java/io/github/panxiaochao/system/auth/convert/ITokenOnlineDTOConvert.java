package io.github.panxiaochao.system.auth.convert;

import io.github.panxiaochao.system.auth.api.response.TokenOnlineQueryResponse;
import io.github.panxiaochao.system.satoken.model.LoginUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 在线会话数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ITokenOnlineDTOConvert {

	/**
	 * 在线会话数据传输对象结构映射实例
	 */
	ITokenOnlineDTOConvert INSTANCE = Mappers.getMapper(ITokenOnlineDTOConvert.class);

	/**
	 * 在线会话实体 转 在线会话查询响应数据传输对象
	 * @param loginUser 在线会话实体
	 * @return 在线会话查询响应数据传输对象
	 */
	TokenOnlineQueryResponse toQueryResponse(LoginUser loginUser);

	/**
	 * 在线会话实体列表 转 在线会话查询响应数据传输对象列表
	 * @param loginUserList 在线会话实体列表
	 * @return 在线会话查询响应数据传输对象列表
	 */
	List<TokenOnlineQueryResponse> toQueryResponse(List<LoginUser> loginUserList);

}
