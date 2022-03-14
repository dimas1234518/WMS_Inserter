package zhevakin.net.model.deliveringTelegram;

import zhevakin.net.enums.TypeTelegrams;
import zhevakin.net.model.TelegramImpl;

public class DeliveringBotTelegram extends TelegramImpl {
    public DeliveringBotTelegram(String trxId, String aufNr) {
        super(trxId, aufNr, TypeTelegrams.DELIVERING_BOT_TELEGRAM.toString());
    }

    @Override
    public String toString() {
        return "|MsgNam=" + MsgNam +
               "|VersionsNr=" + VersionsNr +
               "|TrxId=" + TrxId +
               "|AufNr=" + AufNr +
               "|" ;
    }
}

//|MsgNam=WMS.AUFSHPABSCHL|VersionsNr=1|TrxId=38093922|AufNr=ARS000001072382|
