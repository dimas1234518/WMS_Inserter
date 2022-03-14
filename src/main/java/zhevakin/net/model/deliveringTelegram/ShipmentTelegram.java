package zhevakin.net.model.deliveringTelegram;

import zhevakin.net.enums.TypeTelegrams;
import zhevakin.net.model.TelegramImpl;

public class ShipmentTelegram extends TelegramImpl {
    public ShipmentTelegram(String trxId, String aufNr) {
        super(trxId, aufNr, TypeTelegrams.SHIPMENT_TELEGRAM.toString());
    }

    @Override
    public String toString() {
        return "|MsgNam="+MsgNam+
               "|VersionsNr="+VersionsNr+
               "|TrxId="+TrxId+
               "|PalNam="+AufNr+
               "|";
    }
}
