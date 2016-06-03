package org.sentsov.net;


import org.junit.Test;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static org.junit.Assert.*;
import static org.sentsov.net.BetterProgrammerTask.*;

/**
 * Created by Vladimir_Sentso on 02.06.2016.
 */
public class BetterProgrammerTest {


    @Test
    public void getSumNumberTest() {
        assertTrue(getSumOfNumbers("ddcdc 5 6   9 ; ssd 9") == 29);
        assertTrue(getSumOfNumbers("sdssdsdsdsdsd") == 0);
        assertTrue(getSumOfNumbers("sdssdsdsd 1   sdsd") == 1);
        assertTrue(getSumOfNumbersJava8Variant("ddcdc 5 6   9 ; ssd 9") == 29);
        assertTrue(getSumOfNumbersJava8Variant("sdssdsdsdsdsd") == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSumNumberExceptionTest() {
        getSumOfNumbers(null);
        getSumOfNumbersJava8Variant(null);
    }

    @Test
    public void getPrimeNumberTest() {
        assertEquals(of(13, 17).collect(toList()), getPrimeNumbers(13, 18));
        assertNotEquals(of(2, 3, 5).collect(toList()), getPrimeNumbers(2, 4));
    }

    @Test
    public void countWaysToProduceGivenAmountOfMoneyTest(){
        assertTrue(countWaysToProduceGivenAmountOfMoney(1)==1);
        assertTrue(countWaysToProduceGivenAmountOfMoney(2)==1);
        assertTrue(countWaysToProduceGivenAmountOfMoney(5)==2);
        assertTrue(countWaysToProduceGivenAmountOfMoney(7)==2);
        assertTrue(countWaysToProduceGivenAmountOfMoney(10)==4);
        assertTrue(countWaysToProduceGivenAmountOfMoney(11)==4);
        assertTrue(countWaysToProduceGivenAmountOfMoney(15)==6);
    }


}
