package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.SysDictAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "数据字典表", description = "数据字典表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/sysdict")
public class SysDictApi {

	/**
	 * 数据字典表 服务
	 */
	private final SysDictAppService sysDictAppService;

}
