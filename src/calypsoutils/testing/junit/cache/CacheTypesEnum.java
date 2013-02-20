package calypsoutils.testing.junit.cache;

/**
 * Contains some constants used when storing the data in the cache
 * 
 */
public enum CacheTypesEnum {
    ACCOUNT("Account."), LECONTACT("LEContact."), SDI("SDI."), LEA(
            "LegalEntityAttribute."), LEGAL_ENTITY("LegalEntity."), BOOK(
            "Book."), CURRENCY("Currency."), PARTY_SDI("PartySDI."), LONG_NAME(
            "LongName."), DOMAIN_VALUES("DomainValues."), DOMAIN_VALUE_COMMENT(
            "DomainValueComment."), EXPIRY_TZ_VALUES("ExpiryTZValues."), COUNTRY(
            "Country"), ATTRIBUTES("Attributes");

    private String value;

    /**
     * Default constructor
     * 
     * @param newValue
     *            string value of the enumerated element
     */
    CacheTypesEnum(final String newValue) {
        this.value = newValue;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
