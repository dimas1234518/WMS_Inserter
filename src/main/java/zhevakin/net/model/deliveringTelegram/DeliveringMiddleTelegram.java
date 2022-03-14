package zhevakin.net.model.deliveringTelegram;

import zhevakin.net.enums.TypeTelegrams;
import zhevakin.net.model.TelegramImpl;

public class DeliveringMiddleTelegram extends TelegramImpl {

    private String AupNr;
    private final String AupMgIst = "1";
    private final String TeNam;
    private final String PalNam;
    private final String AupMgEhWws = "1";

    public DeliveringMiddleTelegram(String trxId, String aufNr, String AupNr) {
        super(trxId, aufNr, TypeTelegrams.DELIVERING_MIDDLE_TELEGRAM.toString());
        TeNam = aufNr + "99";
        PalNam = aufNr + "88";
        this.AupNr = AupNr;
    }

    @Override
    public String toString() {
        return "|MsgNam="+ MsgNam +
               "|VersionsNr=" + VersionsNr +
               "|TrxId=" + TrxId +
               "|AufNr=" + AufNr +
               "|AupNr=" + AupNr +
               "|AupMgEhWws=" + AupMgEhWws +
               "|AupMgIst=" + AupMgIst +
               "|TeNam=" + TeNam +
               "|PalNam=" + PalNam +
               "|" ;
    }

    // |MsgNam=WMS.AUPSHP|VersionsNr=1|TrxId=38093922|AufNr=ARS000001072382|AupNr=1|AupMgIst=1|TeNam=2000801329749|PalNam=3001000172320|
}
