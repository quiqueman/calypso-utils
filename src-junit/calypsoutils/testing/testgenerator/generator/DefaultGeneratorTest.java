/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author quique
 * 
 */
public class DefaultGeneratorTest {

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.generator.DefaultGenerator#getJavaMethodSignature(java.lang.Object, java.lang.String)}
     * .
     */
    @Test
    public void testGetJavaMethodSignature() {
        final DefaultGenerator generator = new DefaultGenerator();
        final String javaCode = generator.getJavaMethodSignature(this,
                "defaultGeneratorTest");
        assertEquals(
                "/* creation method for defaultGeneratorTest */\npublic DefaultGeneratorTest createDefaultGeneratorTest() {\n\tDefaultGeneratorTest defaultGeneratorTest = new DefaultGeneratorTest();\n",
                javaCode);
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.generator.DefaultGenerator#getJavaMethodReturn(java.lang.String)}
     * .
     */
    @Test
    public void testGetJavaMethodReturn() {
        final DefaultGenerator generator = new DefaultGenerator();
        final String javaCode = generator
                .getJavaMethodReturn("defaultGeneratorTest");
        assertEquals("\treturn defaultGeneratorTest;\n}\n\n", javaCode);
    }
}
