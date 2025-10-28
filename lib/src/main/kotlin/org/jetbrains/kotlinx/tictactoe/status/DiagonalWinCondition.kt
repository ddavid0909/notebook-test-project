package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

/**
 * Represents a win condition where the same player occupies all spots in either diagonal of the board.
 *
 * The `DiagonalWinCondition` class extends the abstract `WinCondition` class
 * and implements the logic for determining whether a win event occurs when a player
 * occupies every position in either of the two diagonals of the game board.
 *
 * The `check` method evaluates the diagonal win condition by ensuring that every spot in a diagonal
 * is occupied by the same player and that the spots are not empty.
 *
 * This class is used along with other win and end condition classes in the `GameStatusCheck`
 * utility to aid in determining the current state of the game.
 */
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