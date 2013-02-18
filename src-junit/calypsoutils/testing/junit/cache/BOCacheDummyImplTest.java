/**
 * 
 */
package calypsoutils.testing.junit.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import calypsoutils.testing.junit.CalypsoTester;

import com.calypso.tk.core.Book;

/**
 * @author quiquemán
 * 
 */
public class BOCacheDummyImplTest extends CalypsoTester {
    private static final String BOOK_NAME = "book_name";
    private static final int BOOK_ID = 3141516;
    private static final String OTHER_BOOK_NAME = "other_book_name";
    private static final int OTHER_BOOK_ID = 666;
    BOCacheDummyImpl cut;

    /**
     * Test method for
     * {@link calypsoutils.testing.junit.cache.BOCacheDummyImpl#getBook(com.calypso.tk.service.DSConnection, int)}
     * .
     */
    @Test
    public void testGetBookDSConnectionInt() {
        this.cut = new BOCacheDummyImpl();
        final Book book = new Book();
        book.setId(BOOK_ID);
        book.setName(BOOK_NAME);
        this.cut.add(book);

        Book result = this.cut.getBook(getDsConnection(), BOOK_ID);

        assertEquals(book, result);

        result = this.cut.getBook(getDsConnection(), OTHER_BOOK_ID);

        assertFalse(book.equals(result));
    }

    /**
     * Test method for
     * {@link calypsoutils.testing.junit.cache.BOCacheDummyImpl#getBook(com.calypso.tk.service.DSConnection, java.lang.String)}
     * .
     */
    @Test
    public void testGetBookDSConnectionString() {
        this.cut = new BOCacheDummyImpl();
        final Book book = new Book();
        book.setId(BOOK_ID);
        book.setName(BOOK_NAME);
        this.cut.add(book);

        Book result = this.cut.getBook(getDsConnection(), BOOK_NAME);

        assertEquals(book, result);

        result = this.cut.getBook(getDsConnection(), OTHER_BOOK_NAME);

        assertFalse(book.equals(result));
    }
}
