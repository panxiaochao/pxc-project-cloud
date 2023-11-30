package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.SysUserQueryRequest;
import io.github.panxiaochao.system.application.api.response.SysUserQueryResponse;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.domain.entity.SysUser;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.SysUserMapper;
import io.github.panxiaochao.system.infrastructure.po.SysUserPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements ISysUserService, ISysUserReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final SysUserMapper sysUserMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<SysUserQueryResponse> page(Pagination pagination, RequestPage<SysUserQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<SysUserPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 默认按照主键倒序排序
		lqw.orderByDesc(SysUserPO::getId);
		// 分页查询
		Page<SysUserPO> page = sysUserMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return ISysUserPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<SysUserPO> lambdaQuery(SysUserQueryRequest queryRequest) {
		LambdaQueryWrapper<SysUserPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 用户真实姓名 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getRealName())) {
				lqw.eq(SysUserPO::getRealName, queryRequest.getRealName());
			}
			// 如果 用户昵称（花名） 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getNickName())) {
				lqw.eq(SysUserPO::getNickName, queryRequest.getNickName());
			}
			// 如果 身份证 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getIdCard())) {
				lqw.eq(SysUserPO::getIdCard, queryRequest.getIdCard());
			}
			// 如果 用户头像 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getAvatar())) {
				lqw.eq(SysUserPO::getAvatar, queryRequest.getAvatar());
			}
			// 如果 性别：1男，0女 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getSex())) {
				lqw.eq(SysUserPO::getSex, queryRequest.getSex());
			}
			// 如果 地址 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getAddress())) {
				lqw.eq(SysUserPO::getAddress, queryRequest.getAddress());
			}
			// 如果 邮箱 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getEmail())) {
				lqw.eq(SysUserPO::getEmail, queryRequest.getEmail());
			}
			// 如果 手机号码 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getMobile())) {
				lqw.eq(SysUserPO::getMobile, queryRequest.getMobile());
			}
			// 如果 电话号码 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getTel())) {
				lqw.eq(SysUserPO::getTel, queryRequest.getTel());
			}
			// 如果 传真号码 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getFax())) {
				lqw.eq(SysUserPO::getFax, queryRequest.getFax());
			}
			// 如果 排序 不为空 Integer
			if (queryRequest.getSort() != null) {
				lqw.eq(SysUserPO::getSort, queryRequest.getSort());
			}
			// 如果 备注 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getRemark())) {
				lqw.eq(SysUserPO::getRemark, queryRequest.getRemark());
			}
			// 如果 人员状态：1正常，0不正常 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getStatus())) {
				lqw.eq(SysUserPO::getStatus, queryRequest.getStatus());
			}
			// 如果 皮肤风格 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getSkins())) {
				lqw.eq(SysUserPO::getSkins, queryRequest.getSkins());
			}
			// 如果 所在区域或者部门ID，多数据请用逗号隔开 不为空 Integer
			if (queryRequest.getOrgId() != null) {
				lqw.eq(SysUserPO::getOrgId, queryRequest.getOrgId());
			}
			// 如果 所在区域或者部门编码code，多数据请用逗号隔开 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getOrgCode())) {
				lqw.eq(SysUserPO::getOrgCode, queryRequest.getOrgCode());
			}
			// 如果 创建时间 不为空 LocalDateTime
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(SysUserPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空 LocalDateTime
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(SysUserPO::getUpdateTime, queryRequest.getUpdateTime());
			}
			// 如果 登陆次数 不为空 Integer
			if (queryRequest.getLoginNums() != null) {
				lqw.eq(SysUserPO::getLoginNums, queryRequest.getLoginNums());
			}
			// 如果 登录失败次数 不为空 Integer
			if (queryRequest.getLoginErrorNums() != null) {
				lqw.eq(SysUserPO::getLoginErrorNums, queryRequest.getLoginErrorNums());
			}
			// 如果 登录时间 不为空 LocalDateTime
			if (queryRequest.getLoginTime() != null) {
				lqw.eq(SysUserPO::getLoginTime, queryRequest.getLoginTime());
			}
			// 如果 帐号超时期限 不为空 LocalDateTime
			if (queryRequest.getExpireTime() != null) {
				lqw.eq(SysUserPO::getExpireTime, queryRequest.getExpireTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return SysUser 实体
	 */
	@Override
	public SysUser getById(String id) {
		SysUserPO sysUserPO = sysUserMapper.selectById(id);
		return ISysUserPOConvert.INSTANCE.toEntity(sysUserPO);
	}

	/**
	 * 保存
	 * @param sysUser SysUser 实体
	 * @return SysUser 实体
	 */
	@Override
	public SysUser save(SysUser sysUser) {
		SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
		sysUserMapper.insert(sysUserPO);
		return ISysUserPOConvert.INSTANCE.toEntity(sysUserPO);
	}

	/**
	 * 根据主键更新
	 * @param sysUser SysUser 实体
	 */
	@Override
	public void update(SysUser sysUser) {
		SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
		sysUserMapper.updateById(sysUserPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		sysUserMapper.deleteById(id);
	}

}
