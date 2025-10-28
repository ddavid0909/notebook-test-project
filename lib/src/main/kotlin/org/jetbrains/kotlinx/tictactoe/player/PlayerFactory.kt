package org.jetbrains.kotlinx.tictactoe.player



/**
 * Provides a mechanism to create instances of different types of players in the game.
 * The factory uses a mapping of player types (e.g., "random", "smart", "human") to
 * their respective instantiation logic.
 *
 * This factory supports the following player types:
 * - "random": Creates a RandomPlayer, which selects moves randomly.
 * - "smart": Creates a SmartPlayer, which determines moves using a strategy like Minimax.
 * - "human": Creates a StandardPlayer, allowing a human to provide input for moves.
 *
 * Throws an IllegalArgumentException if an unsupported or unknown player type is requested.
 */
object PlayerFactory {

    /**
     * A mapping of player types to their respective factory functions for creating player instances.
     * The key represents the type of player, and the corresponding factory function takes two parameters:
     * - `side`: The side (e.g., "X" or "O") the player controls in the game.
     * - `name`: The name of the player.
     *
     * Available player types:
     * - "random": Creates an instance of `RandomPlayer`, which selects moves randomly.
     * - "smart": Creates an instance of `SmartPlayer`, which selects moves using a strategic algorithm (e.g., Minimax with alpha-beta pruning).
     * - "human": Creates an instance of `StandardPlayer`, which allows a human player to input their moves via console input.
     * WHEN ADDING A NEW PLAYER TYPE, ADD IT TO THE MAP HERE TOO.
     */
    val factory = mapOf(
        "random" to {side:String, name:String -> RandomPlayer(side, name) },
        "smart" to {side:String, name:String -> SmartPlayer(side, name) },
        "human" to {side:String, name:String -> StandardPlayer(side, name)}
    )

    fun getPlayer(type: String, side: String, name:String): Player = factory[type]?.invoke(side, name) ?: throw IllegalArgumentException("Unknown player of type $type")

}