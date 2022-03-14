package zhevakin.net.enums;

public enum TypeTelegrams {

    TOP_TELEGRAM("WMS.ECOMAUFSTAT",1),
    MIDDLE_TELEGRAM("WMS.ECOMAUPSTAT",2),
    BOT_TELEGRAM("WMS.ECOMAUFSTATABSCHL",3),
    CONFIRMED_DELETE_TELEGRAM("WMS.AUFSTORNQUIT", 4),
    DELIVERING_TOP_TELEGRAM("WMS.AUFSHP",5),
    DELIVERING_MIDDLE_TELEGRAM("WMS.AUPSHP",6),
    DELIVERING_BOT_TELEGRAM("WMS.AUFSHPABSCHL",7),
    SHIPMENT_TELEGRAM("WMS.AUFSHPPAL",8);

    final private String name;
    final private int value;

    TypeTelegrams(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

}
