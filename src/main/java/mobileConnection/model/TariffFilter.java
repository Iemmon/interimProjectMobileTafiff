package mobileConnection.model;

import mobileConnection.model.entity.tariff.BasicTariff;
import mobileConnection.model.entity.tariff.TariffField;

import java.util.ArrayList;
import java.util.List;

public class TariffFilter<T extends BasicTariff> {

    List<T> tariffs;

    public TariffFilter(List<T> tariffs) {
        this.tariffs = tariffs;
    }

    public TariffFilter getByFee(int min, int max) {
        List<T> result = new ArrayList<>();
        for (T t : tariffs) {
            if (t.getFee() >= min && t.getFee() <= max) {
                result.add(t);
            }
        }
        return new TariffFilter(result);
    }

    public TariffFilter getBySMSCost(int min, int max) {
        List<T> result = new ArrayList<>();
        for (T t : tariffs) {
            if (t.getCostOfSMS() >= min && t.getCostOfSMS() <= max) {
                result.add(t);
            }

        }
        return new TariffFilter(result);
    }

    public TariffFilter getByCallCost(int min, int max) {
        List<T> result = new ArrayList<>();
        for (T t : tariffs) {
            if (t.getCostPerMinute() >= min && t.getCostPerMinute() <= max) {
                result.add(t);
            }
        }
        return new TariffFilter(result);
    }

    public TariffFilter getByMbCost(int min, int max) {
        List<T> result = new ArrayList<>();
        for (T t : tariffs) {
            if (t.getCostOfMb() >= min && t.getCostOfMb() <= max) {
                result.add(t);
            }
        }
        return new TariffFilter(result);
    }


    public TariffFilter getTariffsByParameter(String input, int min, int max) {

        switch (TariffField.valueOf(input)) {
            case FEE:
                return getByFee(min, max);
            case SMS:
                return getBySMSCost(min, max);
            case MINUTE:
                return getByCallCost(min, max);
            case MB:
                return getByMbCost(min, max);
        }

        return new TariffFilter(new ArrayList());
    }

    public List<T> getTariffs() {
        return tariffs;
    }
}
