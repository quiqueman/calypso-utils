/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import com.calypso.tk.core.Action;

/**
 * Writer for Calypso Action objects
 * 
 */
public class ActionWriter implements ObjectWriterInterface<Action> {
    @Override
    public String write(final String objName, final String methodName,
            final Action value) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(Action.valueOf(\"");
        sb.append(value);
        sb.append("\"));\n");

        return sb.toString();
    }
}
