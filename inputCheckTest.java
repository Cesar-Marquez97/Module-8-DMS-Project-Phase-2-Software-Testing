import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
   Cesar Marquez
   CEN 3024C - Software Development 1
   October 20, 2025
   inputCheckTest.java v.2
   This will test method
 */
class inputCheckTest {


    /*
       Test: Opening a File
       This test will verify that a file can be opened.
     */
    @Test
    @DisplayName("Computing the Opening a File (fileCheck) ")
    void fileCheck() {

        inputCheck input = new inputCheck();

        //creating the test data for the overall Rating Test
        ArrayList<String> testPlayerList = new ArrayList<String>();
        String testInputFile = "Liverpool Roster.txt";

        boolean testFileCheck = input.fileCheck(testPlayerList, testInputFile);

        boolean expected = true;

        //expected vs actual
        assertEquals(expected, testFileCheck, "Error: Opening a File (fileCheck)) FAIL");
    }
}