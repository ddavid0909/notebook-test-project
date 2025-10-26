package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class RowWinCondition: WinCondition() {
    override fun check(): Boolean {
        val board = Board.spots
        return board.any { row ->
            val p = row[0].player
            p != null && row.all { it.player == p }
        }
    }

}