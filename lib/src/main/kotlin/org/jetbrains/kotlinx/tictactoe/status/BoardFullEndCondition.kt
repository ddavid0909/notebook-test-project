package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

/**
 * Represents an end condition for a game where the board is completely occupied.
 *
 * A `BoardFullEndCondition` checks whether all spots on the game board are occupied,
 * signaling the end of the game if no moves can be made.
 * This is typically used in "draw" scenarios where the game ends without a winner.
 *
 * This class extends the abstract `EndCondition` class and provides the specific
 * implementation of the `check` method to validate this condition. It evaluates if
 * all rows and spots on the board are occupied by checking that none of the spots
 * are marked as free.
 *
 * Use this condition in conjunction with other game conditions, such as
 * `WinCondition`, to determine the game state via `GameStatusCheck`.
 */
class BoardFullEndCondition: EndCondition() {
    override fun check(): Boolean =
        Board.spots.all { row -> row.all { spot -> !spot.isFree() } }

}