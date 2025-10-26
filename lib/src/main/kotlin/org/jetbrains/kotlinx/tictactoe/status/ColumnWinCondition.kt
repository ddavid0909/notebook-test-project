package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class ColumnWinCondition : WinCondition() {
    override fun check(): Boolean {
        val board = Board.spots

        return (0..2).any { col ->
            val p = board[0][col].player
            p != null && board.all { row -> row[col].player == p }
        }
    }
}