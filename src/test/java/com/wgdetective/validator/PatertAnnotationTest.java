package com.wgdetective.validator;

import com.wgdetective.exception.ValidationException;
import com.wgdetective.factory.AnnotationValidatorFactory;
import com.wgdetective.test.filter.MyPackageFilter;
import com.wgdetective.test.model.RootModel;
import com.wgdetective.test.processor.PatternAnnotationProcessor;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Wladimir Litvinov
 */
public class PatertAnnotationTest {
    private AnnotationValidator<RootModel> annotationValidator;

    @Before
    public void init() {
        final AnnotationValidatorFactory factory = new AnnotationValidatorFactory();
        annotationValidator = factory.create(RootModel.class, new PatternAnnotationProcessor(), new MyPackageFilter());
    }

    @Test(expected = ValidationException.class)
    public void simpleTest_1() throws Exception {
//        @Pattern(regexp = "\\d{1,3}", error = "not valid id!")
        final RootModel root = new RootModel();
        root.setId(1000000L);
        root.setName("root");
        annotationValidator.validate(root);
    }

    @Test
    public void simpleTest_2() throws Exception {
//        @Pattern(regexp = "\\d{1,3}", error = "not valid id!")
        final RootModel root = new RootModel();
        root.setId(123L);
        root.setName("root");
        annotationValidator.validate(root);
    }

}