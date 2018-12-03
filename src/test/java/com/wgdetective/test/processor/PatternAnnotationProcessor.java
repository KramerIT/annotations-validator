package com.wgdetective.test.processor;

import com.wgdetective.exception.ValidationException;
import com.wgdetective.processor.AnnotationProcessor;
import com.wgdetective.test.model.Pattern;

import java.lang.reflect.Field;
import java.util.regex.Matcher;

/**
 * @author Wladimir Litvinov
 */
public class PatternAnnotationProcessor implements AnnotationProcessor<Pattern> {
    @Override
    public Class<Pattern> getAnnotation() {
        return Pattern.class;
    }

    @Override
    public boolean filter(final Pattern annotation) {
        return true;
    }

    @Override
    public void validate(final Object o, final Field field) {
        final String regexp = field.getAnnotation(Pattern.class).regexp();
        java.util.regex.Pattern regexPattern = java.util.regex.Pattern.compile(regexp);
        final Matcher matcher = regexPattern.matcher(String.valueOf(o));
        if (!matcher.matches()) {
            throw new ValidationException(field.getAnnotation(Pattern.class).error());
        }
    }
}
