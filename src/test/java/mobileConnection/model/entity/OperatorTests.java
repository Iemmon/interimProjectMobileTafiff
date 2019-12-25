package mobileConnection.model.entity;

import mobileConnection.model.entity.tariff.BasicTariff;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperatorTests {
private Operator operator;
    BasicTariff one;
    BasicTariff two;
    BasicTariff three;
    BasicTariff four;

    Operator.SimCard simOne;
    Operator.SimCard simTwo;
    Operator.SimCard simThree;
    Operator.SimCard simFour;
    Operator.SimCard simFive;

    @Before
    public void setup(){
        operator = new Operator("life");

        one = new BasicTariff("1", 2,3,0,5);
        two = new BasicTariff("2", 0,3,5,50);
        three = new BasicTariff("3", 90,0,6,0);
        four = new BasicTariff("4", 999999,999999,999999,99999);

        operator.addTariff(one);
        operator.addTariff(two);
        operator.addTariff(three);
        operator.addTariff(four);

        simOne = operator.sellSim(one);
        simTwo = operator.sellSim(one);
        simThree = operator.sellSim(two);
        simFour = operator.sellSim(three);
        simFive = operator.sellSim(four);


    }

    @Test
    public void testGetTariffByName() {

        assertEquals(Optional.of(two), operator.getTariffByName("2"));
    }

    @Test
    public void testGetTariffByUnknownName() {

        assertEquals(Optional.empty(), operator.getTariffByName("Unknown"));
    }

    @Test
    public void testSellSimCardTest() {

        assertEquals(5, operator.soldSimCards.size());
        assertTrue(operator.soldSimCards.contains(simOne));
    }

    @Test
    public void testGetNumOfClientsByTariff() {
        assertEquals(2, operator.getNumOfClientsByTariff("1"));
        assertEquals(1, operator.getNumOfClientsByTariff("2"));
        assertEquals(1, operator.getNumOfClientsByTariff("3"));
        assertEquals(1, operator.getNumOfClientsByTariff("4"));
    }

    @Test
    public void testGetNumOfClientsByUnknownTariff() {

        assertEquals(0, operator.getNumOfClientsByTariff("Unknown"));
    }
}
