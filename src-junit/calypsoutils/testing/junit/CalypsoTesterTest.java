/**
 * 
 */
package calypsoutils.testing.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.calypso.tk.bo.BOCacheExposed;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;

/**
 * Unit test for CalypsoTester
 * 
 */
public class CalypsoTesterTest {
    CalypsoTester tester;

    /**
     * Test method for {@link calypsoutils.testing.junit.CalypsoTester#free()}.
     */
    @Test
    public void testFree() {
        this.tester = new CalypsoTester();

        // during the construction of the tester the implementations are
        // assigned to the dummy instances
        assertNotNull(BOCacheExposed.getImplementation());
        try {
            LocalCache.getCcyDecimals("EUR", 2);
        } catch (final NullPointerException ex) {
            fail("LocalCache implementation is null");
        }
        assertNotNull(DSConnection.getDefault());

        this.tester.free();

        // now they should be null
        assertNull(BOCacheExposed.getImplementation());
        try {
            LocalCache.getCcyDecimals("EUR", 2);
            fail("LocalCache implementation is not null");
        } catch (final NullPointerException ex) {
            System.out.println("ok");
        }
        assertNull(DSConnection.getDefault());
    }
}
