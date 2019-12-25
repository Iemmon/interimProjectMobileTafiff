package mobileConnection.model.entity.tariff;

public enum TariffField {
    SMS("sms"),
    MINUTE("call"),
    MB("mb"),
    FEE("fee");

    String value;

    TariffField(String value) {
        this.value = value;
    }
}
