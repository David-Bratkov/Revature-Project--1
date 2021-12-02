package Factorial;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FactorialTest {


    Factorial factorial;

    public FactorialTest(){
        this.factorial = new Factorial();
    }


    @Test
    void Test1() {

        long sendtofunction = 5;
        long sentencetoresult = Factorial.Factorialmath(sendtofunction);
        long expectedresult = 120;

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void Test2() {

        long sendtofunction = 12;
        long sentencetoresult = Factorial.Factorialmath(sendtofunction);
        long expectedresult = 479001600L;

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void Test3() {

        long sendtofunction = 13;
        long sentencetoresult = Factorial.Factorialmath(sendtofunction);
        long expectedresult = 6227020800L;

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void Test4() {

        long sendtofunction = -1;
        long sentencetoresult = Factorial.Factorialmath(sendtofunction);
        long expectedresult = 0;

        assertEquals(expectedresult, sentencetoresult);

    }

}