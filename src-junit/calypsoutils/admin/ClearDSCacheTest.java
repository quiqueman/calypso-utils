package calypsoutils.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.calypso.tk.core.SerializationException;
import com.calypso.tk.event.PSException;
import com.calypso.tk.util.ConnectException;

/**
 * Test cases for class ClearDSCacheTest.
 * 
 */
public class ClearDSCacheTest {
    /**
     * Resource under test (rut).
     */
    private final ClearDSCache rut;

    private PrintStream oldSystemOut;
    private PrintStream oldSystemErr;
    private PrintStream systemOut;
    private PrintStream systemErr;
    private ByteArrayOutputStream baosOut;
    private ByteArrayOutputStream baosErr;

    /**
     * Constructor.
     */
    public ClearDSCacheTest() {
        this.rut = new ClearDSCache();
    }

    /**
     * before each test's execution do...
     */
    @Before
    public void setUp() {
        // Create a stream to hold the output
        this.baosOut = new ByteArrayOutputStream();
        this.baosErr = new ByteArrayOutputStream();
        this.systemErr = new PrintStream(this.baosErr);
        this.systemOut = new PrintStream(this.baosOut);
        // IMPORTANT: Save the old System.out!
        this.oldSystemOut = System.out;
        this.oldSystemErr = System.err;
        // Tell Java to use your special stream
        System.setErr(this.systemErr);
        System.setOut(this.systemOut);
    }

    /**
     * after each test's execution do...
     */
    @After
    public void tearsDown() {
        // Tell Java to use default out and err
        System.setErr(this.oldSystemErr);
        System.setOut(this.oldSystemOut);
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
        final String[] args = { "-env", "env", "-usuario", "user", "-password",
                "passwd", "-noaudit" };
        final boolean result = this.rut.checkParams(args);
        assertFalse(result);
        assertNull(this.rut.user);
        assertEquals("passwd", this.rut.passwd);
        assertEquals("env", this.rut.env);
    }

    /**
     * Main method. Bad Arguments
     * 
     * @throws SerializationException
     *             should not happen
     * @throws RemoteException
     *             should not happen
     * @throws PSException
     *             should not happen
     * @throws ConnectException
     *             should not happen
     */
    @Test
    public void testMainBadArguments() throws ConnectException, PSException,
            RemoteException, SerializationException {
        final String[] args = { "-env", "env", "-usuario", "user", "-password",
                "passwd", "-nogui" };
        ClearDSCache.main(args);
        this.systemErr.flush();
        assertEquals("Bad arguments: " + ClearDSCache.USAGE_TEXT + "\n",
                this.baosErr.toString());
    }
}
