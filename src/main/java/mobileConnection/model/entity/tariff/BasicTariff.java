package mobileConnection.model.entity.tariff;

public class BasicTariff {
    private String name;
    protected double costPerMinute;
    protected double costOfSMS;
    protected double costOfMb;
    private int fee;

    public BasicTariff(String name, double costPerMinute, double costOfSMS, double costOfMb, int fee) {
        this.name = name;
        this.costPerMinute = costPerMinute;
        this.costOfSMS = costOfSMS;
        this.costOfMb = costOfMb;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public int getFee() {
        return fee;
    }

    public double getCostPerMinute() {
        return costPerMinute;
    }

    public double getCostOfSMS() {
        return costOfSMS;
    }

    public double getCostOfMb() {
        return costOfMb;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "costPerMinute: " + costPerMinute + "\n" +
                "costOfSMS: " + costOfSMS + "\n" +
                "costOfMb: " + costOfMb + "\n" +
                "fee: " + fee;
    }
}
