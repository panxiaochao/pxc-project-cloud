package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysUserOrgAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户机构/部门表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "用户机构/部门表", description = "用户机构/部门表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysuserorg")
public class SysUserOrgApi {

	/**
	 * 用户机构/部门表 服务
	 */
	private final SysUserOrgAppService sysUserOrgAppService;

}
