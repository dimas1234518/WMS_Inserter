package zhevakin.net.model.aufTelegram;

import zhevakin.net.model.TelegramImpl;
import zhevakin.net.enums.TypeTelegrams;

public class TopTelegram extends TelegramImpl {

    String AufRefNr;
    String AufStatus;
    String AufWwsBeleg;


    public TopTelegram(String trxId, String aufNr, String aufRefNr, String aufStatus, String aufWwsBeleg) {
        super(trxId, aufNr, TypeTelegrams.TOP_TELEGRAM.toString());
        AufRefNr = aufRefNr;
        AufStatus = aufStatus;
        AufWwsBeleg = aufWwsBeleg;
    }

    @Override
    public String toString() {
        return  "|MsgNam=" + MsgNam +
                "|VersionsNr=" + VersionsNr +
                "|TrxId=" + TrxId +
                "|MndNr=" + MndNr +
                "|Werk=" + Werk +
                "|AufNr=" + AufNr +
                "|AufRefNr=" + AufRefNr +
                "|AufWwsBeleg=" + AufWwsBeleg +
                "|AufStatus=" + AufStatus +
                "|";

    }
}
