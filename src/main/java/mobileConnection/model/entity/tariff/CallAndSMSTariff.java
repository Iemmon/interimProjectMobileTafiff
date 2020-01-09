package mobileConnection.model.entity.tariff;

public class CallAndSMSTariff extends BasicTariff {

    private double discount;

    public CallAndSMSTariff(String name, double costOfMinute, double costOfSMS, double costOfMb, int fee, double discount) {
        super(name,costOfMinute*discount, costOfSMS*discount, costOfMb, fee);
    }
}
