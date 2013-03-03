/**
 * 
 */
package calypsoutils.testing.testgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import calypsoutils.testing.testgenerator.generator.GeneratorInterface;

import com.calypso.tk.core.Log;

/**
 * @author quique
 * 
 */
public class TestObjectsGenerator {
    private List<String> methods;

    public void saveJavaCode(final Object object, final String directoryPath,
            final String identifier, final String comment) {
        this.methods = new LinkedList<String>();
        final File directory = prepareDirectory(directoryPath);
        if (directory != null) {
            getJavaCode(this.methods, object, identifier);
            save(this.methods, directory, identifier);
        }
    }

    /**
     * @param object
     * @param object
     * @param identifier
     * @return
     */
    void getJavaCode(final List<String> javaCode, final Object object,
            final String identifier) {
        javaCode.add(getClassImports());
        javaCode.add(getClassHeader(identifier));
        final GeneratorInterface generator = GeneratorFactory
                .getGenerator(object);
        generator.getJavaCode(javaCode, object, identifier);
        javaCode.add(getClassFooter());
    }

    /**
     * @return
     */
    private String getClassImports() {
        final StringBuilder sb = new StringBuilder("// TODO:\n");
        sb.append("// not yet Implemented\n\n");
        return sb.toString();

    }

    /**
     * @return
     */
    private String getClassHeader(final String identifier) {
        final StringBuilder sb = new StringBuilder("public class ");
        sb.append(capitalizeFirstChar(identifier));
        sb.append("Builder {\n");
        return sb.toString();
    }

    /**
     * @return
     */
    private String getClassFooter() {
        return ("}\n");
    }

    /**
     * @param javaCode
     * @param directory
     * @param identifier
     */
    private void save(final List<String> javaCode, final File directory,
            final String identifier) {
        final String sourceFileName = capitalizeFirstChar(identifier)
                + "Builder.java";
        final File file = new File(directory, sourceFileName);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));

            for (final String method : javaCode) {
                out.write(method);
            }
        } catch (final IOException exception) {
            Log.error(this, exception);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (final IOException exception) {
                    Log.error(this, exception);
                }
            }
        }
    }

    /**
     * Create the directory if it doesn't exist.
     * 
     * @param directoryName
     *            directory path
     * @return File containing the directory, null in case of error
     */
    File prepareDirectory(final String directoryName) {
        boolean result;
        final File directory = new File(directoryName);
        if (!directory.exists()) {
            // create directory
            result = directory.mkdir();
        }
        result = directory.canWrite();
        if (result) {
            return directory;
        } else {
            return null;
        }
    }

    public static String capitalizeFirstChar(final String string) {
        final char[] chars = string.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return String.valueOf(chars);
    }
}
