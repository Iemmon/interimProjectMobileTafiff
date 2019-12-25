package mobileConnection.model.entity.tariff;

public class DigitalTariff extends BasicTariff {

    public DigitalTariff(String name, double costOfMinute, double costOfSMS, int fee) {
        super(name, costOfMinute, costOfSMS, 0, fee);

    }
}
