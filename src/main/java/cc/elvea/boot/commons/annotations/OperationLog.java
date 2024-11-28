package cc.elvea.boot.commons.annotations;

import java.lang.annotation.*;

/**
 * @author elvea
 * @since 24.1.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    String value() default "";

}
