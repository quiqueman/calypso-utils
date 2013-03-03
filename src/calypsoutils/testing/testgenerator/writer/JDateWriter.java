/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import com.calypso.tk.core.JDate;

/**
 * @author quique
 * 
 */
public class JDateWriter implements ObjectWriterInterface {
    @Override
    public String write(final String objName, final String methodName,
            final Object value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(JDate.valueOf(");
        sb.append(((JDate) value).getJulian());
        sb.append("));\n");

        return sb.toString();
    }
}
