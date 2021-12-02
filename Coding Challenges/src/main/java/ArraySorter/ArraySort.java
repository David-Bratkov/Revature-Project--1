package ArraySorter;

/*
Attempt to solve this problem using TDD

Write a method that takes an array of integers and returns the ints in the array sorted.
    - The length of the array must not be greater than 100


sample inputs:
{23,36,12,14,3,22,8,46,31,27}
----
{}
----
{23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,7}



NOTE: please do not use Arrays.sort(). try to solve the problem programmatically.
 */


import java.util.Arrays;

public class ArraySort {

    public static int[] ArraySortdata(int[] input) {

        int[] returnvalue = new int[input.length];
        int[] ignoredvalues = new int[input.length];

        int min = input[0];

        if (input.length > 100 || input.length == 0) return null;

        for (int firstloop = 0; firstloop < input.length; firstloop++) {

            int i = 0;

            int testvalue = Arrays.binarySearch(ignoredvalues, firstloop);

            if (firstloop != testvalue) {

                for (int secondloop = 0; secondloop < input.length; secondloop++) {

                    if (min > input[secondloop] && min != ignoredvalues[firstloop])  {

                        i = secondloop;
                        min = input[secondloop];
                    }

                }

                ignoredvalues[firstloop] = i;
                returnvalue[firstloop] = input[i];

            }

        }

        return returnvalue;

    }

}
