package org.jetbrains.kotlinx.tictactoe.status

/**
 * Represents a condition that determines if the game has reached its end state.
 *
 * An `EndCondition` provides an abstract method `check`, which must be implemented
 * by concrete subclasses to define specific rules or conditions under which
 * the game ends without resulting in a win. Common implementations might include
 * conditions such as the game board being fully occupied.
 *
 * This class is used in conjunction with `GameStatusCheck` to evaluate the overall
 * state of the game, alongside `WinCondition` for win scenarios.
 *
 * Implementations should override the `check` method to encapsulate their specific
 * end condition logic.
 */
abstract class EndCondition {
    abstract fun check(): Boolean
}