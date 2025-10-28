package org.jetbrains.kotlinx.tictactoe.status

/**
 * Represents a condition required to achieve a win in the game.
 *
 * The `WinCondition` class is an abstract base class that defines the structure
 * for implementing specific win conditions in the game. Subclasses must implement
 * the `check` method to define the actual logic of a win condition, such as when
 * a player has a full row, column, or diagonal on the board.
 *
 * This class is typically used in conjunction with the `GameStatusCheck` utility
 * to evaluate the game's state. Implementations of `WinCondition` are added to
 * the `GameStatusCheck` and are evaluated to determine if a win event occurs.
 *
 * Examples of concrete implementations include:
 * - Checking for a winning combination in a row
 * - Checking for a winning combination in a column
 * - Checking for a winning combination in diagonals
 */
abstract class WinCondition {
    abstract fun check(): Boolean
}