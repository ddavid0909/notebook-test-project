package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

/**
 * RandomPlayer is a subclass of Player that generates random moves on the game board.
 * It randomly selects free spots on the board to make its move.
 *
 * This class simulates a player that makes decisions without any strategic or
 * logical consideration, relying solely on chance.
 *
 * @constructor Creates a RandomPlayer with the specified side and name.
 * @param side The side the player is controlling (e.g., "X" or "O").
 * @param name The name of the player.
 */
class RandomPlayer(side: String, name: String) : Player(side, name) {
    override fun getInput(): Position {
        val board = Board.spots
        while (true) {
            val x = (0..2).random()
            val y = (0..2).random()
            if (board[x][y].isFree()) return Position(x, y)
        }
    }
}