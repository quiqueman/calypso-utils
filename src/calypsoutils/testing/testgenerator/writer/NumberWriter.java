/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * @author quique
 * 
 */
public class NumberWriter implements ObjectWriterInterface {
    @Override
    public String write(final String objName, final String methodName,
            final Object result) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(");
        if (result instanceof Double) {
            if (((Double) result).doubleValue() == Double.POSITIVE_INFINITY) {
                sb.append("Double.POSITIVE_INFINITY");
            } else if (((Double) result).doubleValue() == Double.NEGATIVE_INFINITY) {
                sb.append("Double.NEGATIVE_INFINITY");
            } else {
                sb.append(result);
            }
        } else {
            sb.append(result);
        }
        sb.append(");\n");

        return sb.toString();
    }
}
