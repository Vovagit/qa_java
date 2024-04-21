package com.example;

import com.example.constants.TestValues;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private Feline feline;
    private final String sex;
    private boolean expectedHasMane;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.expectedHasMane = hasMane;
    }

    @Before
    public void before(){
        feline= Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {

        return new Object[][]{
                {TestValues.LION_MALE,true},
                {TestValues.LION_FEMALE,false}
        };

    }


    @Test
    public void doesHaveMane() throws Exception {
        Lion lion=new Lion(sex,feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedHasMane,actual);
    }

}
