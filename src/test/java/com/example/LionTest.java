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
public class LionTest {

    @Mock
    Feline feline;
    private String actualExceptionText;

    @Test
    public void getKittens() throws Exception {
        Lion lion= new Lion(TestValues.LION_MALE,feline);
        Mockito.when(feline.getKittens()).thenReturn(TestValues.LION_KITTENS);
        int actual = lion.getKittens();
        assertEquals(TestValues.LION_KITTENS,actual);
    }

    @Test
    public void exceptionSexTest() {
        try {
            new Lion(TestValues.EXCEPTION_SEX, feline);
        }catch(Exception exception){
            actualExceptionText =exception.getMessage();
        }
        assertEquals(TestValues.EXCEPTION_SEX_TEXT, actualExceptionText);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion= new Lion(TestValues.LION_MALE,feline);
        Mockito.when(feline.getFood(Mockito.eq(TestValues.HUNTER_KIND))).thenReturn(TestValues.HUNTER_FOOD);
        List<String> actual=lion.getFood();
        assertEquals(TestValues.HUNTER_FOOD,actual);
    }
}