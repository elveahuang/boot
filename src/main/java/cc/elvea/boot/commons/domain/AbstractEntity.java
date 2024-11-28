package cc.elvea.boot.commons.domain;

import cc.elvea.boot.commons.data.HibernateSequence;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * @author elvea
 * @since 24.1.0
 */
@MappedSuperclass
public abstract class AbstractEntity implements IdEntity {

    @Id
    @HibernateSequence
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
