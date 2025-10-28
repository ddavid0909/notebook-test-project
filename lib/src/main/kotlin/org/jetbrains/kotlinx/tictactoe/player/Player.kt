package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

/**
 * Represents an abstract player in a game with a given side and name. This class provides
 * the basic functionality required for player operations, such as making a move, while
 * delegating the move decision logic to its subclasses.
 *
 * @property side The side the player is controlling in the game (e.g., "X" or "O"). May
 * be implemented as ENUM or single character, but String is used for future extensibility.
 * @property name The name of the player.
 */
abstract class Player(val side:String, val name: String) {

    /**
     * Executes the process of making a move for the player.
     *
     * Template method design pattern is used to implement the process of making a move.
     * Subclasses should override the `getInput` method to provide the logic for selecting a position.
     *
     * @throws Exception If the chosen position is invalid or already occupied.
     */
    fun makeMove(){
        val position = this.getInput()
        Board.occupy(this, position)
    }

    abstract fun getInput(): Position

}