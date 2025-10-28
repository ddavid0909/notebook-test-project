package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Position

/**
 * Represents a standard player in a game, extending the abstract `Player` class. This class
 * defines the logic for getting the player's move input through a console-based interaction.
 *
 * @constructor Creates a `StandardPlayer` with a specific side and name.
 * @param side The side the player is controlling in the game (e.g., "X" or "O").
 * @param name The name of the player.
 */
class StandardPlayer(side:String, name:String) : Player(side, name) {
    override fun getInput(): Position {
        println("Enter the coordinates in the format <row> <column>:")
        val input = readln()
        val (x, y) = input.split(' ').map { it.toInt() }
        return Position(x, y)
    }

}