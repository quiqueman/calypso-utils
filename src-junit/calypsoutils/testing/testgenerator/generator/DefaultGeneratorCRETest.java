/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import calypsoutils.testing.testgenerator.generator.data.CreSample;

import com.calypso.tk.bo.BOCre;

/**
 * @author quique
 * 
 */
public class DefaultGeneratorCRETest {
    private final DefaultGenerator generator;
    List<String> methodsJavaCode;

    public DefaultGeneratorCRETest() {
        this.generator = new DefaultGenerator();
        this.methodsJavaCode = new LinkedList<String>();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.generator.DefaultGenerator#getJavaCode(java.util.List, java.lang.Object, java.lang.String)}
     * .
     */
    @Test
    public void testGetJavaCode() {
        final BOCre cre = new CreSample().createCre();

        this.generator.getJavaCode(this.methodsJavaCode, cre, "cre");

        assertTrue(this.methodsJavaCode.size() > 1);
        for (final String method : this.methodsJavaCode) {
            System.out.println(method);
        }
    }

}
