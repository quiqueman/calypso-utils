/**
 * 
 */
package calypsoutils.testing.testgenerator;

import java.io.File;
import java.util.List;

import calypsoutils.testing.testgenerator.generator.GeneratorInterface;

/**
 * @author quique
 * 
 */
public class TestObjectsGenerator {
    private List<String> methods;

    public void saveJavaCode(final Object object, final String directory,
            final String identifier, final String comment) {
        if (prepareDirectory(directory)) {
            if (createClassFile(object, identifier)) {
                getJavaCode(this.methods, object, identifier);
                save(this.methods, directory, identifier);
            }
        }
    }

    /**
     * @param object
     * @param object
     * @param identifier
     * @return
     */
    void getJavaCode(final List<String> methodsJavaCode, final Object object,
            final String identifier) {
        final GeneratorInterface generator = GeneratorFactory
                .getGenerator(object);
        generator.getJavaCode(methodsJavaCode, object, identifier);
    }

    /**
     * @param javaCode
     * @param directory
     * @param identifier
     */
    private void save(final List<String> javaCode, final String directory,
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
     * Create the directory if it doesn't exist.
     * 
     * @param directoryName
     *            directory path
     * @return true if everything is ok, false in case of error
     */
    boolean prepareDirectory(final String directoryName) {
        final File directory = new File(directoryName);
        if (!directory.exists()) {
            // create directory
            return directory.mkdir();
        }
        return directory.canWrite();
    }
}
