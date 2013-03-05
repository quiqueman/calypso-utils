/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import java.util.Vector;

/**
 * Writer which can write a Vector<String>
 * 
 */
public class StringVectorWriter implements
        ObjectWriterInterface<Vector<String>> {
    @Override
    public String write(final String objName, final String methodName,
            final Vector<String> vector) {
        final StringBuilder sb = new StringBuilder(
                "\n\tVector<String> vector = new Vector<String>();\n");

        for (final String entry : vector) {
            sb.append("\tvector.add(\"");
            sb.append(entry);
            sb.append("\");\n");
        }
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(Vector);\n\n");
        sb.append("(vector);\n\n");

        return sb.toString();
    }
}
