package mobileConnection.model;

import mobileConnection.model.entity.Operator;
import mobileConnection.model.entity.tariff.BasicTariff;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TariffFilterTests {

    Operator operator;

    BasicTariff one;
    BasicTariff two;
    BasicTariff three;
    BasicTariff four;

    TariffFilter filter;

    @Before
    public void setup() {
        TariffModel tariffModel = new TariffModel();
        operator = tariffModel.getOperator();

        one = new BasicTariff("1", 2, 3, 0, 5);
        two = new BasicTariff("2", 0, 3, 5, 50);
        three = new BasicTariff("3", 90, 0, 6, 0);
        four = new BasicTariff("4", 999999, 999999, 999999, 99999);

        operator.addTariff(one);
        operator.addTariff(two);
        operator.addTariff(three);
        operator.addTariff(four);

        filter = operator.getFilter();
    }
//
//    @Test
//    public void testGetByFee() {
//
//        List<BasicTariff> result = filter.getByFee(0, 50).getTariffs();
//        assertEquals(result, Arrays.asList(one, two, three));
//    }
//
//    @Test
//    public void testGetByMbCost() {
//        List<BasicTariff> result = filter.getByMbCost(1000, Integer.MAX_VALUE).getTariffs();
//        assertEquals(result, Arrays.asList(four));
//    }
//
//    @Test
//    public void testGetByCallCost() {
//        List<BasicTariff> result = filter.getByCallCost(0, 3).getTariffs();
//        assertEquals(Arrays.asList(one, two), result);
//    }
//
//    @Test
//    public void testGetBySMSCost() {
//        List<BasicTariff> result = filter.getBySMSCost(Integer.MIN_VALUE, Integer.MAX_VALUE).getTariffs();
//        assertEquals(Arrays.asList(one, two, three, four), result);
//    }

}
