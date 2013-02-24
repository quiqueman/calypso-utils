package calypsoutils.testing.junit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import calypsoutils.testing.junit.cache.BOCacheDummyImpl;
import calypsoutils.testing.junit.cache.LocalCacheDummyImpl;

import com.calypso.tk.bo.BOCache;
import com.calypso.tk.core.Holiday;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;
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
    RemoteReferenceData referenceData;
    RemoteBackOffice remoteBO;
    RemoteTrade remoteTrade;
    RemoteMarketData remoteMarketData;
    RemoteAccess remoteAccess;
    BOCacheDummyImpl boCacheImpl;
    LocalCacheDummyImpl localCacheImpl;
    DSConnection dsConnection;

    public CalypsoTester() {
        // Initialize the dummy BOCache
        this.boCacheImpl = new BOCacheDummyImpl();
        this.localCacheImpl = new LocalCacheDummyImpl();
        this.localCacheImpl.setCurrentHoliday(new Holiday());
        BOCache.setImpl(this.boCacheImpl);
        LocalCache.setImpl(this.localCacheImpl);

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
    }

    public void free() {
        BOCache.setImpl(null);
        LocalCache.setImpl(null);
        DSConnection.setDefault(null);
    }

    /**
     * when a remote object is requested to the DSConnection return the mock.
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

    /** reset all the mocked objects as well as the caches. */
    public void reset() {
        this.boCacheImpl.clear();
        this.localCacheImpl.clear();
        Mockito.reset(this.referenceData);
        Mockito.reset(this.referenceData);
        Mockito.reset(this.remoteBO);
        Mockito.reset(this.remoteTrade);
        Mockito.reset(this.remoteMarketData);
        Mockito.reset(this.remoteAccess);

        Mockito.reset(this.dsConnection);
        mockDsConnection();
    }

    /**
     * @return the referenceData
     */
    public RemoteReferenceData getReferenceData() {
        return this.referenceData;
    }

    /**
     * @param referenceData
     *            the referenceData to set
     */
    public void setReferenceData(final RemoteReferenceData referenceData) {
        this.referenceData = referenceData;
    }

    /**
     * @return the remoteBO
     */
    public RemoteBackOffice getRemoteBO() {
        return this.remoteBO;
    }

    /**
     * @param remoteBO
     *            the remoteBO to set
     */
    public void setRemoteBO(final RemoteBackOffice remoteBO) {
        this.remoteBO = remoteBO;
    }

    /**
     * @return the remoteTrade
     */
    public RemoteTrade getRemoteTrade() {
        return this.remoteTrade;
    }

    /**
     * @param remoteTrade
     *            the remoteTrade to set
     */
    public void setRemoteTrade(final RemoteTrade remoteTrade) {
        this.remoteTrade = remoteTrade;
    }

    /**
     * @return the remoteMarketData
     */
    public RemoteMarketData getRemoteMarketData() {
        return this.remoteMarketData;
    }

    /**
     * @param remoteMarketData
     *            the remoteMarketData to set
     */
    public void setRemoteMarketData(final RemoteMarketData remoteMarketData) {
        this.remoteMarketData = remoteMarketData;
    }

    /**
     * @return the remoteAccess
     */
    public RemoteAccess getRemoteAccess() {
        return this.remoteAccess;
    }

    /**
     * @param remoteAccess
     *            the remoteAccess to set
     */
    public void setRemoteAccess(final RemoteAccess remoteAccess) {
        this.remoteAccess = remoteAccess;
    }

    /**
     * @return the boCacheImpl
     */
    public BOCacheDummyImpl getBoCacheImpl() {
        return this.boCacheImpl;
    }

    /**
     * @param boCacheImpl
     *            the boCacheImpl to set
     */
    public void setBoCacheImpl(final BOCacheDummyImpl boCacheImpl) {
        this.boCacheImpl = boCacheImpl;
    }

    /**
     * @return the localCacheImpl
     */
    public LocalCacheDummyImpl getLocalCacheImpl() {
        return this.localCacheImpl;
    }

    /**
     * @param localCacheImpl
     *            the localCacheImpl to set
     */
    public void setLocalCacheImpl(final LocalCacheDummyImpl localCacheImpl) {
        this.localCacheImpl = localCacheImpl;
    }

    /**
     * @return the dsConnection
     */
    public DSConnection getDsConnection() {
        return this.dsConnection;
    }

    /**
     * @param dsConnection
     *            the dsConnection to set
     */
    public void setDsConnection(final DSConnection dsConnection) {
        this.dsConnection = dsConnection;
    }

}
