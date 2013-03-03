/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import java.util.HashMap;

/**
 * @author quique
 * 
 */
public class WritersFactory {
    public static HashMap<String, ObjectWriterInterface> writersMap;

    /**
     * @param clazz
     * @return
     */
    public static ObjectWriterInterface getWriter(final Class<?> clazz) {
        if (writersMap == null) {
            init();
        }

        final String className = clazz.getSimpleName().toLowerCase();
        return writersMap.get(className);
    }

    /**
     * 
     */
    private static void init() {
        final StringWriter stringWriter = new StringWriter();
        final NumberWriter numberWriter = new NumberWriter();

        writersMap = new HashMap<String, ObjectWriterInterface>();
        writersMap.put("string", stringWriter);
        writersMap.put("boolean", stringWriter);
        writersMap.put("int", numberWriter);
        writersMap.put("integer", numberWriter);
        writersMap.put("long", numberWriter);
        writersMap.put("double", numberWriter);
        writersMap.put("method", new MethodWriter());
        writersMap.put("jdate", new JDateWriter());
    }

}
