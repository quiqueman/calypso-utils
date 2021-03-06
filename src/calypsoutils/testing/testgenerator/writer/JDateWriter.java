/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import com.calypso.tk.core.JDate;

/**
 * @author quique
 * 
 */
public class JDateWriter implements ObjectWriterInterface<JDate> {
    @Override
    public String write(final String objName, final String methodName,
            final JDate value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(JDate.valueOf(");
        sb.append(value.getJulian());
        sb.append("));\n");

        return sb.toString();
    }
}
