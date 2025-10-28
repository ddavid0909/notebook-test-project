package org.jetbrains.kotlinx.tictactoe.outputProvider

import org.jetbrains.kotlinx.tictactoe.Spot

/**
 * Abstract class representing an output provider for spot-related displays or presentations.
 *
 * Defines the blueprint for implementing various methods of visualizing or rendering
 * information about a specific spot on the game board. Each implementation of this class
 * is responsible for determining how a spot's state is output to a particular medium.
 *
 * This abstraction allows flexibility in adding or modifying the way spot information
 * is presented without affecting other parts of the game's output system. Typical usage
 * includes integrating the output of individual spots into larger board display logic.
 */
abstract class SpotOutputProvider {
    abstract fun output(spot: Spot)
}