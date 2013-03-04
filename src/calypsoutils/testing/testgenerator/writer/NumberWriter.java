/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * Write a number
 * 
 */
public class NumberWriter implements ObjectWriterInterface<Number> {
    @Override
    public String write(final String objName, final String methodName,
            final Number value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(");
        if (value instanceof Double) {
            if (((Double) value).doubleValue() == Double.POSITIVE_INFINITY) {
                sb.append("Double.POSITIVE_INFINITY");
            } else if (((Double) value).doubleValue() == Double.NEGATIVE_INFINITY) {
                sb.append("Double.NEGATIVE_INFINITY");
            } else {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }
        sb.append(");\n");

        return sb.toString();
    }
}
