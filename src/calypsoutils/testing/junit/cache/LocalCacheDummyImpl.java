package calypsoutils.testing.junit.cache;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import com.calypso.tk.bo.FeeDefinition;
import com.calypso.tk.core.Book;
import com.calypso.tk.core.Holiday;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.LegalEntity;
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
import com.calypso.tk.product.commodities.schedulegeneration.intraday.IntradayConfiguration;
import com.calypso.tk.refdata.CommodityReset;
import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.refdata.CurrencyPair;
import com.calypso.tk.refdata.FXOptExpTZ;
import com.calypso.tk.refdata.FXReset;
import com.calypso.tk.refdata.RateIndex;
import com.calypso.tk.refdata.RateIndexDefaults;
import com.calypso.tk.refdata.SDI;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCacheImplementation;
import com.calypso.tk.util.PositionArray;
import com.calypso.tk.util.SettlePositionArray;
import com.calypso.tk.util.SettlePositionBucketArray;

public class LocalCacheDummyImpl extends CacheDummyImpl implements
        LocalCacheImplementation {

    private Holiday holiday;

    private RateIndexDefaults rateIndexDefaults;

    @SuppressWarnings("rawtypes")
    @Override
    public HashMap getAccountSweepingConfigHashMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllCDSSettlementMatrixItems() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllCurrencyIndexes(final DSConnection ds,
            final String currency) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllCurrencyRateIndexes(final DSConnection ds,
            final String currency) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllFXOptExpTZ() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllIndexes(final DSConnection ds, final String currency,
            final String indexType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllNames(final DSConnection ds, final int what) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public boolean getAllowWorkflow(final DSConnection ds) {

        return false;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllRateIndexeDefaults(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAllRateIndexes(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CurrencyPair getBaseCurrencyPair(final CurrencyDefault quoting,
            final JDate date) {
        return null;
        // throw new UnsupportedOperationException(
        // "TODO Auto-generated method stub");
    }

    @Override
    public BetaValue getBetaValue(final DSConnection arg0, final String arg1,
            final String arg2, final JDatetime arg3, final String arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBillingGridRoles(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public int getBookId(final DSConnection ds, final String name) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getBookName(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getBookName(final DSConnection ds, final Integer id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public int getCcyDecimals(final String cur, final int defaultDec) {
        return defaultDec;
    }

    @Override
    public CDSSettlementMatrixConfig getCDSSettlementMatrixConfiguration(
            final String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CDSSettlementMatrix getCDSSettlementMatrixItem(
            final int matrixItemId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public List<CommodityQuoteNameDescriptor> getCommodityQuoteNameDescriptors(
            final Commodity commodity, final String s, final String s1)
            throws MarketDataException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public CommodityReset getCommodityReset(final DSConnection ds,
            final Commodity commodity, final String currency, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public CommodityReset getCommodityReset(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    public Vector getCommodityResets(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public double getConversionFactor(final String s, final String s1,
            final String s2, final JDate jdate) {
        // TODO Auto-generated method stub
        return 0;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCurrencies() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCurrencyByGroup(final String group) {

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

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCurrencyIndexes(final DSConnection ds,
            final String currency, final String indexType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CurrencyPair getCurrencyPair(final String primary,
            final String quoting) throws MarketDataException {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCurrencyPairs(final String quoting) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Holiday getCurrentHoliday() {
        return this.holiday;
    }

    @SuppressWarnings("rawtypes")
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
    public Vector getDomainValues(final DSConnection ds,
            final String domainName) {
        final Vector result = (Vector) this.cache
                .get(CacheTypesEnum.DOMAIN_VALUES + domainName);
        return result;
    }

    @Override
    public CurrencyPair getFamilyCurrencyPair(final CurrencyDefault quoting,
            final JDate date) {

        final CurrencyPair cp = new CurrencyPair();
        return cp;
        // throw new UnsupportedOperationException(
        // "TODO Auto-generated method stub");
    }

    @Override
    public FeeDefinition getFeeDefinition(final String type) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getFeeDefinitions() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getFeeDefinitions(final String role) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeTypes() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeTypes(final String role) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FXOptExpTZ getFXOptExpTZ(final String name) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FXOptExpTZ getFXOptExpTZ(final String tzs, final String timeStr) {
        final FXOptExpTZ result = (FXOptExpTZ) this.cache
                .get(CacheTypesEnum.EXPIRY_TZ_VALUES + tzs + "_" + timeStr);
        return result;
    }

    @Override
    public FXReset getFXReset(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FXReset getFXReset(final DSConnection ds, final String primary,
            final String quoting, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFXResets(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFXResets(final DSConnection ds, final String primary,
            final String quoting) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public IntradayConfiguration getIntradayConfiguration(
            final DSConnection arg0, final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getMarketPlaces(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getNonDeliverableCurrencies() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionArray getPositions(final DSConnection ds,
            final PosCashFlow pc) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionArray getPositions(final DSConnection ds,
            final TradeOpenQuantity qty) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getPreciousMetalCurrencies() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public HashMap getProductGroupListHashMap() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public RateIndex getRateIndex(final DSConnection ds,
            final String currency, final String index, final Tenor tenor,
            final String source) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public RateIndexDefaults getRateIndexDefaults(final DSConnection ds,
            final String currency, final String index) {
        return this.rateIndexDefaults;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getRateIndexSources(final DSConnection ds,
            final String currency, final String name, final Tenor tenor) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getRateIndexTenors(final DSConnection ds,
            final String currency, final String name) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getRules(final String eventClass) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SettlePositionBucketArray getSettlePositionBuckets(
            final DSConnection ds, final PosCashFlow pc,
            final String dateType, final JDate date,
            final JDatetime bucketDatetime) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SettlePositionBucketArray getSettlePositionBuckets(
            final DSConnection ds, final TradeOpenQuantity qty,
            final String dateType, final JDate date,
            final JDatetime bucketDatetime) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SettlePositionArray getSettlePositions(final DSConnection ds,
            final PosCashFlow pc, final JDate date, final String dateType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SettlePositionArray getSettlePositions(final DSConnection ds,
            final TradeOpenQuantity qty, final JDate date,
            final String dateType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public String getUsername(final String s) {
        return (String) this.cache.get("UserName." + s);
    }

    @Override
    public void initCache(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventDomainChange event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final PSEventAdmin event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshCurrencyUtil(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshDomains(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshFeeDefinition(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshFXReset(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshHolidays(final DSConnection ds,
            final PSEventDomainChange event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshMimeTypes(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshRateIndexDefaults(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void refreshRateIndexes(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public void remove(final Book book) {
        this.cache.remove(CacheTypesEnum.BOOK.toString() + book.getId());
        this.cache.remove(CacheTypesEnum.BOOK.toString() + book.getName());

    }

    public void remove(final LegalEntity le) {
        this.cache.remove(CacheTypesEnum.LEGAL_ENTITY.toString() + le.getId());
        this.cache.remove(CacheTypesEnum.LEGAL_ENTITY.toString()
                + le.getCode());
    }

    public void remove(final SDI sdi) {
        this.cache.remove(CacheTypesEnum.SDI.toString() + sdi.getId());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void setCurrencyDefaults(final Hashtable hash) {
        this.currencyDefaults = hash;
    }

    @Override
    public void setCurrentHoliday(final Holiday holiday) {
        this.holiday = holiday;
    }

    public void setDomainValueComment(final String s1, final String s2,
            final String s3) {
        this.cache
                .put(CacheTypesEnum.DOMAIN_VALUE_COMMENT + s1 + "." + s2, s3);
    }

    /**
     * @param rateIndexDefaults
     *            the rateIndexDefaults to set
     */
    public void setRateIndexDefaults(final RateIndexDefaults rateIndexDefaults) {
        this.rateIndexDefaults = rateIndexDefaults;
    }

}
