package mobileConnection.model;

import mobileConnection.model.entity.Operator;
import mobileConnection.model.entity.tariff.BasicTariff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TariffModelTests {

    TariffModel model;

    BasicTariff one;
    BasicTariff two;
    BasicTariff three;
    BasicTariff four;

    @Before
    public void setup(){
        model = new TariffModel();
        model.createOperator("life");

        Operator operator = model.getOperator();

        operator.getTariffs().clear();

        one = new BasicTariff("1", 2,3,0,5);
        two = new BasicTariff("2", 0,3,5,50);
        three = new BasicTariff("3", 90,0,6,0);
        four = new BasicTariff("4", 999999,999999,999999,99999);

        operator.addTariff(one);
        operator.addTariff(two);
        operator.addTariff(three);
        operator.addTariff(four);
    }

    @Test
    public void testDeleteTariff() {

        String oneName = one.getName();

        model.deleteTariff(oneName);

        assertEquals(Arrays.asList(two, three, four), model.getOperator().getTariffs());
    }

    @Test
    public void testSortTariffByFee() {
        List<BasicTariff> result = model.sortTariffByFee();

        assertEquals(Arrays.asList(three, one, two, four), result);
    }
}
