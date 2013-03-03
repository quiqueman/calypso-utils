/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import calypsoutils.testing.testgenerator.TestObjectsGenerator;

/**
 * @author quique
 * 
 */
public class MethodWriter implements ObjectWriterInterface {
    @Override
    public String write(final String objName, final String methodName,
            final Object value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(");
        final String newMethodName = getNewMethodName(value.toString());
        sb.append(newMethodName);
        sb.append("());\n");

        return sb.toString();
    }

    /**
     * @param value
     * @return
     */
    private String getNewMethodName(final String value) {
        return "create"
                + TestObjectsGenerator.capitalizeFirstChar(value.substring(3));
    }
}
