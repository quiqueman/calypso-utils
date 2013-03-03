/**
 * 
 */
package calypsoutils.testing.testgenerator;

import java.util.List;

import calypsoutils.testing.testgenerator.generator.GeneratorInterface;

/**
 * @author quique
 * 
 */
public class TestObjectsGenerator {
    private List<String> methods;

    public void saveJavaCode(final Object object, final String directory,
            final String identifier) {
        if (prepareDirectory(directory)) {
            if (createClassFile(object, identifier)) {
                final String javaCode = getJavaCode(object, identifier);
                save(javaCode, directory, identifier);
            }
        }
    }

    /**
     * @param object
     * @param identifier
     * @return
     */
    String getJavaCode(final Object object, final String identifier) {
        final GeneratorFactory factory = new GeneratorFactory();
        final GeneratorInterface generator = factory.getGenerator(object);
        // return generator.getJavaCode(object);
        return null;
    }

    /**
     * @param javaCode
     * @param directory
     * @param identifier
     */
    private void save(final String javaCode, final String directory,
            final String identifier) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /**
     * @param object
     * @param identifier
     * @return
     */
    private boolean createClassFile(final Object object, final String identifier) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /**
     * @param directory
     * @return
     */
    boolean prepareDirectory(final String directory) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }
}
