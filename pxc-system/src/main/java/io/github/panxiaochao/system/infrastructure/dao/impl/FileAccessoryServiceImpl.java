package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.panxiaochao.core.response.page.Pagination;
import io.github.panxiaochao.core.response.page.RequestPage;
import io.github.panxiaochao.system.application.api.request.FileAccessoryQueryRequest;
import io.github.panxiaochao.system.application.api.response.FileAccessoryQueryResponse;
import io.github.panxiaochao.system.application.repository.IFileAccessoryReadModelService;
import io.github.panxiaochao.system.domain.entity.FileAccessory;
import io.github.panxiaochao.system.domain.repository.IFileAccessoryService;
import io.github.panxiaochao.system.infrastructure.convert.IFileAccessoryPOConvert;
import io.github.panxiaochao.system.infrastructure.mapper.FileAccessoryMapper;
import io.github.panxiaochao.system.infrastructure.po.FileAccessoryPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 附件表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Service
@RequiredArgsConstructor
public class FileAccessoryServiceImpl implements IFileAccessoryService, IFileAccessoryReadModelService {

	/**
	 * 角色表 持久化接口
	 */
	private final FileAccessoryMapper fileAccessoryMapper;

	/**
	 * 查询分页
	 * @param pagination 分页属性对象
	 * @param pageRequest 请求分页参数对象
	 * @return 分页结果数组
	 */
	@Override
	public List<FileAccessoryQueryResponse> page(Pagination pagination,
			RequestPage<FileAccessoryQueryRequest> pageRequest) {
		// 构造查询条件
		LambdaQueryWrapper<FileAccessoryPO> lqw = lambdaQuery(pageRequest.getParamsObject());
		// 默认按照主键倒序排序
		lqw.orderByDesc(FileAccessoryPO::getId);
		// 分页查询
		Page<FileAccessoryPO> page = fileAccessoryMapper
			.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
		pagination.setTotal(page.getTotal());
		return IFileAccessoryPOConvert.INSTANCE.toQueryResponse(page.getRecords());
	}

	/**
	 * 查询条件
	 * @param queryRequest 角色表查询请求对象
	 * @return 角色表Lambda表达式
	 */
	private LambdaQueryWrapper<FileAccessoryPO> lambdaQuery(FileAccessoryQueryRequest queryRequest) {
		LambdaQueryWrapper<FileAccessoryPO> lqw = Wrappers.lambdaQuery();
		if (queryRequest != null) {
			// 如果 原文件全名包括类型 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getFileName())) {
				lqw.eq(FileAccessoryPO::getFileName, queryRequest.getFileName());
			}
			// 如果 存储的文件全名包括类型 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getRealName())) {
				lqw.eq(FileAccessoryPO::getRealName, queryRequest.getRealName());
			}
			// 如果 文件大小 不为空 Long
			if (queryRequest.getFileSize() != null) {
				lqw.eq(FileAccessoryPO::getFileSize, queryRequest.getFileSize());
			}
			// 如果 文件类型 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getFileType())) {
				lqw.eq(FileAccessoryPO::getFileType, queryRequest.getFileType());
			}
			// 如果 存储文件路径 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getFilePath())) {
				lqw.eq(FileAccessoryPO::getFilePath, queryRequest.getFilePath());
			}
			// 如果 系统模块 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getModule())) {
				lqw.eq(FileAccessoryPO::getModule, queryRequest.getModule());
			}
			// 如果 系统模块ID 不为空 Long
			if (queryRequest.getLinkId() != null) {
				lqw.eq(FileAccessoryPO::getLinkId, queryRequest.getLinkId());
			}
			// 如果 附件状态1正常，0失效 不为空 String
			if (StringUtils.isNotBlank(queryRequest.getStatus())) {
				lqw.eq(FileAccessoryPO::getStatus, queryRequest.getStatus());
			}
			// 如果 创建人 不为空 Long
			if (queryRequest.getCreateId() != null) {
				lqw.eq(FileAccessoryPO::getCreateId, queryRequest.getCreateId());
			}
			// 如果 创建时间 不为空 LocalDateTime
			if (queryRequest.getCreateTime() != null) {
				lqw.eq(FileAccessoryPO::getCreateTime, queryRequest.getCreateTime());
			}
			// 如果 更新时间 不为空 LocalDateTime
			if (queryRequest.getUpdateTime() != null) {
				lqw.eq(FileAccessoryPO::getUpdateTime, queryRequest.getUpdateTime());
			}
		}
		return lqw;
	}

	/**
	 * 详情
	 * @param id 主键
	 * @return FileAccessory 实体
	 */
	@Override
	public FileAccessory getById(String id) {
		FileAccessoryPO fileAccessoryPO = fileAccessoryMapper.selectById(id);
		return IFileAccessoryPOConvert.INSTANCE.toEntity(fileAccessoryPO);
	}

	/**
	 * 保存
	 * @param fileAccessory FileAccessory 实体
	 * @return FileAccessory 实体
	 */
	@Override
	public FileAccessory save(FileAccessory fileAccessory) {
		FileAccessoryPO fileAccessoryPO = IFileAccessoryPOConvert.INSTANCE.fromEntity(fileAccessory);
		fileAccessoryMapper.insert(fileAccessoryPO);
		return IFileAccessoryPOConvert.INSTANCE.toEntity(fileAccessoryPO);
	}

	/**
	 * 根据主键更新
	 * @param fileAccessory FileAccessory 实体
	 */
	@Override
	public void update(FileAccessory fileAccessory) {
		FileAccessoryPO fileAccessoryPO = IFileAccessoryPOConvert.INSTANCE.fromEntity(fileAccessory);
		fileAccessoryMapper.updateById(fileAccessoryPO);
	}

	/**
	 * 根据主键删除
	 * @param id 主键
	 */
	@Override
	public void deleteById(String id) {
		fileAccessoryMapper.deleteById(id);
	}

}
