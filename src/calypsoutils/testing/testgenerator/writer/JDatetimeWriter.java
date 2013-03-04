/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import java.util.Calendar;

import com.calypso.tk.core.JDatetime;

/**
 * Writer for Calypso JDatetime objects
 * 
 */
public class JDatetimeWriter implements ObjectWriterInterface<JDatetime> {
    @Override
    public String write(final String objName, final String methodName,
            final JDatetime value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(new JDatetime(");
        sb.append(value.valueIn(Calendar.MILLISECOND));
        sb.append("L));\n");

        return sb.toString();
    }
}
