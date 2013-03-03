/**
 * 
 */
package calypsoutils.testing.testgenerator.generator.data;

import com.calypso.tk.bo.BOCre;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;

/**
 * A class which creates a BOCre object used in junit testing
 * 
 */
public class CreSample {
    public BOCre createCre() {
        final BOCre cre = new BOCre();

        cre.setId(6198);
        cre.setTradeId(39813);
        cre.setTransferId(20305);
        cre.setVersion(0);
        cre.setDescription("NONE");
        cre.setStatus("NEW");
        cre.setEventType("CST_NET_S_SETTLED");
        cre.setBookId(30398);
        cre.setProductId(44109);
        cre.setEffectiveDate(JDate.valueOf(2455873));
        cre.setTradeDate(JDate.valueOf(2455842));
        cre.setSettlementDate(JDate.valueOf(2455842));
        cre.setAllocatedSeed(0);
        cre.setBookingDate(JDate.valueOf(2455876));
        cre.setNettedTransferId(20305);
        cre.setLinkedId(0);
        cre.setTradeVersion(1);
        cre.setSubId(0);
        cre.setCreationDate(new JDatetime(1320921308494L));
        cre.setOriginalEventType("SETTLED_PAYMENT");
        cre.setAccountingRuleId(32995);
        cre.setMatchingProcess(true);
        cre.setEventConfigId(34910);
        cre.setHedgeId(0);
        cre.setUpdateTime(new JDatetime(1320921308509L));
        cre.setLinkedTradeId(0);
        cre.setCreType("NEW");

        return cre;
    }
}
