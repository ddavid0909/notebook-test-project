package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class DiagonalWinCondition: WinCondition() {
    override fun check(): Boolean {
        val board = Board.spots
        return (board[0][0].player == board[1][1].player &&
                board[1][1].player == board[2][2].player &&
                board[2][2].player != null) ||
                (board[0][2].player == board[1][1].player &&
                board[1][1].player == board[2][0].player &&
                board[2][0].player != null)
    }
}