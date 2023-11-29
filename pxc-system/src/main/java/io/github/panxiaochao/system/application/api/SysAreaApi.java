package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysAreaAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 全国5级行政区划 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "全国5级行政区划", description = "全国5级行政区划Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysarea")
public class SysAreaApi {

	/**
	 * 全国5级行政区划 服务
	 */
	private final SysAreaAppService sysAreaAppService;

}
