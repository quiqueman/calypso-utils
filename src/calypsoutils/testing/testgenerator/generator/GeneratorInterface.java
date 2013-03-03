/**
 * 
 */
package calypsoutils.testing.testgenerator.generator;

import java.util.List;

/**
 * @author quique
 * 
 */
public interface GeneratorInterface {
    public String getJavaCode(List<String> methods, Object object,
            String objectName);
}
