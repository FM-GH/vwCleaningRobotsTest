package utils

/**
 * Auxiliary function that checks if the coordinates received as input are valid
 * in the context of the defined scenario.
 *
 * Return Boolean, true if coordinates are valid and false if not.
 */
fun validateIfItsValidPosition(minCoords: List<Int>, maxCoords: List<Int>, xCord: Int, yCord: Int) : Boolean {
    var validPosition: Boolean = false
    if(minCoords.isNotEmpty() && maxCoords.isNotEmpty()) {
        try {
            validPosition = (xCord >= minCoords[0] && xCord <= maxCoords[0] && yCord >= minCoords[1] && yCord <= maxCoords[1])
        }catch(e : Exception) {
            println("ERROR: ${e.message}")
        }
    }
    return validPosition
}


