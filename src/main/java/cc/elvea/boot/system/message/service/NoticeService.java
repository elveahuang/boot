package cc.elvea.boot.system.message.service;

import cc.elvea.boot.commons.service.EntityService;
import cc.elvea.boot.system.message.model.entity.NoticeEntity;
import cc.elvea.boot.system.message.model.request.NoticeSearchRequest;
import cc.elvea.boot.system.message.repository.NoticeRepository;
import org.springframework.data.domain.Page;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface NoticeService extends EntityService<NoticeEntity, Long, NoticeRepository> {

    /**
     * 获取当前登录用户的系统通知列表
     */
    Page<NoticeEntity> findMyNoticeByUserId(NoticeSearchRequest request);

    /**
     * 获取指定用户所有的消息通知
     */
    Page<NoticeEntity> findByUserId(NoticeSearchRequest request);

}
