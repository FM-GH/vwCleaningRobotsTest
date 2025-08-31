package domains

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GridTest {
    var grid = Grid()
    var inputData = "5 5"
    var rows = 5
    var cols = 5
    var minCoords = listOf(0,0)
    var maxCoords = listOf(5,5)

    @Test
    fun setGrid() {
        grid.setGrid(inputData)
        assertSame(rows, grid.getInternalRows())
        assertSame(cols, grid.getInternalCols())
        assertTrue{ minCoords == grid.getInternalMinCoords() }
        assertTrue { maxCoords == grid.getInternalMaxCoords() }
    }

    @Test
    fun getInternalRows() {
        grid.setGrid(inputData)
        assertSame(rows, grid.getInternalRows())
    }

    @Test
    fun getInternalCols() {
        grid.setGrid(inputData)
        assertSame(cols, grid.getInternalCols())
    }

    @Test
    fun getInternalMaxCoords() {
        grid.setGrid(inputData)
        assertTrue { maxCoords == grid.getInternalMaxCoords() }

    }

    @Test
    fun getInternalMinCoords() {
        grid.setGrid(inputData)
        assertTrue{ minCoords == grid.getInternalMinCoords() }
    }

}