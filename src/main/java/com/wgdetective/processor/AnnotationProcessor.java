package com.wgdetective.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author Wladimir Litvinov
 */
public interface AnnotationProcessor<A extends Annotation> {
    Class<A> getAnnotation();
    boolean filter(final A annotation);
    void validate(final Object o, final Field field);
}
