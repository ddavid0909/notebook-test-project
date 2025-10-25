package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class ColumnWinCondition : WinCondition() {
    override fun check(x:Int, y:Int): Boolean {
        val board = Board.spots
        return board[0][y].getPlayer() == board[1][y].getPlayer() &&
                board[1][y].getPlayer() == board[2][y].getPlayer() &&
                board[2][y].getPlayer() != null
    }
}