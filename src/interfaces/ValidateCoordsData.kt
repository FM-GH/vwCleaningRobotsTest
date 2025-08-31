package interfaces
import utils.verifyIntValues

/**
 * Interface used to define the common functions and types between Grid and CleaningRobots,
 * define methods to convert the information received in the inputs to a more robust and usable structure.
 */
interface ValidateCoordsData {
    val arrayLength: Int

    /**
     * Internal Class to define the data type of CleaningRobots coords input
     */
    class CoordsInputs(var horizontalCoord: Int = 0, var verticalCoord: Int = 0, var direction: String = "")

    /**
     * Enum class that defines GRIDCOORDS and ROBOTCOORDS, used to define the arrayLength to
     * recycle the function convertCoordsInputDataToValues with Grid input and CleaningRobot input
     * that contains the direction too.
     * (Grid need to check 2 values and CleaningRobot 3, example Grid (5 5) and CleaningRobot (5 5 N)
     */
    enum class InputCoordsType {
        GRIDCOORDS, ROBOTCOORDS;
        fun typeValues(): Int {
            return when (this) {
                GRIDCOORDS -> 2
                ROBOTCOORDS -> 3
            }
        }
    }

    /**
     * Function that ensure that input coordinates are valid to use it.
     *
     * Returns Boolean, true if are valid and false if not.
     */
    fun validateCoordsInput(inputData: String, arrayLength: Int): Boolean {
        var validationToReturn: Boolean? = null

        val splitedInputData: List<String> = inputData.split(" ")

        validationToReturn = if(splitedInputData.size == arrayLength) {
            verifyIntValues(splitedInputData[0].toInt()) && verifyIntValues(splitedInputData[1].toInt())
        }else {
            false
        }
        return validationToReturn
    }
    /**
     * Function that convert input coordinates to CoordsInput, ensuring that Grid and CleaningRobots
     * recieve their coordinates with a valid structure.
     * This function is recycled for Grid and CleaningRobots, that's why receive input arrayLength, to
     * determine whether it needs to take direction into account or not.
     *
     * Returns CoordsInputs formated to Grid and CleaningRobots.
     */
    fun convertCoordsInputDataToValues(inputData: String, arrayLength: Int): CoordsInputs {
        val splitInputData: List<String> = inputData.split(" ")
        val coordsInput = CoordsInputs(splitInputData[0].toInt(), splitInputData[1].toInt())

        if(arrayLength == InputCoordsType.ROBOTCOORDS.typeValues()) coordsInput.direction = splitInputData[2]

        return coordsInput
    }
}