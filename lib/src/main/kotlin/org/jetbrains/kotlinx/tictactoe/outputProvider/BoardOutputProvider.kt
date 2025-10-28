package org.jetbrains.kotlinx.tictactoe.outputProvider

/**
 * Abstract class representing an output provider for board-related displays or presentations.
 *
 * Defines the blueprint for implementing various methods of displaying or rendering
 * the game board, such as visualizing the current state of the board grid.
 *
 * Concrete implementations of this class are responsible for outputting the board's
 * structure and the state of individual spots to a particular output medium,
 * such as the console, a graphical interface, or logs.
 *
 * This abstraction allows flexibility in modifying or extending board presentation
 * mechanisms without altering the underlying game logic.
 */
abstract class BoardOutputProvider {
    abstract fun output();
}