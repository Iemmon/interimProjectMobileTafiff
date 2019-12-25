package mobileConnection.model.entity.tariff;

public class PremiumTariff extends BasicTariff{

    private boolean isUnlimitedCalls;
    private boolean isUnlimitedInternet;

    public PremiumTariff(String name, double costOfSMS, int fee) {
        super(name,0, costOfSMS, 0, fee);
        this.isUnlimitedCalls = true;
        this.isUnlimitedInternet = true;
    }
}
