/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * Writer for Strings
 * 
 */
public class StringWriter implements ObjectWriterInterface<String> {
    @Override
    public String write(final String objName, final String methodName,
            final String result) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(\"");
        sb.append(result.toString());
        sb.append("\");\n");

        return sb.toString();
    }
}
