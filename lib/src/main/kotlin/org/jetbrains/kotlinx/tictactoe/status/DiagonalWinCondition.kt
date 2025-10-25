package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class DiagonalWinCondition: WinCondition() {
    override fun check(x: Int, y: Int): Boolean {
        val board = Board.spots
        return (board[0][0].getPlayer() == board[1][1].getPlayer() &&
                board[1][1].getPlayer() == board[2][2].getPlayer() &&
                board[2][2].getPlayer() != null) ||
                (board[0][2].getPlayer() == board[1][1].getPlayer() &&
                board[1][1].getPlayer() == board[2][0].getPlayer() &&
                board[2][0].getPlayer() != null)
    }
}