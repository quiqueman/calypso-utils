/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * Writer for Strings
 * 
 */
public class BooleanWriter implements ObjectWriterInterface<Boolean> {
    @Override
    public String write(final String objName, final String methodName,
            final Boolean value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(");
        sb.append(value.toString());
        sb.append(");\n");

        return sb.toString();
    }
}
