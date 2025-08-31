package drivers

import domains.CleaningRobot
import domains.Scenario

fun startCleaningTest() {
    val gridData = "5 5"
    val scenario = Scenario()
    //val robot1 = CleaningRobot.RobotsInputs("1 1 N", "RRMMM")
    //val robot2 = CleaningRobot.RobotsInputs("3 3 S", "MLMLMLML")
    //val robot1 = CleaningRobot.RobotsInputs("1 2 N", "LMLMLMLMM")
    //val robot2 = CleaningRobot.RobotsInputs("3 3 E", "MMRMMRMRRM")
    val robot1 = CleaningRobot.RobotsInputs("1 2", "LMLM5MLMM")
    val robot2 = CleaningRobot.RobotsInputs("3 3 F", "MMRMMAMRRM")

    scenario.setScenario(gridData, listOf(robot1, robot2))

    scenario.startCleaningProgram()
}