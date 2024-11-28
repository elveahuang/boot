package cc.elvea.boot.commons.data;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author elvea
 * @since 24.1.0
 */
@IdGeneratorType(HibernateSequenceGenerator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface HibernateSequence {
}
