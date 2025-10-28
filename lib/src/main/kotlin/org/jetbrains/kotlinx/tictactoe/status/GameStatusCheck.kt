package org.jetbrains.kotlinx.tictactoe.status

/**
 * Utility object for evaluating the current status of a game based on predefined win and end conditions.
 *
 * The `GameStatusCheck` object is responsible for managing and checking the state of a game
 * by evaluating a list of win conditions and end conditions. It determines whether
 * the game is won, results in a draw, or is still in progress, providing a simple API
 * for adding, resetting, and checking conditions.
 *
 * It works in conjunction with `WinCondition` and `EndCondition` subclasses, which must implement
 * specific logic for their respective conditions. These subclasses encapsulate the rules for either
 * winning or ending the game without a winner.
 *
 * Functions:
 * - `check`: Evaluates all win and end conditions to determine the game's status.
 *     Returns "WIN" if a win condition is met, "DRAW" if an end condition is met, or "PROGRESS" otherwise.
 * - `addWinCondition`: Adds a new win condition to the list, extending the possible win rules of the game.
 * - `addEndCondition`: Adds a new end condition to the list, defining additional scenarios for game termination without any win.
 * - `reset`: Clears all win and end conditions, resetting the game status check to its initial state.
 */
object GameStatusCheck {
    val winConditions = mutableListOf<WinCondition>()
    val endConditions = mutableListOf<EndCondition>()

    fun check(): String {
        for (condition in winConditions) {
            if (condition.check()) {
                return "WIN"
            }
        }
        for (condition in endConditions) {
            if (condition.check()) {
                return "DRAW"
            }
        }
        return "PROGRESS"
    }

    fun addWinCondition(winCondition: WinCondition) {
        winConditions.add(winCondition)
    }

    fun addEndCondition(endCondition: EndCondition) {
        endConditions.add(endCondition)
    }

    fun reset() {
        winConditions.clear()
        endConditions.clear()
    }
}