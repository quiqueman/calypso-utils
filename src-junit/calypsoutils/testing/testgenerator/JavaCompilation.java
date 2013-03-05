package calypsoutils.testing.testgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class JavaCompilation {
    public boolean compile(final String file) {
        final String classpath = System.getProperty("java.class.path");
        final Properties p = System.getProperties();
        Process process;
        try {
            process = Runtime.getRuntime().exec(
                    "javac -cp " + classpath + ' ' + file);
            final String classfilename = file.substring(0, file.length() - 5)
                    + ".class";
            final File classfile = new File(classfilename);

            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            return classfile.exists();
        } catch (final IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
