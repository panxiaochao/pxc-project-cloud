package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysOrgAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 机构部门表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "机构部门表", description = "机构部门表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysorg")
public class SysOrgApi {

	/**
	 * 机构部门表 服务
	 */
	private final SysOrgAppService sysOrgAppService;

}
