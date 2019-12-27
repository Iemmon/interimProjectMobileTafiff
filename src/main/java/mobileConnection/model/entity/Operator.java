package mobileConnection.model.entity;

import mobileConnection.model.TariffFilter;
import mobileConnection.model.entity.tariff.BasicTariff;

import java.time.LocalDateTime;
import java.util.*;

public class Operator {

    private String name;
    final List<BasicTariff> tariffs;
    final List<SimCard> soldSimCards;
    private DataPlacer dataPlacer;

    public Operator(String companyName) {
        dataPlacer = new DataPlacer();
        this.name = companyName;

        this.tariffs = new ArrayList<>(dataPlacer.getTariffs());
        this.soldSimCards = new ArrayList<>(dataPlacer.getSimCards());
    }

    public boolean addTariff(BasicTariff tariff) {
        return tariffs.add(tariff);
    }

    public SimCard sellSim(BasicTariff tariff) {
        SimCard sim = new SimCard(tariff);
        soldSimCards.add(sim);
        return sim;
    }

    public int getNumOfClientsByTariff(String tariffName) {
        int result = 0;
        for (SimCard sim : soldSimCards) {
            if (sim.getTariff().getName().equalsIgnoreCase(tariffName)) {
                result++;
            }
        }
        return result;
    }

    static class SimCard {
        private BasicTariff tariff;
        private LocalDateTime dateOfConnection;

        public SimCard(BasicTariff tariff) {
            this.tariff = tariff;
            dateOfConnection = LocalDateTime.now();
        }

        public BasicTariff getTariff() {
            return tariff;
        }
    }

    public Optional<BasicTariff> getTariffByName(String name) {
        for (BasicTariff t : tariffs) {
            if (t.getName().equalsIgnoreCase(name)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public List<BasicTariff> getTariffs() {
        return tariffs;
    }

    public TariffFilter getFilter() {
        return new TariffFilter(tariffs);
    }


}
