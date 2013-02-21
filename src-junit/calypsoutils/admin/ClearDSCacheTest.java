package calypsoutils.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for class ClearDSCacheTest
 * 
 */
public class ClearDSCacheTest {
    /**
     * Resource under test (rut)
     */
    private final ClearDSCache rut;

    /**
     * Constructor.
     */
    public ClearDSCacheTest() {
        this.rut = new ClearDSCache();
    }

    /**
     * Checking when all the parameters are ok.
     */
    @Test
    public void testCheckParamsOk() {
        final String[] args = { "-env", "env", "-user", "user", "-password",
                "passwd", "-noaudit" };
        final boolean result = this.rut.checkParams(args);
        assertTrue(result);

        assertEquals("user", this.rut.user);
        assertEquals("passwd", this.rut.passwd);
        assertEquals("env", this.rut.env);
    }

    /**
     * Checking when the parameter user is not present ('usuario' instead).
     */
    @Test
    public void testCheckParamsNoUserName() {
        final String[] args = { "-env", "env", "-usuario", "user",
                "-password", "passwd", "-noaudit" };
        final boolean result = this.rut.checkParams(args);
        assertFalse(result);
        assertNull(this.rut.user);
        assertEquals("passwd", this.rut.passwd);
        assertEquals("env", this.rut.env);
    }

}
