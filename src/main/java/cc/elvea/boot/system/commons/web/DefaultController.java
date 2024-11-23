package cc.elvea.boot.system.commons.web;

import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.commons.api.CoreApi;
import cc.elvea.boot.system.commons.model.vo.InitializeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static cc.elvea.boot.system.commons.constants.SystemMappingConstants.API_V1_INITIALIZE;

/**
 * @author elvea
 * @since 24.1.0
 */
@RestController
@AllArgsConstructor
public class DefaultController {

    private final CoreApi coreApi;

    @Operation(summary = "获取应用初始数据")
    @ApiResponse(description = "获取应用初始数据")
    @GetMapping(API_V1_INITIALIZE)
    public Response<InitializeVo> initialize() {
        return Response.success(coreApi.initialize());
    }

}
