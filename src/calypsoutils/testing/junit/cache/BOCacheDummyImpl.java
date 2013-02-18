package calypsoutils.testing.junit.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.collections.Predicate;

import com.calypso.tk.bo.AccountStatement;
import com.calypso.tk.bo.BOMessage;
import com.calypso.tk.bo.BOTransfer;
import com.calypso.tk.bo.CacheImpl;
import com.calypso.tk.bo.InventoryAggregation;
import com.calypso.tk.bo.TaskConfig;
import com.calypso.tk.bo.TaskWorkflowConfig;
import com.calypso.tk.bo.TradeTransferRule;
import com.calypso.tk.bo.workflow.KickOffCutOffConfig;
import com.calypso.tk.bo.workflow.WorkFlowConfigKey;
import com.calypso.tk.core.Auditable;
import com.calypso.tk.core.Book;
import com.calypso.tk.core.CashFlow;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.HedgeRelationship;
import com.calypso.tk.core.HedgeStrategy;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.core.Product;
import com.calypso.tk.core.Status;
import com.calypso.tk.core.TemplateInfo;
import com.calypso.tk.core.Trade;
import com.calypso.tk.core.TradeBundle;
import com.calypso.tk.costing.client.model.method.calculation.CalculationMethodMapEntry;
import com.calypso.tk.costing.common.domain.LegalEntityRoleIdentifier;
import com.calypso.tk.costing.model.event.abstraction.CostingEventType;
import com.calypso.tk.costing.model.grid.CostingGrid;
import com.calypso.tk.costing.model.grid.CostingGridIdentifier;
import com.calypso.tk.costing.model.grid.CostingGridList;
import com.calypso.tk.event.PSEventAdmin;
import com.calypso.tk.event.PSEventCreditRating;
import com.calypso.tk.event.PSEventDomainChange;
import com.calypso.tk.event.PSEventProductCreditRating;
import com.calypso.tk.event.PSEventQuote;
import com.calypso.tk.event.PSEventQuoteRemoved;
import com.calypso.tk.event.PSEventStatement;
import com.calypso.tk.marketdata.CreditRating;
import com.calypso.tk.marketdata.FilterSet;
import com.calypso.tk.marketdata.Mark;
import com.calypso.tk.marketdata.PricingEnv;
import com.calypso.tk.marketdata.PricingFallbackStrategy;
import com.calypso.tk.marketdata.PricingParamType;
import com.calypso.tk.marketdata.PricingParameters;
import com.calypso.tk.marketdata.ProductCreditRating;
import com.calypso.tk.marketdata.QuoteValue;
import com.calypso.tk.mo.LiquidationConfig;
import com.calypso.tk.mo.LiquidationInfo;
import com.calypso.tk.mo.PositionAggregation;
import com.calypso.tk.mo.PositionAggregationConfig;
import com.calypso.tk.mo.PositionInfo;
import com.calypso.tk.mo.PositionSpec;
import com.calypso.tk.mo.TradeFilter;
import com.calypso.tk.product.BondDefault;
import com.calypso.tk.product.CA;
import com.calypso.tk.product.CFD;
import com.calypso.tk.product.Commodity;
import com.calypso.tk.product.FX;
import com.calypso.tk.product.FutureContract;
import com.calypso.tk.product.PositionCash;
import com.calypso.tk.product.PositionFXNDF;
import com.calypso.tk.product.ReferenceEntity;
import com.calypso.tk.product.Ticker;
import com.calypso.tk.product.commodities.schedulegeneration.intraday.IntradayConfiguration;
import com.calypso.tk.product.eXSP.typing.ConfigurableType;
import com.calypso.tk.refdata.Account;
import com.calypso.tk.refdata.AccountInterestConfig;
import com.calypso.tk.refdata.AccountingEventConfig;
import com.calypso.tk.refdata.AdviceConfig;
import com.calypso.tk.refdata.BondBenchmark;
import com.calypso.tk.refdata.BookValCcy;
import com.calypso.tk.refdata.CFDContractDefinition;
import com.calypso.tk.refdata.CFDCountryGrid;
import com.calypso.tk.refdata.CommodityReset;
import com.calypso.tk.refdata.Country;
import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.refdata.FXOptExpTZ;
import com.calypso.tk.refdata.FeeBillingRule;
import com.calypso.tk.refdata.FeeGrid;
import com.calypso.tk.refdata.FormattingStyle;
import com.calypso.tk.refdata.HedgeRelationshipConfig;
import com.calypso.tk.refdata.LEContact;
import com.calypso.tk.refdata.LERegistration;
import com.calypso.tk.refdata.LegalAgreement;
import com.calypso.tk.refdata.LegalEntityAttribute;
import com.calypso.tk.refdata.LegalEntityEODTime;
import com.calypso.tk.refdata.LegalEntityRelation;
import com.calypso.tk.refdata.ManualSDI;
import com.calypso.tk.refdata.MarginCallConfig;
import com.calypso.tk.refdata.MessageGroup;
import com.calypso.tk.refdata.NettingMethod;
import com.calypso.tk.refdata.PartySDI;
import com.calypso.tk.refdata.RoleDisabled;
import com.calypso.tk.refdata.SDI;
import com.calypso.tk.refdata.SettleDeliveryInstruction;
import com.calypso.tk.refdata.StaticDataFilter;
import com.calypso.tk.refdata.TemplateDefaults;
import com.calypso.tk.refdata.VegaWeights;
import com.calypso.tk.refdata.WithholdingTaxAttribute;
import com.calypso.tk.refdata.distribution.PeriodDistribution;
import com.calypso.tk.refdata.eXSP.variable.product.ProductVariable;
import com.calypso.tk.refdata.eXSP.variable.quotable.QuotableVariable;
import com.calypso.tk.report.ReportTemplate;
import com.calypso.tk.report.ReportTemplateName;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.util.ManualSDIArray;
import com.calypso.tk.util.SDIArray;

