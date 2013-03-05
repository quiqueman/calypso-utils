/**
 * 
 */
package calypsoutils.testing.testgenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calypsoutils.testing.testgenerator.generator.data.CreSample;

import com.calypso.tk.bo.BOCre;

/**
 * Test class for TestObjectsGenerator
 * 
 */
public class CreateTestObjectTest {
    final static String DIRECTORY_NAME = "/tmp/calypsoutils";
    CreateTestObject rut;
    File directory;

    public CreateTestObjectTest() {
        this.rut = new CreateTestObject();
    }

    @Before
    public void setup() {
        this.directory = new File(DIRECTORY_NAME);
        this.directory.deleteOnExit();
    }

    @After
    public void tearsDown() {
        this.directory.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.CreateTestObject#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectory() {
        assertFalse(this.directory.exists());

        final File result = this.rut.prepareDirectory(DIRECTORY_NAME);
        assertTrue(this.directory.exists());
        assertNotNull(result);

        this.directory.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.CreateTestObject#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectoryAlreadyExists() {
        assertFalse(this.directory.exists());

        File result = this.rut.prepareDirectory(DIRECTORY_NAME);
        assertTrue(this.directory.exists());
        assertNotNull(result);

        result = this.rut.prepareDirectory(DIRECTORY_NAME);
        assertTrue(this.directory.exists());
        assertNotNull(result);

        this.directory.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.CreateTestObject#prepareDirectory(java.lang.String)}
     * .
     */
    @Test
    public void testPrepareDirectoryNotAllowed() {
        final String directoryName = "/calypsoutils";
        final File directory = new File(directoryName);
        assertFalse(directory.exists());

        final File result = this.rut.prepareDirectory(directoryName);
        assertFalse(directory.exists());
        assertNull(result);
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.CreateTestObject#saveJavaCode(Object, String, String , String )}
     * 
     * @throws IOException
     * 
     */
    @Test
    public void testSaveJavaCode() throws IOException {
        final CreSample sample = new CreSample();
        final BOCre cre = sample.createCre();

        this.rut.saveJavaCode(cre, "/tmp/calypsoutils", "creSample",
                "Junit test for TestObjectGenerator");

        final File targetClass = new File(
                "/tmp/calypsoutils/CreSampleBuilder.java");
        assertTrue(targetClass.exists());

        final BufferedReader bf = new BufferedReader(
                new FileReader(targetClass));
        String line = bf.readLine();
        while (line != null) {
            System.out.println(line);
            line = bf.readLine();
        }
        bf.close();
        targetClass.delete();
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.testgenerator.CreateTestObject#saveJavaCode(Object, String, String , String )}
     * 
     * @throws IOException
     * 
     */
    @Test
    public void testSaveJavaCodeWithCompilation() throws IOException {
        final CreSample sample = new CreSample();
        final BOCre cre = sample.createCre();

        this.rut.saveJavaCode(cre, "/tmp/calypsoutils", "creSample",
                "Junit test for TestObjectGenerator");

        final File targetClass = new File(
                "/tmp/calypsoutils/CreSampleBuilder.java");
        assertTrue(targetClass.exists());

        final boolean result = new JavaCompilation()
                .compile("/tmp/calypsoutils/CreSampleBuilder.java");
        targetClass.delete();
        assertTrue(result);
    }
}
