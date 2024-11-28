package cc.elvea.boot.commons.domain;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
public interface IdEntity extends Serializable {

    /**
     * @return Long
     */
    Long getId();

    /**
     * @param id Long
     */
    void setId(Long id);

}