public class BOCacheDummyImpl implements CacheImpl {

    private static final String ACCOUNT = "Account.";

    private static final String LECONTACT = "LEContact.";

    private static final String SDI = "SDI.";

    private static final String LEA = "LegalEntityAttribute.";

    private static final String LEGAL_ENTITY = "LegalEntity.";

    private static final String BOOK = "Book.";

    private static final String CURRENCY = "Currency.";

    private static final String PARTY_SDI = "PartySDI.";

    private static final String LONG_NAME = "LongName.";

    private static final String DOMAIN_VALUES = "DomainValues.";
    private static final String DOMAIN_VALUE_COMMENT = "DomainValueComment.";

    private static final String EXPIRY_TZ_VALUES = "ExpiryTZValues.";

    private static final String COUNTRY = "Country";
    private static final String ATTRIBUTES = "Attributes";

    HashMap<String, Object> cache;
    Hashtable<String, Object> currencyDefaults;

    public BOCacheDummyImpl() {
        this.cache = new HashMap<String, Object>();
    }

    public void add(final Account account) {
        this.cache.put(ACCOUNT + account.getId(), account);
    }

    public void add(final Book book) {
        this.cache.put(BOOK + book.getId(), book);
        this.cache.put(BOOK + book.getName(), book);
    }

    public void add(final CurrencyDefault cd) {
        this.cache.put(CURRENCY + cd.getCode(), cd);

    }

    public void add(final FXOptExpTZ expTimeZone, final String time) {
        this.cache.put(
                EXPIRY_TZ_VALUES + expTimeZone.getTimeStr() + "_" + time,
                expTimeZone);
    }

    public void add(final LEContact contact) {
        this.cache.put(LECONTACT + contact.getLegalEntityId(), contact);
    }

    public void add(final LegalEntity le) {
        this.cache.put(LEGAL_ENTITY + le.getId(), le);
        this.cache.put(LEGAL_ENTITY + le.getCode(), le);
        this.cache.put(LEGAL_ENTITY + le.getId() + COUNTRY, le.getCountry());
        this.cache.put(LEGAL_ENTITY + le.getCode() + COUNTRY, le.getCountry());
        this.cache.put(LEGAL_ENTITY + le.getId() + ATTRIBUTES,
                le.getLegalEntityAttributes());
        this.cache.put(LEGAL_ENTITY + le.getCode() + ATTRIBUTES,
                le.getLegalEntityAttributes());

    }

