/**
 * 
 */
package calypsoutils.testing.testgenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * @author quique
 * 
 */
public class TestObjectsGeneratorTest {
    TestObjectsGenerator rut;

    public TestObjectsGeneratorTest() {
        this.rut = new TestObjectsGenerator();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.TestObjectsGenerator#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectory() {
        final String directoryName = "/tmp/calypsoutils";
        final File directory = new File(directoryName);
        assertFalse(directory.exists());

        final boolean result = this.rut.prepareDirectory(directoryName);
        assertTrue(directory.exists());
        assertTrue(result);

        directory.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.TestObjectsGenerator#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectoryAlreadyExists() {
        final String directoryName = "/tmp/calypsoutils";
        final File directory = new File(directoryName);
        assertFalse(directory.exists());

        boolean result = this.rut.prepareDirectory(directoryName);
        assertTrue(directory.exists());
        assertTrue(result);

        result = this.rut.prepareDirectory(directoryName);
        assertTrue(directory.exists());
        assertTrue(result);

        directory.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.TestObjectsGenerator#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectoryNotAllowed() {
        final String directoryName = "/calypsoutils";
        final File directory = new File(directoryName);
        assertFalse(directory.exists());

        final boolean result = this.rut.prepareDirectory(directoryName);
        assertFalse(directory.exists());
        assertFalse(result);
    }
}
