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
    public static HashMap<String, ObjectWriterInterface<?>> writersMap;

    /**
     * @param clazz
     * @return
     */
    public static ObjectWriterInterface<?> getWriter(final Class<?> clazz) {
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
        final NumberWriter numberWriter = new NumberWriter();

        writersMap = new HashMap<String, ObjectWriterInterface<?>>();
        writersMap.put("action", new ActionWriter());
        writersMap.put("string", new StringWriter());
        writersMap.put("boolean", new BooleanWriter());
        writersMap.put("int", numberWriter);
        writersMap.put("integer", numberWriter);
        writersMap.put("long", numberWriter);
        writersMap.put("double", numberWriter);
        writersMap.put("method", new MethodWriter());
        writersMap.put("jdate", new JDateWriter());
        writersMap.put("jdatetime", new JDatetimeWriter());
        writersMap.put("status", new StatusWriter());
        writersMap.put("timezone", new TimeZoneWriter());
        writersMap.put("hashtable", new StringHashtableWriter());
        writersMap.put("vector", new StringVectorWriter());
    }

}