    public void add(final LegalEntityAttribute lea) {
        this.cache.put(
                LEA + lea.getLegalEntityId() + "." + lea.getAttributeType(),
                lea);
    }

    public void add(final PartySDI partySDI) {
        this.cache.put(PARTY_SDI + partySDI.getPartyId(), partySDI);
    }

    public void add(final SDI sdi) {
        this.cache.put(SDI + sdi.getId(), sdi);
    }

    public void add(final Vector<String> domainValues, final String domainName) {
        this.cache.put(DOMAIN_VALUES + domainName, domainValues);
    }

    public void addCountryISOCode(final String country, final String isoCode) {
        this.cache.put(COUNTRY + country, isoCode);
    }

    public void addCurrencyDefault(final String currency,
            final CurrencyDefault cd) {
        this.cache.put(CURRENCY + currency, cd);
    }

    public void addDomainValueComment(final String domainName,
            final String domainValue, final String comment) {
        this.cache.put(DOMAIN_VALUE_COMMENT + domainName + "." + domainValue,
                comment);
    }

    @Override
    public void addInventoryAggregation(final DSConnection ds,
            final InventoryAggregation invAgg) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public void addLongName(final String longName, final PartySDI partySDI) {
        this.cache.put(LONG_NAME + partySDI.getPartyId(), longName);
    }

    public void addUserName(final String s) {
        this.cache.put("UserName." + s, s);
    }

    @Override
    public void clear() {
        this.cache.clear();
    }

