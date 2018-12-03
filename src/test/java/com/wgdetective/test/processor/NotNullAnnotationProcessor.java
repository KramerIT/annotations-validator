package com.wgdetective.test.processor;

import com.wgdetective.exception.ValidationException;
import com.wgdetective.processor.AnnotationProcessor;
import com.wgdetective.test.model.NotNull;

import java.lang.reflect.Field;

/**
 * @author Wladimir Litvinov
 */
public class NotNullAnnotationProcessor implements AnnotationProcessor<NotNull> {
    @Override
    public Class<NotNull> getAnnotation() {
        return NotNull.class;
    }

    @Override
    public boolean filter(final NotNull annotation) {
        return !annotation.comment().equals("ignore");
    }

    @Override
    public void validate(final Object o, final Field field) {
        if(o == null) {
            throw new ValidationException("Field must not be null!");
        }
    }
}
