package src.lld.pg;

import java.util.HashMap;
import java.util.Map;

public class PgFactory {
    static Map<PgEnum, PGs> mp= new HashMap<>();

    PgFactory() {
        PgEnum[] values = PgEnum.values();
        // fill map and put all pgs in map
    }

    public static void doTxn(PgEnum pgEnum, PMEnum paymentMethod) {
        PGs pgs = mp.get(pgEnum);
        switch (paymentMethod) {
            case Wallet:
                pgs.wallet();
                break;
            case CC:
                pgs.creditCard();
                break;
            case DB:
                pgs.debitCard();
                break;
            default:
                break;
        }
    }

//    delete from map
}
