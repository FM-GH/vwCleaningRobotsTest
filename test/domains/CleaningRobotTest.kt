package domains

import domains.CleaningRobot.Directions
import domains.CleaningRobot.Instructions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CleaningRobotTest {
    val robot = CleaningRobot()
    val name = "robot"
    val coords = "1 1 N"
    val inst = "LRLRMM"
    val minCoords = listOf(0,0)
    val maxCoords = listOf(5,5)
    val instToCompare = listOf(Instructions.L,Instructions.R,Instructions.L,Instructions.R,Instructions.M,Instructions.M)

    @Test
    fun setRobot() {
        //Valid Robot Insertion
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertSame(name, robot.getRobotName())
        assertSame(1, robot.getXCoord())
        assertSame(1, robot.getYCoord())
        assertSame(Directions.N, robot.getDirection())
        assertTrue(instToCompare == robot.getInstructions())

        //Robot has incorrect inputs
        val newCoords = "1 1 F"
        val newInst = "LRARMM"
        robot.setRobot(name, newCoords, newInst, minCoords, maxCoords)
        assertSame(name, robot.getRobotName())
        assertSame(1, robot.getXCoord())
        assertSame(1, robot.getYCoord())
        assertSame(Directions.N, robot.getDirection()) //Input has F, not a valid direction, so robot inserted N
        assertFalse(instToCompare != robot.getInstructions())
    }

    @Test
    fun setInstructions() {
        val newInst = listOf(Instructions.R,Instructions.R,Instructions.M,Instructions.M)
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        robot.setInstructions(newInst)
        assertTrue(newInst == robot.getInstructions())
    }

    @Test
    fun getRobotName() {
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertSame(name, robot.getRobotName())
    }

    @Test
    fun getXCoord() {
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertSame(1, robot.getXCoord())
    }

    @Test
    fun getYCoord() {
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertSame(1, robot.getYCoord())
    }

    @Test
    fun getDirection() {
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertSame(Directions.N, robot.getDirection())
    }

    @Test
    fun getInstructions() {
        robot.setRobot(name, coords, inst, minCoords, maxCoords)
        assertTrue(instToCompare == robot.getInstructions())
    }

    @Test
    fun doAction() {
        val newCoords = "1 1 S"
        robot.setRobot(name, newCoords, inst, minCoords, maxCoords)
        assertTrue { robot.doAction(minCoords, maxCoords, Instructions.M) } // true
        assertFalse { robot.doAction(minCoords, maxCoords, Instructions.M) } // false, robot can't move outside grid
    }

}