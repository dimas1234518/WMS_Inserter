package zhevakin.net.model.aufTelegram;

import zhevakin.net.model.TelegramImpl;
import zhevakin.net.enums.TypeTelegrams;

public class BotTelegram extends TelegramImpl {

    public BotTelegram(String trxId, String aufNr) {
       super(trxId, aufNr, TypeTelegrams.BOT_TELEGRAM.toString());
    }

    @Override
    public String toString() {
        return  "|MsgNam=" + MsgNam +
                "|VersionsNr=" + VersionsNr +
                "|TrxId=" + TrxId +
                "|MndNr=" + MndNr +
                "|Werk=" + Werk +
                "|AufNr=" + AufNr +
                "|";

    }
}
