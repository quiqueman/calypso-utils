/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * @author quique
 * 
 */
public class StringWritter implements ObjectWritterInterface {
    @Override
    public String write(final String objName, final String methodName,
            final Object result) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(\"");
        sb.append(result.toString());
        sb.append("\");\n");

        return sb.toString();
    }
}
