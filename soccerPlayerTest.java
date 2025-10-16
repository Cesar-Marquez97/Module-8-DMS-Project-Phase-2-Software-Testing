import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
   Cesar Marquez
   CEN 3024C - Software Development 1
   October 20, 2025
   soccerPlayerTest.java v.2
   This will test methods
 */
class soccerPlayerTest {

    /*
       Test: Add Objects
       This test verify that objects can be added to the system.
     */
    @Test
    @DisplayName("Computing the Add Objects (overallRating) ")
    void signPlayer() {

        soccerPlayer soccerPlayer = new soccerPlayer();

        //creating the test data for the overall Rating Test
        ArrayList<String> testPlayerList = new ArrayList<String>();

        String signPlayer = "6-Roy Kent-30-England-Central Midfield-R-88-81-87-83";

        String expected =       "Successfully Signed Player: \n" +
                                "Jersey Number: 6" + "\n" +
                                "Player Name: Roy Kent" + "\n" +
                                "Age: 30"  + "\n" +
                                "Nationality: England" + "\n" +
                                "Position: Central Midfield" + "\n" +
                                "Dominant Foot: R" + "\n" +
                                "Athleticism: 88" + "\n" +
                                "Attacking Skill: 81" + "\n" +
                                "Defense: 87" + "\n" +
                                "Soccer Skill: 83" + "\n";


        String testSignPlayer = soccerPlayer.signPlayer(testPlayerList, signPlayer);


        //expected vs actual
        assertEquals(expected, testSignPlayer, "Error: Add Objects (overallRating) FAIL");

    }

    /*
       Test: Remove Objects
       This test verify that objects can be removed to the system.
     */
    @Test
    @DisplayName("Computing the Remove Objects (ReleasePLayer) ")
    void releasePlayer() {

        soccerPlayer soccerPlayer = new soccerPlayer();

        //creating the test data for the overall Rating Test
        ArrayList<String> testPlayerList = new ArrayList<String>();
        int testJerseyNumber = 6;
        testPlayerList.add("6-Roy Kent-30-England-Central Midfield-R-88-81-87-83");

        String expected =       "Successfully Release Player: \n" +
                                "Jersey Number: 6" + "\n" +
                                "Player Name: Roy Kent" + "\n" +
                                "Age: 30"  + "\n" +
                                "Nationality: England" + "\n" +
                                "Position: Central Midfield" + "\n" +
                                "Dominant Foot: R" + "\n" +
                                "Athleticism: 88" + "\n" +
                                "Attacking Skill: 81" + "\n" +
                                "Defense: 87" + "\n" +
                                "Soccer Skill: 83" + "\n";


        //testing the method
        String testReleasePlayer = soccerPlayer.releasePlayer(testPlayerList, testJerseyNumber);

        //expected vs actual
        assertEquals(expected, testReleasePlayer, "Error: Remove Objects (ReleasePLayer)) FAIL");
    }

    /*
       Test: Update Objects
       This test verify that objects can be updated to the system.
     */
    @Test
    @DisplayName("Computing the Update Objects (updatePLayer) ")
    void updatePlayer() {

        soccerPlayer soccerPlayer = new soccerPlayer();

        //creating the test data for the overall Rating Test
        ArrayList<String> testPlayerList = new ArrayList<String>();
        testPlayerList.add("6-Roy Kent-30-England-Central Midfield-R-88-81-87-83");
        int testJerseyNumber = 6;

        //1-name, 4-position, 7-attacking skill
        int testSection = 4;

        String testInfo = "GoalKeeper";
        String testInfoUpdate = "6-Roy Kent-30-England-"+testInfo+"-R-88-81-87-83";

        testPlayerList.set(0, testInfoUpdate);

        String expected =    "\nUpdated position: GoalKeeper\n" +
                            "\n==============================================\n" +
                            "Update Player Information: \n" +
                            "Jersey Number: 6" + "\n" +
                            "Player Name: Roy Kent" + "\n" +
                            "Age: 30"  + "\n" +
                            "Nationality: England" + "\n" +
                            "Position: GoalKeeper" + "\n" +
                            "Dominant Foot: R" + "\n" +
                            "Athleticism: 88" + "\n" +
                            "Attacking Skill: 81" + "\n" +
                            "Defense: 87" + "\n" +
                            "Soccer Skill: 83" + "\n"+
                            "==============================================\n";

        String testUpdatePlayer = soccerPlayer.updatePlayer(testPlayerList, testJerseyNumber, testSection, testInfo);

        //expected vs actual
        assertEquals(expected, testUpdatePlayer, "Error: Update Objects (updatePLayer)");

    }

    /*
       Test: Custom Action
       This test verify the custom action.
     */
    @Test
    @DisplayName("Computing the Custom Action (overallRating) ")
    void overallRating() {

        soccerPlayer soccerPlayer = new soccerPlayer();

        //creating the test data for the overall Rating Test
        ArrayList<String> testPlayerList = new ArrayList<String>();
        testPlayerList.add("6-Roy Kent-30-England-Central Midfield-R-88-81-87-83");

        int testJerseyNumber = 6;

        //testing the method
        float testOverallRating = soccerPlayer.overallRating(testPlayerList, testJerseyNumber);

        //expected vs actual
        assertEquals(84.75, testOverallRating, "Error: The Custom Action (overallRating) FAIL");
    }
}