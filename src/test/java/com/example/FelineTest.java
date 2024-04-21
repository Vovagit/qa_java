package com.example;

import com.example.constants.TestValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeat() throws Exception {
        List<String> actual = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood(TestValues.HUNTER_KIND);
        assertEquals(TestValues.HUNTER_FOOD,actual);
    }

    @Test
    public void getFamily() {
        String actual=feline.getFamily();
        assertEquals(TestValues.CAT_FAMILY,actual);

    }

    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(TestValues.FELINE_KITTENS_PARAM);
        assertEquals(TestValues.FELINE_KITTENS_PARAM,actual);
    }

    @Test
    public void getKittensWithParam() {
        int actual=feline.getKittens(TestValues.FELINE_KITTENS);
        Mockito.verify(feline).getKittens(TestValues.FELINE_KITTENS);
        assertEquals(TestValues.FELINE_KITTENS,actual);
    }
}