package org.jetbrains.kotlinx.tictactoe
import org.jetbrains.kotlinx.tictactoe.player.Player

/**
 * Represents a singleton game board consisting of a two-dimensional array of spots.
 *
 * The board is initialized with a 3x3 grid of `Spot` objects, representing positions
 * that can be occupied by players during the game. This class includes functionality
 * for occupying specific spots, as well as resetting the board state.
 */
object Board {
    val spots = Array(3) { Array(3) { Spot() } }

    /**
     * Occupies the specified position on the board for the given player.
     *
     * @param player The player attempting to occupy the position.
     * @param position The position on the board to occupy, represented by its coordinates.
     * @throws Exception If the specified spot is already occupied or any other error occurs.
     */
    fun occupy(player: Player, position: Position) {
        val (x, y) = position
        try {
            spots[x][y].occupy(player)
        } catch (e: Exception) {
            throw e
        }
    }


    /**
     * Resets the state of the game board by clearing all spots.
     * This function iterates over the entire two-dimensional array of spots
     * and calls the `clear` method on each spot, effectively removing any
     * assigned player from all positions on the board.
     * The main purpose of this function is to reset the state of the game board for testing, as
     * it is a singleton.
     */
    fun reset() {
        for (x in spots.indices) {
            for (y in spots[x].indices) {
                spots[x][y].clear()
            }
        }
    }
}