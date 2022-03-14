package zhevakin.net.model.deliveringTelegram;

import zhevakin.net.enums.TypeTelegrams;
import zhevakin.net.model.TelegramImpl;

public class DeliveringTopTelegram extends TelegramImpl {

    private final String AufWwsBeleg;
    private final String ClickAndCollect;

    public DeliveringTopTelegram(String trxId, String aufNr, String clickAndCollect) {
        super(trxId, aufNr, TypeTelegrams.DELIVERING_TOP_TELEGRAM.toString());
        AufWwsBeleg = "Z000337" + aufNr;
        this.ClickAndCollect = clickAndCollect;

    }

    // TODO: StringBuilder
    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        return "|MsgNam=" + MsgNam +
               "|VersionsNr=" + VersionsNr +
               "|TrxId=" + TrxId +
               "|AufNr=" + AufNr +
               "|AufWwsBeleg=" + AufWwsBeleg +
               "|ClickAndCollect=" + ClickAndCollect +
               "|" ;
    }

    // |MsgNam=WMS.AUFSHP|VersionsNr=1|TrxId=38093922|AufNr=ARS000001072382|AufWwsBeleg= J7QPH|

}
