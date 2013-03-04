/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import com.calypso.tk.core.Status;

/**
 * Writer for Calypso Status objects
 * 
 */
public class StatusWriter implements ObjectWriterInterface<Status> {
    @Override
    public String write(final String objName, final String methodName,
            final Status value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(Status.valueOf(\"");
        sb.append(value);
        sb.append("\"));\n");

        return sb.toString();
    }
}
