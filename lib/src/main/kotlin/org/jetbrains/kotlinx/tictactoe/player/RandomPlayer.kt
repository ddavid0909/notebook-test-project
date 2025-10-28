package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

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