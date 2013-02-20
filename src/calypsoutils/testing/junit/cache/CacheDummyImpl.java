package calypsoutils.testing.junit.cache;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import com.calypso.tk.core.Book;
import com.calypso.tk.core.LegalEntity;
import com.calypso.tk.refdata.Account;
import com.calypso.tk.refdata.CurrencyDefault;
import com.calypso.tk.refdata.FXOptExpTZ;
import com.calypso.tk.refdata.LEContact;
import com.calypso.tk.refdata.LegalEntityAttribute;
import com.calypso.tk.refdata.PartySDI;
import com.calypso.tk.refdata.SDI;

public abstract class CacheDummyImpl {

    protected final HashMap<String, Object> cache;
    protected Hashtable<String, Object> currencyDefaults;

    public CacheDummyImpl() {
        this.cache = new HashMap<String, Object>();

    }

    public final void add(final Account account) {
        this.cache.put(CacheTypesEnum.ACCOUNT.toString() + account.getId(),
                account);
    }

    public final void add(final Book book) {
        this.cache.put(CacheTypesEnum.BOOK.toString() + book.getId(), book);
        this.cache.put(CacheTypesEnum.BOOK + book.getName(), book);
    }

    public void add(final CurrencyDefault cd) {
        this.cache.put(CacheTypesEnum.CURRENCY + cd.getCode(), cd);

    }

    public final void add(final FXOptExpTZ expTimeZone, final String time) {
        this.cache.put(
                CacheTypesEnum.EXPIRY_TZ_VALUES + expTimeZone.getTimeStr()
                        + "_" + time, expTimeZone);
    }

    public void add(final LEContact contact) {
        this.cache.put(
                CacheTypesEnum.LECONTACT.toString()
                        + contact.getLegalEntityId(), contact);
    }

    public void add(final LegalEntity le) {
        this.cache
                .put(CacheTypesEnum.LEGAL_ENTITY.toString() + le.getId(), le);
        this.cache.put(CacheTypesEnum.LEGAL_ENTITY + le.getCode(), le);
        this.cache.put(CacheTypesEnum.LEGAL_ENTITY.toString() + le.getId()
                + CacheTypesEnum.COUNTRY, le.getCountry());
        this.cache.put(CacheTypesEnum.LEGAL_ENTITY + le.getCode()
                + CacheTypesEnum.COUNTRY, le.getCountry());
        this.cache.put(CacheTypesEnum.LEGAL_ENTITY.toString() + le.getId()
                + CacheTypesEnum.ATTRIBUTES, le.getLegalEntityAttributes());
        this.cache.put(CacheTypesEnum.LEGAL_ENTITY + le.getCode()
                + CacheTypesEnum.ATTRIBUTES, le.getLegalEntityAttributes());

    }

    public void add(final LegalEntityAttribute lea) {
        this.cache.put(CacheTypesEnum.LEA.toString() + lea.getLegalEntityId()
                + "." + lea.getAttributeType(), lea);
    }

    public void add(final PartySDI partySDI) {
        this.cache.put(
                CacheTypesEnum.PARTY_SDI.toString() + partySDI.getPartyId(),
                partySDI);
    }

    public void add(final SDI sdi) {
        this.cache.put(CacheTypesEnum.SDI.toString() + sdi.getId(), sdi);
    }

    public void add(final Vector<String> domainValues, final String domainName) {
        this.cache.put(CacheTypesEnum.DOMAIN_VALUES.toString() + domainName,
                domainValues);
    }

    public void addCountryISOCode(final String country, final String isoCode) {
        this.cache.put(CacheTypesEnum.COUNTRY + country, isoCode);
    }

    public void addCurrencyDefault(final String currency,
            final CurrencyDefault cd) {
        this.cache.put(CacheTypesEnum.CURRENCY + currency, cd);
    }

    public void addDomainValueComment(final String domainName,
            final String domainValue, final String comment) {
        this.cache.put(CacheTypesEnum.DOMAIN_VALUE_COMMENT + domainName + "."
                + domainValue, comment);
    }

    public void addLongName(final String longName, final PartySDI partySDI) {
        this.cache.put(
                CacheTypesEnum.LONG_NAME.toString() + partySDI.getPartyId(),
                longName);
    }

    public void addUserName(final String s) {
        this.cache.put("UserName." + s, s);
    }

    public void clear() {
        this.cache.clear();
    }

}