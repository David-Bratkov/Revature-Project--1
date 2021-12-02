package ArraySorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    ArraySort arraySort;

    public ArrayTest(){
        this.arraySort = new ArraySort();
    }


    @Test
    void Test1() {

        int[] sendtofunction = {23,36,12,14,3,22,8,46,31,27};
        int[] sentencetoresult = arraySort.ArraySortdata(sendtofunction);
        int[] expectedresult = {3,8,12,14,22,23,27,31,36,46};

        assertArrayEquals(expectedresult, sentencetoresult);

    }

    @Test
    void Test2() {

        int[] sendtofunction = {};
        int[] sentencetoresult = arraySort.ArraySortdata(sendtofunction);
        int[] expectedresult = null;

        assertArrayEquals(expectedresult, sentencetoresult);

    }

    @Test
    void Test3() {

        int[] sendtofunction = {23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,23,36,12,14,3,22,8,46,31,27,7};
        int[] sentencetoresult = arraySort.ArraySortdata(sendtofunction);
        int[] expectedresult = null;

        assertArrayEquals(expectedresult, sentencetoresult);

    }

}