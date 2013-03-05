/**
 * 
 */
package calypsoutils.testing.testgenerator.writer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author quique
 * 
 */
public class WritersFactoryTest {

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterString() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(String.class);
        assertEquals("StringWriter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterBoolean() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(Boolean.class);
        assertEquals("BooleanWriter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterInt() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(int.class);
        assertEquals("NumberWriter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterLong() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(long.class);
        assertEquals("NumberWriter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterInteger() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(Integer.class);
        assertEquals("NumberWriter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WritersFactory#getWriter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWriterLong2() {
        final ObjectWriterInterface<?> result = WritersFactory
                .getWriter(Long.class);
        assertEquals("NumberWriter", result.getClass().getSimpleName());
    }

}
