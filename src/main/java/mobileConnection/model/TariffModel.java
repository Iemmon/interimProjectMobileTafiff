package mobileConnection.model;

import mobileConnection.model.entity.Operator;
import mobileConnection.model.entity.tariff.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TariffModel {
    private Operator operator;

    public TariffModel() {
        operator = new Operator();
    }

    public List<BasicTariff> sortTariffByFee() {
        List<BasicTariff> result = new ArrayList<>(operator.getTariffs());
        result.sort(new Comparator<BasicTariff>() {
            @Override
            public int compare(BasicTariff t1, BasicTariff t2) {
                return t1.getFee() - t2.getFee();
            }
        });
        return result;
    }

    public void createTariff(String name, String sms, String minute, String mb, String fee) {
        operator.addTariff(
                new BasicTariff(name, Double.parseDouble(minute),
                        Double.parseDouble(sms),
                        Double.parseDouble(mb),
                        Integer.parseInt(fee)
                )
        );
    }

    public boolean deleteTariff(String name) {
        Optional<BasicTariff> tariff = operator.getTariffByName(name);
        return tariff.map(basicTariff -> operator.getTariffs().remove(basicTariff)).orElse(false);
    }

    public Operator getOperator() {
        return operator;
    }
}
