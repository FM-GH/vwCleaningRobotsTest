package domains
import interfaces.ValidateCoordsData
import utils.validateIfItsValidPosition
/**
 * Class to control de CleaningRobot Domain, class constructor it does not receive parameters
 * to force the use of the setRobot method, which ensures that the information it receives is correct
 * to set the robot and be able to operate correctly, reinforcing error handling.
 */
class CleaningRobot() : ValidateCoordsData {
    private var name: String = ""
    private var xCoord: Int = 0
    private var yCoord: Int = 0
    private var direction: Directions = Directions.N
    private var instructions: List<Instructions> = mutableListOf()

    override val arrayLength: Int = ValidateCoordsData.InputCoordsType.ROBOTCOORDS.typeValues()

    /**
     * Enum Class to ensure that users just can use valid directions
     */
    enum class Directions {
        N,S,E,W
    }

    /**
     * Enum Class to ensure that users just can use valid instructions
     */
    enum class Instructions {
        L,R,M
    }

    public class RobotsInputs (val coordinates: String, val instructions: String)

    /**
     * Function that sets the robot data.
     * If the data received is not correct, a message will be displayed on the console.
     */
    public fun setRobot(name: String, coordinates: String, instructions: String, minCoords: List<Int>, maxCoords: List<Int>) {
        var coordToShow: String = ""
        try {
            this.name = name
            if(validateCoordsInput(coordinates, arrayLength)) {
                val coordsValues: ValidateCoordsData.CoordsInputs = convertCoordsInputDataToValues(coordinates, arrayLength)
                if(validateIfItsValidPosition(minCoords, maxCoords, coordsValues.horizontalCoord, coordsValues.verticalCoord)) {
                    coordToShow = coordsValues.direction
                    this.xCoord = coordsValues.horizontalCoord
                    this.yCoord = coordsValues.verticalCoord
                    this.direction = Directions.valueOf(coordsValues.direction)
                } else {
                    println("$name: Invalid position to set Cleaning Robot")
                }
            }else {
                println("$name: Invalid structure (xCoord, yCoord, Direction) to set Cleaning Robot")
            }
        }catch (e: IllegalArgumentException){
            println("$name: Direction $coordToShow is not a Valid Direction")
        }
        var toCheckInstruction: String = ""
        try {
            val validatedInstructions = mutableListOf<Instructions>()
            val instructionsFormatted = instructions.replace(" ", "")

            for(instruction in instructionsFormatted) {
                toCheckInstruction = instruction.toString()
                Instructions.valueOf(instruction.toString())

                validatedInstructions.add(Instructions.valueOf(instruction.toString()))
            }
            this.instructions = validatedInstructions
        }catch (e: IllegalArgumentException){
           println("$name: Instruction $toCheckInstruction is not a Valid Instruction")
        }
    }

    /**
     * Setter of instructions value.
     *
     * Input value List<Instructions>.
     */
    public fun setInstructions(instructions: List<Instructions>) {
        this.instructions = instructions
    }

    /**
     * Getter to read name value.
     *
     * Returns String.
     */
    public fun getRobotName(): String {
        return this.name
    }

    /**
     * Getter to read xCoord value.
     *
     * Returns Int.
     */
    public fun getXCoord(): Int {
        return this.xCoord
    }

    /**
     * Getter to read yCoord value.
     *
     * Returns Int.
     */
    public fun getYCoord(): Int {
        return this.yCoord
    }

    /**
     * Getter to read direction value.
     *
     * Return Directions.
     */
    public fun getDirection(): Directions {
        return this.direction
    }

    /**
     * Getter to read instructions value.
     *
     * Return List<Instructions>.
     */
    public fun getInstructions(): List<Instructions> {
        return this.instructions
    }

    /**
     * Function that sequentially reads from the queue of actions and executes the next instruction,
     * taking into account the limits of its operations and the designated area, ensuring that it can
     * previously perform an action that is valid before performing it.
     *
     * Returns Boolean true if action is done and false if the action can't be done
     */
    public fun doAction(minCoords: List<Int>, maxCoords: List<Int>, instruction: Instructions) : Boolean {
        var actionDone: Boolean
        when(instruction) {
            Instructions.L-> {
                when (this.direction) {
                    Directions.N -> this.direction = Directions.W
                    Directions.W -> this.direction = Directions.S
                    Directions.S -> this.direction = Directions.E
                    Directions.E -> this.direction = Directions.N
                }
                actionDone = true
            }
            Instructions.R -> {
                when (this.direction) {
                    Directions.N -> this.direction = Directions.E
                    Directions.E -> this.direction = Directions.S
                    Directions.S -> this.direction = Directions.W
                    Directions.W -> this.direction = Directions.N
                }
                actionDone = true
            }
            Instructions.M -> {
                var newXCoord: Int = this.xCoord
                var newYCoord: Int = this.yCoord

                when (this.direction) {
                    Directions.N -> newYCoord += 1
                    Directions.S -> newYCoord -= 1
                    Directions.E -> newXCoord += 1
                    Directions.W -> newXCoord -= 1
                }

                if(validateIfItsValidPosition(minCoords, maxCoords, newXCoord, newYCoord)) {
                    this.xCoord = newXCoord
                    this.yCoord = newYCoord
                    actionDone = true
                }else {
                    actionDone = false
                }
            }
        }
        return actionDone
    }
}
