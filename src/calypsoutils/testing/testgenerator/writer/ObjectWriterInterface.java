/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

/**
 * @author quique
 * 
 */
public interface ObjectWriterInterface<T extends Object> {
    public String write(final String objName, final String methodName,
            final T value);
}
