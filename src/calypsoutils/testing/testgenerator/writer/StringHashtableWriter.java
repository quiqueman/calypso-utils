/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Writer which can write a hashtable of <strings, strings>
 * 
 */
public class StringHashtableWriter implements
        ObjectWriterInterface<Hashtable<String, String>> {
    @Override
    public String write(final String objName, final String methodName,
            final Hashtable<String, String> value) {
        final StringBuilder sb = new StringBuilder(
                "\tHashtable<String, String> hash = new Hashtable<String, String>();\n\n");

        final Set<Map.Entry<String, String>> entrySet = value.entrySet();
        for (final Map.Entry<String, String> entry : entrySet) {
            sb.append("\thash.put(\"");
            sb.append(entry.getKey());
            sb.append("\", \"");
            sb.append(entry.getValue());
            sb.append("\");\n");
        }
        sb.append("\t");
        sb.append(objName);
        sb.append('.');
        sb.append(methodName);
        sb.append("(hash);\n\n");

        return sb.toString();
    }
}
