package mobileConnection.model;

import mobileConnection.model.entity.Operator;
import mobileConnection.model.entity.tariff.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TariffModel {
    Operator operator;

    public void createOperator(String name) {
        this.operator = new Operator(name);
        operator.addTariff(new CallAndSMSTariff("Молодежный!", 15, 10, 25, 940, 0.5));
        operator.addTariff(new BusinessTariff("Бизнес", 15, 15, 40, 1250));
        operator.addTariff(new BusinessTariff("Большой Босс", 10, 12, 45, 1060));
        operator.addTariff(new DigitalTariff("Диджитал Офис", 25, 25, 1200));
        operator.addTariff(new FamilyTariff("Вместе", 10, 5, 1.5, 80, 0.2));
        operator.addTariff(new PremiumTariff("Все включено", 0.4, 500));
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

    public boolean createTariff(String name, String sms, String minute, String mb, String fee) {
        return operator.addTariff(
                new BasicTariff(name, Double.parseDouble(minute),
                        Double.parseDouble(sms),
                        Double.parseDouble(mb),
                        Integer.parseInt(fee)
                )
        );
    }

    public boolean deleteTariff(String name) {
        Optional<BasicTariff> tariff = operator.getTariffByName(name);
        if (tariff.isPresent())
            return operator.getTariffs().remove(tariff.get());
        return false;
    }

    public Operator getOperator() {
        return operator;
    }
}
