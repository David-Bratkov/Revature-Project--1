package fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    public FizzBuzzTest(){
        this.fizzBuzz = new FizzBuzz();
    }

    @Test
    void fizzBuzz() {

        int sendtofunction = 100;
        String sentencetoresult = FizzBuzz.fizzBuzz(sendtofunction);
        String expectedresult = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, " +
                "Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, " +
                "Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61, " +
                "62, Fizz, 64, Buzz, Fizz, 67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz, Fizz, " +
                "82, 83, Fizz, Buzz, 86, Fizz, 88, 89, FizzBuzz, 91, 92, Fizz, 94, Buzz, Fizz, 97, 98, Fizz, Buzz";

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void fizzBuzz1() { // add better names

        int sendtofunction = -1;
        String sentencetoresult = FizzBuzz.fizzBuzz(sendtofunction);
        String expectedresult = null;

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void fizzBuzz2() {

        int sendtofunction = 20;
        String sentencetoresult = FizzBuzz.fizzBuzz(sendtofunction);
        String expectedresult = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz";

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void fizzBuzz3() {

        int sendtofunction = 61;
        String sentencetoresult = FizzBuzz.fizzBuzz(sendtofunction);
        String expectedresult = "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, " +
                "Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, " +
                "Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61";

        assertEquals(expectedresult, sentencetoresult);

    }

    @Test
    void fizzBuzz4() {

        int sendtofunction = -999999999;
        String sentencetoresult = FizzBuzz.fizzBuzz(sendtofunction);
        String expectedresult = null;

        assertEquals(expectedresult, sentencetoresult);

    }

}