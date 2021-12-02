package PigLatinSentence;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
/*
 * What is junit?
 *   Junit is a testing framework for java
 *
 * What is unit testing?
 *   unit testing is the process of testing the smaller units of your application
 *       - for java, we will be testing our methods
 *
 * What is an annotation?
 *   annotations help associate metadata to the specific entity we want.
 *
 * Annotations in JUNIT:
 *   - @Test: marks a method as a test case
 *   - @BeforeAll: this will run before the test suite is ran
 *   - @AfterAll: this will run after the test suite is ran
 *   - @BeforeEach: runs before each test
 *   - @AfterEach: runs after each test
 *
 *
 * What is TDD?
 *   Test Driven Development
 *       - write the tests BEFORE the application code, then we write the code to make the test pass.
 *
 *
 * What is positive testing?
 *   testing valid inputs
 *
 * What is negative testing?
 *   testing with invalid inputs
 * */

class PigLatinTest {

    PigLatin pigLatin;

    public PigLatinTest(){
        this.pigLatin = Mockito.spy(PigLatin.class);
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("This will run before any test is ran");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("This will run after all tests are ran");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("This will run before each test case");
    }

    @AfterEach
    void afterEach(){
        System.out.println("This will run after each test case");
    }

    @Test
    void encryptValidString() {
        //arrange - where we have our expected result and mocks if needed
        String sentenceToTest = "This is a valid Test";
        String expectedResult = "hisTay siay aay alidvay estTay";
        Mockito.when(pigLatin.isSentenceValid(sentenceToTest)).thenReturn(true);

        //act - is where we are going to call the method we are actually testing
        String actualResult = pigLatin.encrypt(sentenceToTest);


        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void encryptInvalidString() {
        //arrange - where we have our expected result and mocks if needed
        String sentenceToTest = "This is a val!id Test";
        String expectedResult = "Invalid sentence.";

        //act - is where we are going to call the method we are actually testing
        String actualResult = pigLatin.encrypt(sentenceToTest);


        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void isSentenceValidReturnFalse(){
        //arrange
        String sentenceToTest = "This is a val!id Test";
        Boolean expectedResult = false;

        //act
        Boolean actualResult = pigLatin.isSentenceValid(sentenceToTest);

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void isSentenceValidReturnTrue(){
        //arrange
        String sentenceToTest = "This is a valid Test";
        Boolean expectedResult = true;

        //act
        Boolean actualResult = pigLatin.isSentenceValid(sentenceToTest);

        //assert
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void isWordValidReturnTrue(){
        //arrange
        String wordToTest = "boogie";
        Boolean expectedResult = true;

        //act
        Boolean actualResult = pigLatin.isWordValid(wordToTest);

        //assert
        assertEquals(expectedResult,actualResult);
    }


    @Test
    void isWordValidReturnFalse(){
        //arrange
        String wordToTest = "boo.gie";
        Boolean expectedResult = false;

        //act
        Boolean actualResult = pigLatin.isWordValid(wordToTest);

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void decryptValidString() {
        //arrange - where we have our expected result and mocks if needed
        String sentenceToTest = "hisTay siay aay alidvay estTay";
        String expectedResult = "This is a valid Test";

        //act - is where we are going to call the method we are actually testing
        String actualResult = pigLatin.decrypt(sentenceToTest);


        //assert
        assertEquals(expectedResult,actualResult);

    }

    @Test
    void decryptInvalidString() {
        //arrange - where we have our expected result and mocks if needed
        String sentenceToTest = "hisTay siay aay alidvay. estTay";
        String expectedResult = "Invalid sentence.";

        //act - is where we are going to call the method we are actually testing
        String actualResult = pigLatin.decrypt(sentenceToTest);


        //assert
        assertEquals(expectedResult,actualResult);

    }
}