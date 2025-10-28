package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

/**
 * Represents a win condition where the same player occupies all spots in any single column.
 *
 * The `ColumnWinCondition` class extends the abstract `WinCondition` class
 * and implements the logic for determining whether a win event occurs when a player
 * occupies every position in a column on the game board.
 *
 * The `check` method evaluates each column of the game board, verifying whether
 * the same player occupies all spots in a particular column.
 *
 * This class is used in conjunction with other win and end condition classes as part
 * of the `GameStatusCheck` utility to determine the overall state of the game.
 */
class ColumnWinCondition : WinCondition() {
    override fun check(): Boolean {
        val board = Board.spots

        return (0..2).any { col ->
            val p = board[0][col].player
            p != null && board.all { row -> row[col].player == p }
        }
    }
}