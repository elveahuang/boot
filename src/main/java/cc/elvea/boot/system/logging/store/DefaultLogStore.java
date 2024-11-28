package cc.elvea.boot.system.logging.store;

import cc.elvea.boot.system.logging.domain.OperationLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

/**
 * @author elvea
 * @since 24.1.0
 */
@Slf4j
public class DefaultLogStore implements LogStore {

    /**
     * @see LogStore#saveOptLog(OperationLogDto)
     */
    @Async
    @Override
    public void saveOptLog(OperationLogDto dto) {
        try {
            log.info(dto.toString());
        } catch (Exception e) {
            log.error("saveOptLog error.", e);
        }
    }

}
