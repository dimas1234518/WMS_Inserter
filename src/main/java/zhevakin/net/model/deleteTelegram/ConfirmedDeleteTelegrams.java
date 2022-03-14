package zhevakin.net.model.deleteTelegram;

import zhevakin.net.model.TelegramImpl;
import zhevakin.net.enums.TypeTelegrams;

public class ConfirmedDeleteTelegrams extends TelegramImpl {

    private String StornOk = "1";
    private final String AufWwsBeleg;
    private final String AufRefNr;

    @Override
    public String toString() {
        return "|MsgNam="+MsgNam +
               "|VersionsNr="+VersionsNr+
               "|TrxId="+TrxId+
               "|MndNr="+MndNr+
               "|Werk="+Werk+
               "|AufNr="+AufNr+
               "|StornOk="+StornOk+
               "|AufWwsBeleg="+AufWwsBeleg+
               "|AufRefNr="+AufRefNr+
               "|";
    }

    public ConfirmedDeleteTelegrams(String trxId, String aufNr) {
        super(trxId, aufNr, TypeTelegrams.CONFIRMED_DELETE_TELEGRAM.toString());
        AufWwsBeleg = "Z000337" + aufNr;
        AufRefNr = aufNr;

    }
}
