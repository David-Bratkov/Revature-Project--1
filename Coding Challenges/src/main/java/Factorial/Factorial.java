package Factorial;

public class Factorial {

    public static long Factorialmath (long input){

        long returnvalue = 1;

        if (input < 0) return 0;

        if (input == 0) return 1;

        for (long x = 1; x != input+1; ++x) {

            returnvalue = returnvalue * x;

        }

        return returnvalue;

    }

}
