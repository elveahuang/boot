package cc.elvea.boot.commons.data;

import cc.elvea.boot.commons.sequence.SequenceManager;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @author elvea
 * @since 24.1.0
 */
public class HibernateSequenceGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return SequenceManager.getSequence().nextId();
    }

}
