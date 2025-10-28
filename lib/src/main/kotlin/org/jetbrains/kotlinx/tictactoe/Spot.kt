package org.jetbrains.kotlinx.tictactoe

import org.jetbrains.kotlinx.tictactoe.exceptions.SpotOccupiedException
import org.jetbrains.kotlinx.tictactoe.player.Player

/**
 * Represents a spot on a game board that can be occupied by a player.
 *
 * A `Spot` holds a reference to the player currently occupying it, or `null` if the spot is free.
 * It provides methods for checking its availability, occupying it with a player, and clearing its state.
 *
 * @property player The player occupying the spot, or `null` if the spot is free.
 */
class Spot {
    var player: Player? = null

    /**
     * Occupies the spot with the given player if the spot is free.
     *
     * @param player The player attempting to occupy the spot.
     * @throws SpotOccupiedException If the spot is already occupied by another player.
     */
    fun occupy(player: Player) {
        if (!this.isFree()) throw SpotOccupiedException()
        this.player = player
    }

    /**
     * Determines if the spot is free (i.e., not occupied by a player).
     *
     * This function checks whether the spot's `player` property is `null`,
     * indicating that no player currently occupies the spot.
     *
     * @return `true` if the spot is unoccupied, `false` otherwise.
     */
    fun isFree(): Boolean {
        return this.player == null
    }

    /**
     * Clears the spot by removing the player occupying it.
     *
     * This function sets the `player` property to `null`, making the spot unoccupied.
     * It is typically used to reset the state of the spot, such as for setup during testing.
     */
    fun clear() {
        this.player = null
    }
}