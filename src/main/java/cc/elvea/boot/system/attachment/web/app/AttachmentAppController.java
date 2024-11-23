package cc.elvea.boot.system.attachment.web.app;

import cc.elvea.boot.commons.annotations.OperationLog;
import cc.elvea.boot.commons.web.controller.AbstractController;
import cc.elvea.boot.commons.web.response.Response;
import cc.elvea.boot.system.attachment.api.AttachmentApi;
import cc.elvea.boot.system.attachment.model.request.AttachmentRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentTypeRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentUploadRequest;
import cc.elvea.boot.system.attachment.model.vo.AttachmentTypeVo;
import cc.elvea.boot.system.attachment.model.vo.AttachmentVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;

import static cc.elvea.boot.system.commons.constants.SystemMappingConstants.*;

/**
 * @author elvea
 * @since 24.1.0
 */
@RestController
@AllArgsConstructor
@Tag(name = "AttachmentAppController", description = "附件控制器")
public class AttachmentAppController extends AbstractController {

    private final AttachmentApi attachmentApi;

    @OperationLog("获取附件类型")
    @Operation(summary = "获取附件类型")
    @ApiResponse(description = "获取附件类型")
    @PostMapping(API_V1__ATTACHMENT__GET_ATTACHMENT_TYPE)
    public Response<AttachmentTypeVo> getAttachmentType(AttachmentTypeRequest request) {
        return Response.success(attachmentApi.getAttachmentType(request));
    }

    @OperationLog("获取附件")
    @Operation(summary = "获取附件")
    @ApiResponse(description = "获取附件")
    @PostMapping(API_V1__ATTACHMENT__GET_ATTACHMENT)
    public Response<AttachmentVo> getAttachment(AttachmentRequest request) {
        return Response.success(attachmentApi.getAttachment(request));
    }

    @OperationLog("附件上传")
    @Operation(summary = "附件上传")
    @ApiResponse(description = "附件上传")
    @PostMapping(API_V1__ATTACHMENT__UPLOAD_ATTACHMENT)
    public Response<?> uploadAttachment(AttachmentUploadRequest request, MultipartHttpServletRequest servletRequest) throws Exception {
        Iterator<String> it = servletRequest.getFileNames();
        while (it.hasNext()) {
            attachmentApi.uploadAttachmentFile(request, servletRequest.getFile(it.next()));
        }
        return Response.success();
    }

    @OperationLog("编辑器附件上传")
    @Operation(summary = "编辑器附件上传")
    @ApiResponse(description = "编辑器附件上传")
    @PostMapping(API_V1__ATTACHMENT__UPLOAD_EDITOR_ATTACHMENT)
    public Response<?> uploadEditorAttachment(@RequestParam("file") MultipartFile file) throws Exception {
        return Response.success();
    }

}
