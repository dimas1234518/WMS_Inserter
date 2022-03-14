package zhevakin.net.model;

public class TelegramImpl implements Telegram{

    protected String MsgNam;
    protected String TrxId;
    protected String AufNr;

    public TelegramImpl(String trxId, String aufNr, String msgNam) {
        TrxId = trxId;
        AufNr = aufNr;
        MsgNam = msgNam;
    }

    @Override
    public String getMsgNam() {
        return MsgNam;
    }

    @Override
    public String getTrxId() {
        return TrxId;
    }

    @Override
    public String getAufNr() {
        return AufNr;
    }
}
