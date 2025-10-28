package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

/**
 * Represents a win condition where the same player occupies all spots in any single row.
 *
 * The `RowWinCondition` class extends the abstract `WinCondition` class
 * and implements the logic for checking if a win event occurs when a player
 * occupies all positions in a row on the game board.
 *
 * The `check` method evaluates each row of the game board, verifying whether
 * the same player occupies every spot in a particular row.
 *
 * This class is used alongside other win and end condition classes within
 * the `GameStatusCheck` utility to determine the state of the game.
 */
class RowWinCondition: WinCondition() {
    override fun check(): Boolean {
        val board = Board.spots
        return board.any { row ->
            val p = row[0].player
            p != null && row.all { it.player == p }
        }
    }

}