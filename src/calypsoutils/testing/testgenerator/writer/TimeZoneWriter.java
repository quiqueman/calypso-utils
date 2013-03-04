/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import java.util.TimeZone;

/**
 * Writer for java TimeZone objects
 * 
 */
public class TimeZoneWriter implements ObjectWriterInterface<TimeZone> {
    @Override
    public String write(final String objName, final String methodName,
            final TimeZone value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(TimeZone.getTimeZone(\"");
        sb.append(value.getID());
        sb.append("\"));\n");

        return sb.toString();
    }
}
