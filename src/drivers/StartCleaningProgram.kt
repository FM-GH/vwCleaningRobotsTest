package drivers

import domains.CleaningRobot
import domains.Scenario
import java.io.File

/**
 * Function that receives inputs from a file called Inputs.txt and collects
 * the information to set up the scenario, registering the grid and the cleaning robots
 */
fun startCleaningProgram() {
    val fileRoute = "src/inputs.txt"
    var data: List<String> = emptyList()

    try {
        val lines = File(fileRoute).readLines()
        data = lines
    } catch (e: Exception) {
        println("Error on reading file: ${e.message}")
    }
    val gridData = data[0]
    val robotsList = mutableListOf<CleaningRobot.RobotsInputs>()

    data = data.drop(1)

    if(data.size % 2 == 0) {
        val listPositions = mutableListOf<String>()
        val listInstructions = mutableListOf<String>()

        for(input in data) {
            if(data.size % 2 == 0) {
                listPositions.add(input)
            }else {
                listInstructions.add(input)
            }
            data = data.drop(1)
        }
        var iterator = 0

        while(iterator < listPositions.size && iterator < listInstructions.size) {
            robotsList.add(CleaningRobot.RobotsInputs(listPositions[iterator], listInstructions[iterator]))
            iterator++
        }

        val scenario = Scenario()

        scenario.setScenario(gridData, robotsList)
        scenario.startCleaningProgram()
    }
    else {
        println("Error on Inputs.txt data format")
    }
}