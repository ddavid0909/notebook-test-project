package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class RowWinCondition: WinCondition() {
    override fun check(x: Int, y: Int): Boolean {
        val board = Board.spots[x]
        return board[0].getPlayer() == board[1].getPlayer() &&
                board[1].getPlayer() == board[2].getPlayer() &&
                board[2].getPlayer() != null
    }
}