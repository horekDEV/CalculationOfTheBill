package ru.horekdev.calculationofthebill;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivityTest {
    MainActivity mainActivity = new MainActivity();

    @Test
    public void scenarioValuesOne() {
        AtomicInteger percent = new AtomicInteger();
        percent.set(0);
        AtomicInteger peopleCount = new AtomicInteger();
        peopleCount.set(0);

        mainActivity.sum.setText("1000");

        Assert.assertEquals(500.0, mainActivity.counter(
                peopleCount,
                percent,
                mainActivity.sum
                )
        );
    }

    @Test
    public void scenarioValuesTwo() {

    }

    @Test
    public void scenarioValuesThree() {

    }

    @Test
    public void scenarioValuesFour() {

    }
}