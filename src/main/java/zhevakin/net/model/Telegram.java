package zhevakin.net.model;

import lombok.Data;

public interface Telegram {
    String VersionsNr = "1";
    String MndNr = "0001";
    String Werk = "0000";

    String getMsgNam();

    String getTrxId();

    String getAufNr();



}
