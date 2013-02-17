package calypsoutils.junit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.Holiday;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;
import com.calypso.tk.service.LocalCacheImplementation;
import com.calypso.tk.service.RemoteAccess;
import com.calypso.tk.service.RemoteBackOffice;
import com.calypso.tk.service.RemoteMarketData;
import com.calypso.tk.service.RemoteReferenceData;
import com.calypso.tk.service.RemoteTrade;

/**
 * This class's goal is to provide some useful Mock object used in most of the
 * Junit tests.
 * 
 */
public class CalypsoTester {
    RemoteReferenceData      referenceData;
    RemoteBackOffice         remoteBO;
    RemoteTrade              remoteTrade;
    RemoteMarketData         remoteMarketData;
    RemoteAccess             remoteAccess;
    BOCacheDummyImpl         cacheImpl;
    DSConnection             dsConnection;

    LocalCacheImplementation localCacheImplementation;

    /**
     * You should use the UnitTestHelperAccess to retrieve instance of this
     * class to ensure free all mocked objects after each test
     */
    CalypsoTester() {
        // Initialize the dummy BOCache
        this.cacheImpl = new BOCacheDummyImpl();
        this.cacheImpl.setCurrentHoliday(new Holiday());
        BOCache.setImpl(this.cacheImpl);
        LocalCache.setImpl(this.cacheImpl);

        // create a mock for the DSConnection
        this.dsConnection = mock(DSConnection.class);
        DSConnection.setDefault(this.dsConnection);

        // create mock object for the remote services
        this.referenceData = mock(RemoteReferenceData.class);
        this.remoteBO = mock(RemoteBackOffice.class);
        this.remoteTrade = mock(RemoteTrade.class);
        this.remoteMarketData = mock(RemoteMarketData.class);
        this.remoteAccess = mock(RemoteAccess.class);

        mockDsConnection();

        this.localCacheImplementation = mock(LocalCacheImplementation.class);
    }

    /**
     * when a remote object is requested to the DSConnection return the mock
     */
    protected void mockDsConnection() {
        when(this.dsConnection.getRemoteReferenceData()).thenReturn(
                this.referenceData);
        when(this.dsConnection.getRemoteBO()).thenReturn(this.remoteBO);
        when(this.dsConnection.getRemoteTrade()).thenReturn(this.remoteTrade);
        when(this.dsConnection.getRemoteMarketData()).thenReturn(
                this.remoteMarketData);
        when(this.dsConnection.getRemoteAccess()).thenReturn(this.remoteAccess);
    }

    /** reset all the mocked objects as well as the caches */
    public void reset() {
        this.cacheImpl.clear();
        Mockito.reset(this.referenceData);
        Mockito.reset(this.referenceData);
        Mockito.reset(this.remoteBO);
        Mockito.reset(this.remoteTrade);
        Mockito.reset(this.remoteMarketData);
        Mockito.reset(this.remoteAccess);

        Mockito.reset(this.dsConnection);
        mockDsConnection();

        Mockito.reset(this.localCacheImplementation);
    }

    public RemoteReferenceData getReferenceData() {
        return this.referenceData;
    }

    public RemoteBackOffice getRemoteBO() {
        return this.remoteBO;
    }

    public RemoteMarketData getRemoteMarketData() {
        return this.remoteMarketData;
    }

    public RemoteTrade getRemoteTrade() {
        return this.remoteTrade;
    }

    public BOCacheDummyImpl getCacheImpl() {
        return this.cacheImpl;
    }

    public DSConnection getDsConnection() {
        return this.dsConnection;
    }

    public void setCacheImpl(final BOCacheDummyImpl cacheImpl) {
        this.cacheImpl = cacheImpl;
    }

    public void setDsConnection(final DSConnection dsConnection) {
        this.dsConnection = dsConnection;
    }

    public void setReferenceData(final RemoteReferenceData referenceData) {
        this.referenceData = referenceData;
    }

    public void setRemoteBO(final RemoteBackOffice remoteBO) {
        this.remoteBO = remoteBO;
    }

    public void setRemoteTrade(final RemoteTrade remoteTrade) {
        this.remoteTrade = remoteTrade;
    }

    public LocalCacheImplementation getLocalCacheImplementation() {
        return this.localCacheImplementation;
    }

    /**
     * @param localCacheImplementation
     *            the localCacheImplementation to set
     */
    public void setLocalCacheImplementation(
            final LocalCacheImplementation localCacheImplementation) {
        this.localCacheImplementation = localCacheImplementation;
    }

    public void free() {
        BOCache.setImpl(null);
        LocalCache.setImpl(null);
        DSConnection.setDefault(null);
    }
}
