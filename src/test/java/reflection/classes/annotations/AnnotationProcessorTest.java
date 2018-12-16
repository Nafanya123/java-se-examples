package reflection.classes.annotations;

import org.junit.Assert;
import org.junit.Test;
import reflection.classes.SomeClass;

public class AnnotationProcessorTest {

    @Test
    public void injectDependencies() {

        SomeClass someClass = new SomeClass();
        Assert.assertNull(someClass.getSomeClassToInjection());

        AnnotationProcessor annotationProcessor = new AnnotationProcessor(
                "reflection/classes");
        annotationProcessor.injectDependencies(someClass);

        Assert.assertNotNull(someClass.getSomeClassToInjection());
    }
}