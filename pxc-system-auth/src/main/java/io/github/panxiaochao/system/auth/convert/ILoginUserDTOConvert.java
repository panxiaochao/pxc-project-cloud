package io.github.panxiaochao.system.auth.convert;

import io.github.panxiaochao.system.auth.api.response.LoginUserResponse;
import io.github.panxiaochao.system.satoken.model.LoginUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 当前登录用户数据传输对象结构映射
 *
 * @author Lypxc
 * @since 2024-02-05
 */
@Mapper
public interface ILoginUserDTOConvert {

	/**
	 * 当前登录用户数据传输对象结构映射实例
	 */
	ILoginUserDTOConvert INSTANCE = Mappers.getMapper(ILoginUserDTOConvert.class);

	/**
	 * 当前登录用户实体 转 当前登录用户查询响应数据传输对象
	 * @param loginUser 当前登录用户实体
	 * @return 当前登录用户查询响应数据传输对象
	 */
	LoginUserResponse toQueryResponse(LoginUser loginUser);

	/**
	 * 当前登录用户实体列表 转 当前登录用户查询响应数据传输对象列表
	 * @param loginUserList 当前登录用户实体列表
	 * @return 当前登录用户查询响应数据传输对象列表
	 */
	List<LoginUserResponse> toQueryResponse(List<LoginUser> loginUserList);

}
