/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import com.calypso.tk.core.Log;

/**
 * @author quique
 * 
 */
public class WrittersFactory {

    /**
     * @param clazz
     * @return
     */
    public static ObjectWritterInterface getWritter(final Class<?> clazz) {
        final String className = clazz.getSimpleName();
        if ("String".equals(className) || "Boolean".equalsIgnoreCase(className)) {
            return stringWritter;
        } else if ("int".equals(className) || "Integer".equals(className)
                || "long".equalsIgnoreCase(className)
                || "double".equalsIgnoreCase(className)) {
            return numberWritter;
        } else if ("Method".equals(className)) {
            return methodWritter;
        }
        if (Log.isDebug()) {
            Log.debug(WrittersFactory.class, "writter not found for " + clazz);
        }
        return null;
    }

    private static StringWritter stringWritter = new StringWritter();
    private static NumberWritter numberWritter = new NumberWritter();
    private static MethodWritter methodWritter = new MethodWritter();
}
