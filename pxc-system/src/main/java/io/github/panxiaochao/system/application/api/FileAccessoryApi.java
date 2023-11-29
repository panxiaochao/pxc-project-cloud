package io.github.panxiaochao.system.application.api;

import io.github.panxiaochao.system.application.service.FileAccessoryAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 附件表 前端控制器.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-29
 */
@Tag(name = "附件表", description = "附件表Api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/fileaccessory")
public class FileAccessoryApi {

	/**
	 * 附件表 服务
	 */
	private final FileAccessoryAppService fileAccessoryAppService;

}
