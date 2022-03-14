package zhevakin.net.model.aufTelegram;

import zhevakin.net.model.TelegramImpl;
import zhevakin.net.enums.TypeTelegrams;

public class MiddleTelegram extends TelegramImpl {

    private final String AupNr;
    private final String AupMgSoll;
    private final String AupMgFehl;
    private final String AupMgIst;
    private final String AupMgEhWws;
    private final String ArtNr;

    public MiddleTelegram(String trxId, String aufNr, String aupNr, String aupMgSoll, String aupMgFehl, String aupMgIst,
                          String aupMgEhWws, String artNr) {
        super(trxId, aufNr, TypeTelegrams.MIDDLE_TELEGRAM.toString());
        AupNr = aupNr;
        AupMgSoll = aupMgSoll;
        AupMgFehl = aupMgFehl;
        AupMgIst = aupMgIst;
        AupMgEhWws = aupMgEhWws;
        ArtNr = artNr;
    }

    @Override
    public String toString() {
        return  "|MsgNam=" + MsgNam +
                "|VersionsNr=" + VersionsNr +
                "|TrxId=" + TrxId +
                "|MndNr=" + MndNr +
                "|Werk=" + Werk +
                "|AufNr=" + AufNr +
                "|AupNr=" + AupNr +
                "|AupMgSoll=" + AupMgSoll +
                "|AupMgIst=" + AupMgIst +
                "|AupMgFehl=" + AupMgFehl +
                "|AupMgEhWws=" + AupMgEhWws +
                "|ArtNr=" + ArtNr +
                "|";
    }
}
