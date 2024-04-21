package com.example;

import com.example.constants.TestValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSound(){
        Cat cat = new Cat(feline);
        String actual=cat.getSound();
        assertEquals(TestValues.CAT_SOUND,actual);
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(TestValues.HUNTER_FOOD);
        List<String> actual=cat.getFood();
        assertEquals(TestValues.HUNTER_FOOD,actual);
    }

}