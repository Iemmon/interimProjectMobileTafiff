package mobileConnection.model.entity;

import mobileConnection.model.entity.tariff.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataPlacer {
    private List<BasicTariff> tariffs;
    private List<Operator.SimCard> simCards;
    private String operatorName;


   DataPlacer(){
        tariffs = setUpTariffs();
        simCards = setUpSimCards();
        operatorName = "MTS";
    }

    private List<BasicTariff> setUpTariffs(){
        List<BasicTariff> listOfTariffs = new ArrayList<>();

        listOfTariffs.add(new CallAndSMSTariff("Молодежный!", 15, 10, 25, 940, 0.5));
        listOfTariffs.add(new BusinessTariff("Бизнес", 15, 15, 40, 1250));
        listOfTariffs.add(new BusinessTariff("Большой Босс", 10, 12, 45, 1060));
        listOfTariffs.add(new DigitalTariff("Диджитал Офис", 25, 25, 1200));
        listOfTariffs.add(new FamilyTariff("Вместе", 10, 5, 1.5, 80, 400));
        listOfTariffs.add(new PremiumTariff("Все включено", 0.4, 800));

        return listOfTariffs;
    }

    private List<Operator.SimCard> setUpSimCards(){
        List<Operator.SimCard> simCardList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 30; i++) {
            simCardList.add(new Operator.SimCard(tariffs.get(random.nextInt(tariffs.size()))));
        }
        return simCardList;
    }

    List<BasicTariff> getTariffs() {
        return tariffs;
    }

    List<Operator.SimCard> getSimCards() {
        return simCards;
    }

    String getOperatorName() {
        return operatorName;
    }
}
