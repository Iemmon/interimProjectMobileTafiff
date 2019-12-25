package mobileConnection.model.entity.tariff;

public class FamilyTariff extends BasicTariff {

    double costOfCallInsideNetwork;

    public FamilyTariff(String name, double costOfMinute, double costOfSMS, double costOfMb, int fee, double costOfCallInsideNetwork) {
        super(name, costOfMinute, costOfSMS, costOfMb, fee);
        this.costOfCallInsideNetwork = costOfCallInsideNetwork;
    }
}
