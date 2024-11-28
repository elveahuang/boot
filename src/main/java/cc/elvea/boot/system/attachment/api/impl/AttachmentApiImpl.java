package cc.elvea.boot.system.attachment.api.impl;

import cc.elvea.boot.commons.constants.DateTimeConstants;
import cc.elvea.boot.commons.exception.ServiceException;
import cc.elvea.boot.commons.sequence.SequenceManager;
import cc.elvea.boot.commons.service.AbstractService;
import cc.elvea.boot.commons.utils.DateTimeUtils;
import cc.elvea.boot.commons.utils.SecurityUtils;
import cc.elvea.boot.commons.utils.StorageUtils;
import cc.elvea.boot.system.attachment.api.AttachmentApi;
import cc.elvea.boot.system.attachment.model.converter.AttachmentTypeConverter;
import cc.elvea.boot.system.attachment.model.entity.AttachmentFileEntity;
import cc.elvea.boot.system.attachment.model.entity.AttachmentTypeEntity;
import cc.elvea.boot.system.attachment.model.request.AttachmentRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentTypeRequest;
import cc.elvea.boot.system.attachment.model.request.AttachmentUploadRequest;
import cc.elvea.boot.system.attachment.model.vo.AttachmentTypeVo;
import cc.elvea.boot.system.attachment.model.vo.AttachmentVo;
import cc.elvea.boot.system.attachment.service.AttachmentFileService;
import cc.elvea.boot.system.attachment.service.AttachmentTypeService;
import cc.elvea.boot.system.storage.StorageManager;
import cc.elvea.boot.system.storage.domain.FileObject;
import cc.elvea.boot.system.storage.domain.FileParameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;

import static cc.elvea.boot.commons.utils.FileUtils.getContentType;
import static cc.elvea.boot.system.commons.constants.SystemAttachmentConstants.DEFAULT_ATTACHMENT_PATH;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class AttachmentApiImpl extends AbstractService implements AttachmentApi {

    private final StorageManager storage;

    private final AttachmentTypeService attachmentTypeService;

    private final AttachmentTypeConverter attachmentTypeConverter;

    private final AttachmentFileService attachmentFileService;

    /**
     * @see AttachmentApi#getAttachmentType(AttachmentTypeRequest)
     */
    @Override
    public AttachmentTypeVo getAttachmentType(AttachmentTypeRequest request) {
        AttachmentTypeEntity entity = this.attachmentTypeService.findByCode(request.getAttachmentType());
        return this.attachmentTypeConverter.entity2Vo(entity);
    }

    /**
     * @see AttachmentApi#getAttachment(AttachmentRequest)
     */
    @Override
    public AttachmentVo getAttachment(AttachmentRequest request) {
        return null;
    }

    /**
     * @see AttachmentApi#uploadAttachmentFile(AttachmentUploadRequest, MultipartFile)
     */
    @Override
    public void uploadAttachmentFile(AttachmentUploadRequest request, MultipartFile file) throws Exception {
        try (InputStream is = file.getInputStream()) {
            request.setOriginalFilename(file.getOriginalFilename());
            request.setContentType(file.getContentType());
            request.setFileSize(file.getSize());
            this.uploadAttachmentFile(request, is);
        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    /**
     * @see AttachmentApi#uploadAttachmentFile(AttachmentUploadRequest, File)
     */
    @Override
    public void uploadAttachmentFile(AttachmentUploadRequest request, File file) throws Exception {
        try (InputStream is = FileUtils.openInputStream(file)) {
            request.setOriginalFilename(FilenameUtils.getName(file.getName()));
            request.setContentType(getContentType(file));
            request.setFileSize(file.length());
            this.uploadAttachmentFile(request, is);
        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    /**
     * @see AttachmentApi#uploadAttachmentFile(AttachmentUploadRequest, InputStream)
     */
    @Override
    public void uploadAttachmentFile(AttachmentUploadRequest request, InputStream is) throws Exception {
        // 生成附件文件ID
        Long attachmentFileId = SequenceManager.getSequence().nextId();

        // 获取附件类型信息
        AttachmentTypeEntity attachmentTypeEntity = this.attachmentTypeService.findByCode(request.getAttachmentType());

        // 处理文件存储路径和文件名
        String curDate = DateTimeUtils.format(LocalDateTime.now(), DateTimeConstants.Pattern.SIMPLE_DATE);
        String destinationPath = "/%s/%s/%s/".formatted(DEFAULT_ATTACHMENT_PATH, curDate, String.valueOf(attachmentFileId));
        String destinationFilename = StorageUtils.generateFilename(request.getOriginalFilename());
        String key = StorageUtils.generateKey(destinationFilename, destinationPath);
        // 上传文件到存储引擎
        FileParameter parameter = FileParameter.withPublic().key(key).contentType(request.getContentType()).build();
        FileObject<?> fileObject = this.storage.getStorageService().uploadFile(is, parameter);

        // 添加附件记录
        AttachmentFileEntity attachmentFile = new AttachmentFileEntity();
        attachmentFile.setId(attachmentFileId);
        attachmentFile.setAttachmentType(request.getAttachmentType());
        attachmentFile.setSize(request.getFileSize());
        attachmentFile.setOriginalFilename(request.getOriginalFilename());
        attachmentFile.setFilename(destinationFilename);
        attachmentFile.setContentType(request.getContentType());
        attachmentFile.setFileKey(fileObject.getKey());
        attachmentFile.setCreatedAt(getLocalDateTime());
        attachmentFile.setCreatedBy(SecurityUtils.getUid());
        // 存储引擎类型
        if (request.getStorageType() != null) {
            attachmentFile.setStorageType(request.getStorageType().toString());
        } else {
            attachmentFile.setStorageType(this.storage.config().getType().toString());
        }

        // 保存文件记录
        this.attachmentFileService.save(attachmentFile);
    }

    private void processAttachmentFile(AttachmentUploadRequest request, InputStream is) throws Exception {

    }

}
