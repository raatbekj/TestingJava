package com.example.testingjava;

import static org.junit.Assert.assertEquals;

import com.example.testingjava.domain.Math;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MathTest {
    private Math math;

    @Before
    public void setup() {
        math = new Math();
    }

    @Test
    public void addToNumber() {
        assertEquals("100", math.add("2", "98"));
    }

    @Test
    public void addToNull() {
        assertEquals("Отправка null", math.add("2", null));
    }
    @Test
    public void addToSpecial() {
        assertEquals("Специальные символы", math.add("2", "*&@"));
    }

    @Test
    public void addToLetters() {
        assertEquals("Отправка букв", math.add("fadfa", "20"));
    }

    @Test
    public void addToIsEmpty() {
        assertEquals("Пусто", math.add("   ", "20"));
    }

    @Test
    public void addToDot() {
        assertEquals("Отправка точки", math.add(" .32  ", "20"));
    }

    @Test
    public void addToNegative() {
        assertEquals("Отрицательные числа", math.add("0  ", "-20"));
    }


    @Test
    public void divToNumber() {
        assertEquals("3", math.div("2", "1"));
    }

    @Test
    public void divToNull() {
        assertEquals("Отправка null", math.div("2", null));
    }

    @Test
    public void divToLetters() {
        assertEquals("Отправка букв", math.div("fadSDADSAfa", "20  "));
    }

    @Test
    public void divToIsEmpty() {
        assertEquals("Пусто", math.div("   ", "20"));
    }

    @Test
    public void divToDot() {
        assertEquals("Отправка точки", math.div("100.12  ", "20"));
    }

    @Test
    public void divToZero() {
        assertEquals("На 0 делить нельзя!", math.div("10 ", "0"));
    }

    @After
    public void clear() {
        math = null;
    }
}
