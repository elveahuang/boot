package cc.elvea.boot.system.logging.store;

import cc.elvea.boot.system.logging.domain.OperationLogDto;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface LogStore {

    void saveOptLog(OperationLogDto dto) throws Exception;

}
