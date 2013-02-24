package calypsoutils.testing.junit.cache;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import com.calypso.tk.bo.FeeDefinition;
import com.calypso.tk.core.Holiday;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.Tenor;
import com.calypso.tk.event.PSEventAdmin;
import com.calypso.tk.event.PSEventDomainChange;
import com.calypso.tk.marketdata.BetaValue;
import com.calypso.tk.marketdata.CommodityQuoteNameDescriptor;
import com.calypso.tk.marketdata.MarketDataException;
import com.calypso.tk.mo.PosCashFlow;
import com.calypso.tk.mo.TradeOpenQuantity;
import com.calypso.tk.product.CDSSettlementMatrix;
import com.calypso.tk.product.CDSSettlementMatrixConfig;
import com.calypso.tk.product.Commodity;
import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.FXOptExpTZ;
import com.calypso.tk.refdata.FXReset;
import com.calypso.tk.refdata.RateIndex;
import com.calypso.tk.refdata.RateIndexDefaults;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCacheImplementation;
import com.calypso.tk.util.PositionArray;
import com.calypso.tk.util.SettlePositionArray;
import com.calypso.tk.util.SettlePositionBucketArray;

/**
 * This class is used to replace the real Calypso cache in unit testing.
 * 
 */
public class LocalCacheDummyImpl extends CacheDummyImpl implements
        LocalCacheImplementation {

    private Holiday holiday;

    private RateIndexDefaults rateIndexDefaults;

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#
     * getAccountSweepingConfigHashMap()
     */
    @Override
    public HashMap getAccountSweepingConfigHashMap() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#
     * getAllCDSSettlementMatrixItems()
     */
    @Override
    public Vector getAllCDSSettlementMatrixItems() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllCurrencyIndexes
     * (com.calypso.tk.service.DSConnection, java.lang.String)
     */
    @Override
    public Vector getAllCurrencyIndexes(final DSConnection arg0,
            final String arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllCurrencyRateIndexes
     * (com.calypso.tk.service.DSConnection, java.lang.String)
     */
    @Override
    public Vector getAllCurrencyRateIndexes(final DSConnection arg0,
            final String arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#getAllFXOptExpTZ()
     */
    @Override
    public Vector getAllFXOptExpTZ() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllIndexes(com.calypso
     * .tk.service.DSConnection, java.lang.String, java.lang.String)
     */
    @Override
    public Vector getAllIndexes(final DSConnection arg0, final String arg1,
            final String arg2) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllNames(com.calypso
     * .tk.service.DSConnection, int)
     */
    @Override
    public Vector getAllNames(final DSConnection arg0, final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllowWorkflow(com.
     * calypso.tk.service.DSConnection)
     */
    @Override
    public boolean getAllowWorkflow(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllRateIndexeDefaults
     * (com.calypso.tk.service.DSConnection)
     */
    @Override
    public Vector getAllRateIndexeDefaults(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getAllRateIndexes(com
     * .calypso.tk.service.DSConnection)
     */
    @Override
    public Vector getAllRateIndexes(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBaseCurrencyPair(com
     * .calypso.tk.refdata.CurrencyDefault, com.calypso.tk.core.JDate)
     */
    @Override
    public CurrencyPair getBaseCurrencyPair(final CurrencyDefault arg0,
            final JDate arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBetaValue(com.calypso
     * .tk.service.DSConnection, java.lang.String, java.lang.String,
     * com.calypso.tk.core.JDatetime, java.lang.String)
     */
    @Override
    public BetaValue getBetaValue(final DSConnection arg0, final String arg1,
            final String arg2, final JDatetime arg3, final String arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBillingGridRoles(com
     * .calypso.tk.service.DSConnection)
     */
    @Override
    public Vector getBillingGridRoles(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBookId(com.calypso
     * .tk.service.DSConnection, java.lang.String)
     */
    @Override
    public int getBookId(final DSConnection arg0, final String arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBookName(com.calypso
     * .tk.service.DSConnection, int)
     */
    @Override
    public String getBookName(final DSConnection arg0, final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getBookName(com.calypso
     * .tk.service.DSConnection, java.lang.Integer)
     */
    @Override
    public String getBookName(final DSConnection arg0, final Integer arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public int getCcyDecimals(final String cur, final int defaultDec) {
        return defaultDec;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#
     * getCDSSettlementMatrixConfiguration(java.lang.String)
     */
    @Override
    public CDSSettlementMatrixConfig getCDSSettlementMatrixConfiguration(
            final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getCDSSettlementMatrixItem
     * (int)
     */
    @Override
    public CDSSettlementMatrix getCDSSettlementMatrixItem(final int arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#
     * getCommodityQuoteNameDescriptors(com.calypso.tk.product.Commodity,
     * java.lang.String, java.lang.String)
     */
    @Override
    public List<CommodityQuoteNameDescriptor> getCommodityQuoteNameDescriptors(
            final Commodity arg0, final String arg1, final String arg2)
            throws MarketDataException {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getConversionFactor(java
     * .lang.String, java.lang.String, java.lang.String,
     * com.calypso.tk.core.JDate)
     */
    @Override
    public double getConversionFactor(final String arg0, final String arg1,
            final String arg2, final JDate arg3) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#getCurrencies()
     */
    @Override
    public Vector getCurrencies() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getCurrencyByGroup(java
     * .lang.String)
     */
    @Override
    public Vector getCurrencyByGroup(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CurrencyDefault getCurrencyDefault(final String currency) {
        return (CurrencyDefault) this.cache.get(CacheTypesEnum.CURRENCY
                + currency);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getCurrencyDefaults() {
        return this.currencyDefaults;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getCurrencyIndexes(com
     * .calypso.tk.service.DSConnection, java.lang.String, java.lang.String)
     */
    @Override
    public Vector getCurrencyIndexes(final DSConnection arg0,
            final String arg1, final String arg2) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getCurrencyPair(java.
     * lang.String, java.lang.String)
     */
    @Override
    public CurrencyPair getCurrencyPair(final String arg0, final String arg1)
            throws MarketDataException {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getCurrencyPairs(java
     * .lang.String)
     */
    @Override
    public Vector getCurrencyPairs(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Holiday getCurrentHoliday() {
        return this.holiday;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getDeliverableCurrencies
     * ()
     */
    @Override
    public Vector getDeliverableCurrencies() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getDomainValueComment(final DSConnection ds,
            final String domainName, final String value) {

        return (String) this.cache.get(CacheTypesEnum.DOMAIN_VALUE_COMMENT
                + domainName + "." + value);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getDomainValues(final DSConnection ds, final String domainName) {
        final Vector result = (Vector) this.cache
                .get(CacheTypesEnum.DOMAIN_VALUES + domainName);
        return result;
    }

    @Override
    public CurrencyPair getFamilyCurrencyPair(final CurrencyDefault quoting,
            final JDate date) {

        final CurrencyPair cp = new CurrencyPair();
        return cp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFeeDefinition(java
     * .lang.String)
     */
    @Override
    public FeeDefinition getFeeDefinition(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#getFeeDefinitions()
     */
    @Override
    public Hashtable getFeeDefinitions() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFeeDefinitions(java
     * .lang.String)
     */
    @Override
    public Hashtable getFeeDefinitions(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.calypso.tk.service.LocalCacheImplementation#getFeeTypes()
     */
    @Override
    public Vector getFeeTypes() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFeeTypes(java.lang
     * .String)
     */
    @Override
    public Vector getFeeTypes(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFXOptExpTZ(java.lang
     * .String)
     */
    @Override
    public FXOptExpTZ getFXOptExpTZ(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FXOptExpTZ getFXOptExpTZ(final String tzs, final String timeStr) {
        final FXOptExpTZ result = (FXOptExpTZ) this.cache
                .get(CacheTypesEnum.EXPIRY_TZ_VALUES + tzs + "_" + timeStr);
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFXReset(com.calypso
     * .tk.service.DSConnection, int)
     */
    @Override
    public FXReset getFXReset(final DSConnection arg0, final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFXReset(com.calypso
     * .tk.service.DSConnection, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public FXReset getFXReset(final DSConnection arg0, final String arg1,
            final String arg2, final String arg3) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFXResets(com.calypso
     * .tk.service.DSConnection)
     */
    @Override
    public Vector getFXResets(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getFXResets(com.calypso
     * .tk.service.DSConnection, java.lang.String, java.lang.String)
     */
    @Override
    public Vector getFXResets(final DSConnection arg0, final String arg1,
            final String arg2) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getMarketPlaces(com.calypso
     * .tk.service.DSConnection)
     */
    @Override
    public Vector getMarketPlaces(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getNonDeliverableCurrencies
     * ()
     */
    @Override
    public Vector getNonDeliverableCurrencies() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getPositions(com.calypso
     * .tk.service.DSConnection, com.calypso.tk.mo.PosCashFlow)
     */
    @Override
    public PositionArray getPositions(final DSConnection arg0,
            final PosCashFlow arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getPositions(com.calypso
     * .tk.service.DSConnection, com.calypso.tk.mo.TradeOpenQuantity)
     */
    @Override
    public PositionArray getPositions(final DSConnection arg0,
            final TradeOpenQuantity arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getPreciousMetalCurrencies
     * ()
     */
    @Override
    public Vector getPreciousMetalCurrencies() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getProductGroupListHashMap
     * ()
     */
    @Override
    public HashMap getProductGroupListHashMap() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getRateIndex(com.calypso
     * .tk.service.DSConnection, java.lang.String, java.lang.String,
     * com.calypso.tk.core.Tenor, java.lang.String)
     */
    @Override
    public RateIndex getRateIndex(final DSConnection arg0, final String arg1,
            final String arg2, final Tenor arg3, final String arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public RateIndexDefaults getRateIndexDefaults(final DSConnection ds,
            final String currency, final String index) {
        return this.rateIndexDefaults;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getRateIndexSources(com
     * .calypso.tk.service.DSConnection, java.lang.String, java.lang.String,
     * com.calypso.tk.core.Tenor)
     */
    @Override
    public Vector getRateIndexSources(final DSConnection arg0,
            final String arg1, final String arg2, final Tenor arg3) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getRateIndexTenors(com
     * .calypso.tk.service.DSConnection, java.lang.String, java.lang.String)
     */
    @Override
    public Vector getRateIndexTenors(final DSConnection arg0,
            final String arg1, final String arg2) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getRules(java.lang.String
     * )
     */
    @Override
    public Vector getRules(final String arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getSettlePositionBuckets
     * (com.calypso.tk.service.DSConnection, com.calypso.tk.mo.PosCashFlow,
     * java.lang.String, com.calypso.tk.core.JDate,
     * com.calypso.tk.core.JDatetime)
     */
    @Override
    public SettlePositionBucketArray getSettlePositionBuckets(
            final DSConnection arg0, final PosCashFlow arg1, final String arg2,
            final JDate arg3, final JDatetime arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getSettlePositionBuckets
     * (com.calypso.tk.service.DSConnection,
     * com.calypso.tk.mo.TradeOpenQuantity, java.lang.String,
     * com.calypso.tk.core.JDate, com.calypso.tk.core.JDatetime)
     */
    @Override
    public SettlePositionBucketArray getSettlePositionBuckets(
            final DSConnection arg0, final TradeOpenQuantity arg1,
            final String arg2, final JDate arg3, final JDatetime arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getSettlePositions(com
     * .calypso.tk.service.DSConnection, com.calypso.tk.mo.PosCashFlow,
     * com.calypso.tk.core.JDate, java.lang.String)
     */
    @Override
    public SettlePositionArray getSettlePositions(final DSConnection arg0,
            final PosCashFlow arg1, final JDate arg2, final String arg3) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#getSettlePositions(com
     * .calypso.tk.service.DSConnection, com.calypso.tk.mo.TradeOpenQuantity,
     * com.calypso.tk.core.JDate, java.lang.String)
     */
    @Override
    public SettlePositionArray getSettlePositions(final DSConnection arg0,
            final TradeOpenQuantity arg1, final JDate arg2, final String arg3) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#initCache(com.calypso
     * .tk.service.DSConnection)
     */
    @Override
    public void initCache(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#newEvent(com.calypso.
     * tk.service.DSConnection, com.calypso.tk.event.PSEventDomainChange)
     */
    @Override
    public void newEvent(final DSConnection arg0, final PSEventDomainChange arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#newEvent(com.calypso.
     * tk.event.PSEventAdmin)
     */
    @Override
    public void newEvent(final PSEventAdmin arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshCurrencyUtil(com
     * .calypso.tk.service.DSConnection)
     */
    @Override
    public void refreshCurrencyUtil(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshDomains(com.calypso
     * .tk.service.DSConnection)
     */
    @Override
    public void refreshDomains(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshFeeDefinition(
     * com.calypso.tk.service.DSConnection)
     */
    @Override
    public void refreshFeeDefinition(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshFXReset(com.calypso
     * .tk.service.DSConnection)
     */
    @Override
    public void refreshFXReset(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshHolidays(com.calypso
     * .tk.service.DSConnection, com.calypso.tk.event.PSEventDomainChange)
     */
    @Override
    public void refreshHolidays(final DSConnection arg0,
            final PSEventDomainChange arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshMimeTypes(com.
     * calypso.tk.service.DSConnection)
     */
    @Override
    public void refreshMimeTypes(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshRateIndexDefaults
     * (com.calypso.tk.service.DSConnection)
     */
    @Override
    public void refreshRateIndexDefaults(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.calypso.tk.service.LocalCacheImplementation#refreshRateIndexes(com
     * .calypso.tk.service.DSConnection)
     */
    @Override
    public void refreshRateIndexes(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void setCurrencyDefaults(final Hashtable hash) {
        this.currencyDefaults = hash;
    }

    @Override
    public void setCurrentHoliday(final Holiday aholiday) {
        this.holiday = aholiday;
    }

}
