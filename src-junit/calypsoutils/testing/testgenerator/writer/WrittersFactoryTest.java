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
public class WrittersFactoryTest {

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterString() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(String.class);
        assertEquals("StringWritter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterBoolean() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(Boolean.class);
        assertEquals("StringWritter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterInt() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(int.class);
        assertEquals("NumberWritter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterLong() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(long.class);
        assertEquals("NumberWritter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterInteger() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(Integer.class);
        assertEquals("NumberWritter", result.getClass().getSimpleName());
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.writer.WrittersFactory#getWritter(java.lang.Class)}
     * .
     */
    @Test
    public void testGetWritterLong2() {
        final ObjectWritterInterface result = WrittersFactory
                .getWritter(Long.class);
        assertEquals("NumberWritter", result.getClass().getSimpleName());
    }

}
