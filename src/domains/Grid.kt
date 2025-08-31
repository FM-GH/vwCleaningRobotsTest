package domains
import interfaces.ValidateCoordsData

/**
 * Class to control de Grid Domain, class constructor it does not receive parameters
 * to force the use of the setGrid method, which ensures that the information it receives is correct
 * to set the grid and be able to operate correctly, reinforcing error handling.
 */
class Grid () : ValidateCoordsData {
    private var rows: Int = 1
    private var cols: Int = 1
    private var maxCoords: List<Int> = mutableListOf()
    private var minCoords: List<Int> = listOf(0,0)

    override val arrayLength: Int = ValidateCoordsData.InputCoordsType.GRIDCOORDS.typeValues()

    /**
     * Function that sets the grid where the cleaning robots will perform their operations.
     * If the data received is not correct, a message will be displayed on the console.
     */
    public fun setGrid(inputData: String) {
        try{
            if(validateCoordsInput(inputData, arrayLength)) {
                val coordsValues: ValidateCoordsData.CoordsInputs = convertCoordsInputDataToValues(inputData, arrayLength)
                if(coordsValues.horizontalCoord >= this.rows && coordsValues.verticalCoord >= this.cols) {
                    this.rows = coordsValues.horizontalCoord
                    this.cols = coordsValues.verticalCoord
                    this.maxCoords = mutableListOf(this.rows, this.cols)
                }else {
                    println("Invalid rows or cols minimum size to set new Grid")
                }
            }else {
                println("Invalid rows or cols inputs to set new Grid")
            }
        }catch(e : IllegalArgumentException){
            println("Invalid Input Data $inputData to set the Grid")
        }

    }

    /**
     * Getter to read rows value.
     *
     * returns Int
     */
    public fun getInternalRows() : Int {
        return this.rows
    }

    /**
     * Getter to read cols value.
     *
     * returns Int
     */
    public fun getInternalCols() : Int {
        return this.cols
    }

    /**
     * Getter to read maxCoords value.
     *
     * returns List<Int>
     */
    public fun getInternalMaxCoords() : List<Int> {
        return this.maxCoords
    }
    /**
     * Getter to read minCoords value.
     *
     * returns List<Int>
     */
    public fun getInternalMinCoords() : List<Int> {
        return this.minCoords
    }
}