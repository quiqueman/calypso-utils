/**
 * 
 */
package calypsoutils.testing.testgenerator;

/**
 * For those classes which don't have yet a Generator implementation this
 * generator returns a java comment
 * 
 */
public class TodoGenerator implements Generator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * calypsoutils.testing.testgenerator.Generator#getJavaCode(java.lang.Object
     * )
     */
    @Override
    public String getJavaCode(final Object obj) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }
}