    @Override
    public void clearFlows(final int productId) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void clearFOPositionCA() {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void clearProperty(final DSConnection ds, final String user,
            final String prop) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void clearPropertyColumns(final DSConnection ds, final String user,
            final String prop) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalEntityEODTime find(final DSConnection ds,
            final LegalEntityEODTime ler) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalEntityRelation find(final DSConnection ds,
            final LegalEntityRelation ler) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public RoleDisabled find(final DSConnection ds, final RoleDisabled ler) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Account getAccount(final DSConnection ds, final int id) {
        return (Account) this.cache.get(ACCOUNT + id);
    }

    @Override
    public Account getAccount(final DSConnection ds, final String name,
            final int poId, final String currency) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public final Hashtable getAccountExternalNameHash(final DSConnection ds) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getAccountExternalNames(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public AccountingEventConfig getAccountingEventConfig(
            final DSConnection ds, final int accEventId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public AccountInterestConfig getAccountInterestConfig(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public AccountStatement getAccountStatement(final DSConnection ds,
            final int id, final boolean summary) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public AdviceConfig getAdviceConfig(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public List<HedgeRelationshipConfig> getAllHedgeRelationshipConfigs(
            final DSConnection dsconnection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ManualSDIArray getBeneManualSDI(final DSConnection ds,
            final String code) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ManualSDIArray getBeneManualSDI(final DSConnection ds,
            final String code, final JDate validFrom) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SDIArray getBeneSettleDeliveryInstructions(final int id,
            final String role, final DSConnection dsCon) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SDIArray getBeneSettleDeliveryInstructions(final String beneficiary,
            final String role, final DSConnection dsCon) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBillingGrids(final DSConnection ds, final int accountId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public BondBenchmark getBondBenchmark(final DSConnection ds,
            final String benchmarkName, final JDate onDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public BondBenchmark getBondBenchmark(final DSConnection ds,
            final String benchmarkName, final JDatetime onDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getBondBenchmarkName(final DSConnection ds,
            final int productID, final JDate onDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getBondBenchmarkName(final DSConnection ds,
            final int productID, final JDatetime onDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public BondDefault getBondDefault(final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Book getBook(final DSConnection dsCon, final int id) {
        return (Book) this.cache.get(BOOK + id);
    }

    @Override
    public Book getBook(final DSConnection dsCon, final String name) {
        return (Book) this.cache.get(BOOK + name);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBookAttributeNames(final DSConnection dsCon) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getBooks(final DSConnection dsCon) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBooksFromBookIds(final DSConnection dsCon,
            final Vector bookIds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBooksFromBookNames(final DSConnection dsCon,
            final Vector bookNames) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public BookValCcy getBookValCcy(final DSConnection ds, final int bookId,
            final String productType, final int productId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getBrokerFeeGrids(final int legalEntityId, final Trade trade,
            final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CA getCA(final DSConnection ds, final String type,
            final String subtype, final String ccy, final int underlyingid) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public HashMap getCacheStats() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public HashMap getCacheStats(final boolean getFullList) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CFDContractDefinition getCFDContract(final DSConnection ds,
            final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCFDContractPO(final DSConnection ds, final int poId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CFDCountryGrid getCFDCountryGrid(final DSConnection ds,
            final CFD cfd, final JDate valDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CFDCountryGrid getCFDCountryGrid(final DSConnection ds, final int id) {

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
    public ConfigurableType getConfigurableType(final DSConnection ds,
            final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getConfigurableTypeNames(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getConfigurableTypes(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LEContact getContact(final String role, final LegalEntity le,
            final String contactType, final String productType, final int poId,
            final DSConnection ds) {

        return (LEContact) this.cache.get(LECONTACT + le.getId());
    }

    @Override
    public LEContact getContact(final String role, final LegalEntity le,
            final String contactType, final String productType, final int poId,
            final JDate valDate, final Trade trade, final BOTransfer transfer,
            final DSConnection ds) {
        return (LEContact) this.cache.get(LECONTACT + le.getId());
    }

    @Override
    public List<CalculationMethodMapEntry> getCostingClientCalculationMethodMappingEntries(
            final DSConnection dsconnection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CostingGrid getCostingGrid(final DSConnection dsconnection,
            final CostingGridIdentifier costinggrididentifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CostingGridList getCostingGridsMatching(
            final DSConnection dsconnection,
            final CostingEventType costingeventtype) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CostingGridList getCostingGridsMatching(
            final DSConnection dsconnection, final Predicate predicate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getCountries(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Country getCountry(final DSConnection ds, final String name) {

        final Country rst = new Country();
        final String isoCode = (String) this.cache.get(COUNTRY + name);

        rst.setName(name);
        rst.setISOCode(isoCode);

        return rst;
    }

    @Override
    public Country getCountryByISO(final DSConnection ds, final String code) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public DateRule getDateRule(final DSConnection ds, final String dateRule) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Book getDefaultBook(final DSConnection dsCon, final int poId,
            final String bookAttribute) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getDefaultMessageRules(final DSConnection dsconnection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Product getExchangedTradedProduct(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Product getExchangeTradedProductByKey(
            final DSConnection dsconnection, final String s, final String s1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getExchangeTradedProducts(final DSConnection ds,
            final String type, final String from, final String where,
            final boolean useCache) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FeeBillingRule getFeeBillingRule(final DSConnection dsCon,
            final int feeBillId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeBillingRules(final DSConnection dsCon,
            final int legalEntityId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public List<FeeBillingRule> getFeeBillingRules(
            final DSConnection dsconnection, final LegalEntity legalentity,
            final LegalEntityRoleIdentifier legalentityroleidentifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FeeGrid getFeeGrid(final DSConnection ds, final int feeGridId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeGrids(final int arg0, final String arg1,
            final Trade arg2, final boolean arg3, final DSConnection arg4) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeGrids(final int legalEntityId, final String role,
            final Trade trade, final CashFlow cashflow, final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFeeGrids(final int legalEntityId, final String role,
            final Trade trade, final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FilterSet getFilterSet(final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getFOPositionCA(final DSConnection ds, final Product p,
            final JDate startDate, final JDate endDate, final PricingEnv env) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FormattingStyle getFormattingStyle(final DSConnection dsconnection,
            final String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FutureContract getFutureContract(final DSConnection dsconnection,
            final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FutureContract getFutureContract(final DSConnection ds,
            final String currency, final String exchange,
            final String contractName) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public FX getFX(final DSConnection ds, final String prim, final String sec) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public HedgeRelationship getHedgeRelationship(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public HedgeRelationshipConfig getHedgeRelationshipConfig(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public HedgeStrategy getHedgeStrategy(final DSConnection ds, final int id) {

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

    @Override
    public InventoryAggregation getInventoryAggregation(final DSConnection ds,
            final int aggId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public InventoryAggregation getInventoryAggregation(final DSConnection ds,
            final InventoryAggregation invAgg) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public KickOffCutOffConfig getKickOffCutOffConfig(final DSConnection ds,
            final int kickoffId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public KickOffCutOffConfig getKickOffCutOffConfig(final DSConnection ds,
            final int workflowId, final int receiverId, final String currency,
            final String method, final Trade trade, final BOTransfer transfer,
            final BOMessage message) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ProductCreditRating getLatestProductRating(
            final DSConnection dsconnection,
            final ProductCreditRating productcreditrating) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public CreditRating getLatestRating(final DSConnection ds,
            final CreditRating rating) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalEntity getLEFromCache(final int id) {
        return (LegalEntity) this.cache.get(LEGAL_ENTITY + id);
    }

    @Override
    public LegalAgreement getLegalAgreement(final DSConnection ds,
            final int leId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalAgreement getLegalAgreement(final DSConnection dsconnection,
            final LegalAgreement legalagreement) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalAgreement getLegalAgreement(final DSConnection ds,
            final String processingOrgName, final String leName,
            final String productFamily, final String productType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getLegalEntitiesForRole(final DSConnection ds,
            final String role) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getLegalEntitiesFromLegalEntityIds(final DSConnection dsCon,
            final List legalEntityIds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalEntity getLegalEntity(final DSConnection ds, final int id) {
        final LegalEntity rst = (LegalEntity) this.cache.get(LEGAL_ENTITY + id);
        String country = (String) this.cache.get(LEGAL_ENTITY + id
                + BOCacheDummyImpl.COUNTRY);
        if (country == null) {
            country = "";
        }
        if (rst != null) {
            rst.setCountry(country);
        }

        return rst;
    }

    @Override
    public LegalEntity getLegalEntity(final DSConnection ds, final String name) {
        final LegalEntity rst = (LegalEntity) this.cache.get(LEGAL_ENTITY
                + name);
        String country = (String) this.cache.get(LEGAL_ENTITY + name
                + BOCacheDummyImpl.COUNTRY);
        if (country == null) {
            country = "";
        }
        if (rst != null) {
            rst.setCountry(country);
        }
        return rst;
    }

    @Override
    public LegalEntityAttribute getLegalEntityAttribute(final DSConnection ds,
            final int poId, final int leId, final String leRole,
            final String attributeType) {

        return (LegalEntityAttribute) this.cache.get(LEA + leId + "."
                + attributeType);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getLegalEntityAttributes(final DSConnection ds, final int leId) {

        return (Vector) this.cache.get(LEGAL_ENTITY + leId + ATTRIBUTES);
        // throw new UnsupportedOperationException(
        // "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getLegalEntityAttributesFromCache(final int leId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getLegalEntityCode(final DSConnection dsconnection,
            final int i) {
        // throw new UnsupportedOperationException(
        // "TODO Auto-generated method stub");
        return "T99A";
    }

    @Override
    public LEContact getLegalEntityContact(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getLegalEntityNamesForRole(final DSConnection arg0,
            final String arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getLegalEntityNamesFromLegalEntityIds(final DSConnection arg0,
            final List<Integer> arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getLegalEntityTolerances(final DSConnection ds, final int leId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LiquidationConfig getLiquidationConfig(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LiquidationInfo getLiquidationInfo(final DSConnection ds,
            final int bookId, final String productType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LiquidationInfo getLiquidationInfo(final DSConnection dsconnection,
            final int i, final String s,
            final LiquidationConfig liquidationconfig) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public List<LiquidationInfo> getLiquidationInfos(
            final DSConnection dsconnection, final int i, final String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ManualSDI getManualSDI(final DSConnection ds, final int id) {

        return (ManualSDI) this.cache.get(SDI + id);
    }

    @Override
    public MarginCallConfig getMarginCallConfig(final DSConnection ds,
            final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Mark getMark(final DSConnection ds, final int tradeId,
            final String pricingEnvName, final JDate valDate,
            final String pricerMeasure) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public MessageGroup getMessageGroupByName(final DSConnection dsconnection,
            final String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getMessageGroups(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getMessageRules(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getMessageRulesByLegalEntityId(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getMessageTaskWorkflowConfigHash(final DSConnection ds,
            final String productType, final String messageType,
            final LegalEntity processingOrg) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ArrayList getMessageWorkflow(final DSConnection ds,
            final String productType, final String messageType,
            final LegalEntity processingOrg, final Status status) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public HashMap getNettingConfig(final String nettingType,
            final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public NettingMethod getNettingMethod(final DSConnection dsconnection,
            final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public NettingMethod getNettingMethod(final String currency,
            final String instType, final int legalEntityId,
            final String legalEntityRole, final int processingOrgId,
            final String method, final JDate valDate, final Trade trade,
            final TradeTransferRule rule, final DSConnection dsCon) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getNettingMethods(final DSConnection dsCon,
            final int legalEntityId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getNettingMethods(final String s, final String s1,
            final int i, final String s2, final int j, final String s3,
            final JDate jdate, final Trade trade,
            final TradeTransferRule tradetransferrule,
            final DSConnection dsconnection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getPaymentTaskWorkflowConfigHash(final DSConnection ds,
            final String productType, final LegalEntity processingOrg) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ArrayList getPaymentWorkflow(final DSConnection ds,
            final String productType, final String workflowType,
            final LegalEntity processingOrg, final Status status) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PeriodDistribution getPeriodDistribution(final DSConnection arg0,
            final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @Override
    public PositionAggregation getPositionAggregation(final DSConnection ds,
            final int aggId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionAggregationConfig getPositionAggregationConfig(
            final DSConnection dsconnection, final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getPositionAggregationConfigs(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getPositionAggregationConfigs(final DSConnection ds,
            final String positionType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getPositionAggregationConfigs(final DSConnection ds,
            final String positionType, final int bookId,
            final String productType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getPositionAggregations(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionCash getPositionCash(final DSConnection ds,
            final PositionCash pc) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionFXNDF getPositionFXNDF(final DSConnection dsconnection,
            final String s, final String s1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionInfo getPositionInfo(final DSConnection ds,
            final int bookId, final String productType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PositionSpec getPositionSpec(final DSConnection arg0, final int arg1) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getPositionSpecs(final DSConnection arg0) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getPricerMeasureClassNames(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getPricerMeasureIds(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PricingFallbackStrategy getPricingFallbackStrategy(
            final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PricingParameters getPricingParameters(
            final DSConnection dsconnection, final String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public PricingParamType getPricingParamType(final DSConnection ds,
            final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LegalEntity getProcessingOrg(final DSConnection ds, final Book book) {

        Book bookTemp = new Book();
        bookTemp = (Book) this.cache.get(BOOK + book.getId());
        return bookTemp.getLegalEntity();
    }

    @Override
    public LegalEntity getProcessingOrg(final DSConnection ds, final int bookId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getProductsFromPLPosition(final DSConnection ds,
            final TradeFilter pfol, final boolean useCache) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ProductVariable getProductVariable(final DSConnection ds,
            final String name, final String productClass) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getProductVariables(final DSConnection ds,
            final String productClass) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public String getProperty(final DSConnection ds, final String user,
            final String prop) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getPropertyColumns(final DSConnection ds, final String user,
            final String prop) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public QuotableVariable getQuotableVariable(final DSConnection ds,
            final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getQuotableVariables(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public QuoteValue getQuote(final DSConnection ds, final QuoteValue qv) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getQuotes() {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Set getQuotes(final DSConnection ds, final Set quotesToBeFound) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getQuotesFromPLPosition(final DSConnection ds,
            final TradeFilter pfol, final JDate date, final String quoteSetName) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ReferenceEntity getReferenceEntity(final DSConnection ds,
            final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public LERegistration getRegistration(final String role,
            final LegalEntity le, final int agentId, final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getRepoCollaterals(final DSConnection ds, final int repoId) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ReportTemplate getReportTemplate(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public ReportTemplate getReportTemplate(final DSConnection ds,
            final String type, final ReportTemplateName name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getReportTemplateNames(final DSConnection ds,
            final String type, final String userName) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public List<String> getSDFilterNamesForGroups(final DSConnection arg0,
            final boolean arg1, final List<String> arg2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getSenderConfig(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public SettleDeliveryInstruction getSettleDeliveryInstruction(
            final DSConnection ds, final int id) {
        return (SettleDeliveryInstruction) this.cache.get(SDI + id);
    }

    @Override
    public SettleDeliveryInstruction getSettleDeliveryInstruction(
            final DSConnection ds, final int id, final int version) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getSettlementMessageSendings(final DSConnection ds,
            final String settleMethod) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getSettlementMethods(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public StaticDataFilter getStaticDataFilter(final DSConnection ds,
            final String filterSet) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public TaskConfig getTaskConfig(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getTaskInternalRefs(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getTaskPriorities(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public TaskWorkflowConfig getTaskWorkflowConfig(final DSConnection ds,
            final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getTaskWorkflowConfigHash(final DSConnection ds,
            final String objType, final LegalEntity processingOrg) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public TemplateInfo getTemplate(final DSConnection ds,
            final String productType, final String name, final String user) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public TemplateDefaults getTemplateDefaults(final DSConnection ds,
            final String user) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Ticker getTicker(final DSConnection ds, final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Ticker getTicker(final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Ticker getTickerFromCache(final int id) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Ticker getTickerFromCache(final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public int getTimeToLive(final String cacheName, final DSConnection ds) {

        return 0;
    }

    @Override
    public TradeBundle getTradeBundle(final DSConnection dsconnection,
            final int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getTradeBundles(final DSConnection ds,
            final String bundleName, final String bundleType) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public TradeFilter getTradeFilter(final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Hashtable getTradeTaskWorkflowConfigHash(final DSConnection ds,
            final String productType, final String subType,
            final LegalEntity processingOrg) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ArrayList getTradeWorkflow(final DSConnection ds,
            final String productType, final String subType,
            final LegalEntity processingOrg, final Status status) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public String getUsername(final String s) {
        return (String) this.cache.get("UserName." + s);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector getUserWorkflowConfigs(final DSConnection ds) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public VegaWeights getVegaWeights(final DSConnection ds, final String name) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public WithholdingTaxAttribute getWithholdingTaxAttribute(
            final DSConnection arg0, final int arg1, final int arg2,
            final String arg3, final String arg4, final int arg5,
            final String arg6, final JDate arg7) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
        // throw new
        // UnsupportedOperationException("TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ArrayList getWorkflow(final DSConnection ds,
            final String objectType, final LegalEntity processingOrg,
            final Status status) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getWorkflowConfigArray(final LegalEntity legalentity,
            final WorkFlowConfigKey workflowconfigkey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public ArrayList getWorkflowConfigArray(final String eventClass,
            final LegalEntity processingOrg, final String type,
            final String productType, final Status status) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void insertPositionCash(final PositionCash pc) {

    }

    @Override
    public boolean isRatingCached(final CreditRating cr) {

        return false;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector lookupValidFundingRates(final DSConnection ds,
            final Trade trade, final String currency, final JDate valDate) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventAdmin event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventCreditRating event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventDomainChange event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection dsconnection,
            final PSEventProductCreditRating pseventproductcreditrating) {
        // TODO Auto-generated method stub

    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventQuote event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventQuoteRemoved event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void newEvent(final DSConnection ds, final PSEventStatement event) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void putLegalEntityAttributesInCache(final int leId, final Vector v) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void putLEInCache(final Vector v) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void putMarkInCache(final Mark mark) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void putRatingInCache(final CreditRating key,
            final CreditRating value) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public void putRatingInNotFoundCache(final CreditRating rating) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void putTickersInCache(final Vector v) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    public void remove(final Book book) {
        this.cache.remove(BOOK + book.getId());
        this.cache.remove(BOOK + book.getName());

    }

    public void remove(final LegalEntity le) {
        this.cache.remove(LEGAL_ENTITY + le.getId());
        this.cache.remove(LEGAL_ENTITY + le.getCode());
    }

    public void remove(final SDI sdi) {
        this.cache.remove(SDI + sdi.getId());
    }

    public void setDomainValueComment(final String s1, final String s2,
            final String s3) {
        this.cache.put(DOMAIN_VALUE_COMMENT + s1 + "." + s2, s3);
    }

    @Override
    public void setIsCaching(final boolean v) {
        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

    @Override
    public Auditable undo(final DSConnection ds, final Auditable auditable,
            final int objectId, final String className, final int version) {

        throw new UnsupportedOperationException(
                "TODO Auto-generated method stub");
    }

}
