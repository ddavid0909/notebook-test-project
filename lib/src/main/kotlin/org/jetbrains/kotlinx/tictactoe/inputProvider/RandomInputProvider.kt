package org.jetbrains.kotlinx.tictactoe.inputProvider

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

class RandomInputProvider: InputProvider() {
    override fun getInput(): Position {
        val board = Board.spots
        while (true) {
            val x = (0..2).random()
            val y = (0..2).random()
            if (board[x][y].isFree()) return Position(x, y)
        }
    }
}