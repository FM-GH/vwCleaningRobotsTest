package utils
/**
 * Auxiliary function to ensure that input has Int type
 *
 * Return Boolean, true if it is an int and false if not.
 */
fun verifyIntValues(value: Any) : Boolean {
    return value is Int
}