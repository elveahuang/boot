package cc.elvea.boot.system.message.web.app;

import cc.elvea.boot.commons.web.controller.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elvea
 * @since 24.1.0
 */
@RestController
@AllArgsConstructor
@Tag(name = "NoticeController", description = "系统通知控制器")
public class NoticeController extends AbstractController {
}
