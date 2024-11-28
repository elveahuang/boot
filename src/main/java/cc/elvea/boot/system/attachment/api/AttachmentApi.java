package cc.elvea.boot.system.attachment.api;

import cc.elvea.boot.system.attachment.model.request.AttachmentRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentTypeRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentUploadRequest;
import cc.elvea.boot.system.attachment.model.vo.AttachmentTypeVo;
import cc.elvea.boot.system.attachment.model.vo.AttachmentVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface AttachmentApi {

    /**
     * 获取附件类型
     */
    AttachmentTypeVo getAttachmentType(AttachmentTypeRequest request);

    /**
     * 获取附件
     */
    AttachmentVo getAttachment(AttachmentRequest request);

    /**
     * 上传附件文件
     */
    void uploadAttachmentFile(AttachmentUploadRequest request, MultipartFile file) throws Exception;

    /**
     * 上传附件文件
     */
    void uploadAttachmentFile(AttachmentUploadRequest request, File file) throws Exception;

    /**
     * 上传附件文件
     */
    void uploadAttachmentFile(AttachmentUploadRequest request, InputStream is) throws Exception;

}
