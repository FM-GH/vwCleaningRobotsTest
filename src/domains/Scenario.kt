package domains
/**
 * Class that is responsible for declaring the action scenario for the robots and
 * the grid that defines the limits of the operations.
 * Contains the grid and all declared CleaningRobots
 */
class Scenario {
    private val grid: Grid = Grid()
    private var cleaningRobots: List<CleaningRobot> = mutableListOf()

    /**
     * Function that sets the Scenario where the cleaning robots will perform their operations.
     */
    public fun setScenario(gridInputData: String, robotsInputs: List<CleaningRobot.RobotsInputs>) {
        val listOfCleaningRobots = mutableListOf<CleaningRobot>()
        var counter = 0
        grid.setGrid(gridInputData)

        for(input in robotsInputs) {
            counter++
            val cleaningRobot = CleaningRobot()

            cleaningRobot.setRobot("Robot$counter", input.coordinates, input.instructions, grid.getInternalMinCoords(), grid.getInternalMaxCoords())

            listOfCleaningRobots.add(cleaningRobot)
        }
        this.cleaningRobots = listOfCleaningRobots

    }

    /**
     * Function that orchestrates all the robots and executes them sequentially
     * so that they can execute all their instructions.
     * At the end, it displays the final positions of each robot on the console.
     */
    public fun startCleaningProgram() {
        for(robot in this.cleaningRobots) {
            var instructions = robot.getInstructions()

            while(instructions.isNotEmpty()) {
                val instruction : CleaningRobot.Instructions = instructions[0]
                val actionDone: Boolean = robot.doAction(this.grid.getInternalMinCoords(), this.grid.getInternalMaxCoords(), instruction)

                if(!actionDone) {
                    instructions = emptyList()
                } else {
                    instructions = instructions.drop(1)
                }
                robot.setInstructions(instructions)
            }
            println("${robot.getXCoord()} ${robot.getYCoord()} ${robot.getDirection()}")
        }
    }
}



