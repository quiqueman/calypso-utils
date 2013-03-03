/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import java.util.List;
import java.util.Set;

/**
 * @author quique
 * 
 */
public interface GeneratorInterface {
    /**
     * @param methodsJavaCode
     * @param imports
     * @param object
     * @param objectName
     */
    public void getJavaCode(List<String> methodsJavaCode, Set<String> imports,
            Object object, String objectName);
}
