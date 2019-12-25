package mobileConnection.model.entity.tariff;

public class BusinessTariff extends BasicTariff{

    public BusinessTariff(String name, double costOfMinute, double costOfSMS, double costOfMb, int fee) {
        super(name, costOfMinute, costOfSMS, costOfMb, fee);
    }
}
