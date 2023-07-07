import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RobotGridTests {

    RobotGrid robotGrid =  new RobotGrid();

    @Test
    public void testIsSafe() {
        // TODO: Add test logic and assertions for isSafe function
        //Postive Tests
        Assertions.assertFalse(robotGrid.isSafe(15,99));//Adds to 24
        Assertions.assertFalse(robotGrid.isSafe(14,99));//Adds to 23
        Assertions.assertTrue(robotGrid.isSafe(14,98));//Adds to 22
        //Negative  x Tests
        Assertions.assertFalse(robotGrid.isSafe(-15,99));//Adds to 24
        Assertions.assertFalse(robotGrid.isSafe(-14,99));//Adds to 23
        Assertions.assertTrue(robotGrid.isSafe(-14,98));//Adds to 22
        //Negative y Tests
        Assertions.assertFalse(robotGrid.isSafe(15,-99));//Adds to 24
        Assertions.assertFalse(robotGrid.isSafe(14,-99));//Adds to 23
        Assertions.assertTrue(robotGrid.isSafe(14,-98));//Adds to 22
        //Negative x and y Tests
        Assertions.assertFalse(robotGrid.isSafe(-15,-99));//Adds to 24
        Assertions.assertFalse(robotGrid.isSafe(-14,-99));//Adds to 23
        Assertions.assertTrue(robotGrid.isSafe(-14,-98));//Adds to 22

    }

    @Test
    public void testTotalSafeSquares() {
        // TODO: Add test logic and assertions for totalSafeSquares function

    }

    @Test
    public void testShortestSafeJourney() {
        // TODO: Add test logic and assertions for shortestSafeJourney function

    }


    // TODO: Add more tests to ensure comprehensive test coverage
}
