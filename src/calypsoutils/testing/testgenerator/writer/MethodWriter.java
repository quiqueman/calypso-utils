/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import calypsoutils.testing.testgenerator.CreateTestObject;

/**
 * A writer which can write the call to another method
 * 
 */
public class MethodWriter implements ObjectWriterInterface<String> {
    @Override
    public String write(final String objName, final String methodName,
            final String value) {
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
                + CreateTestObject.capitalizeFirstChar(value.substring(3));
    }
}
