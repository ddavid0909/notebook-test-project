package org.jetbrains.kotlinx.tictactoe.outputProvider

import org.jetbrains.kotlinx.tictactoe.player.Player

/**
 * Abstract class representing an output provider for player-related information.
 *
 * Implementations of this class define how details about a player are presented
 * or displayed during the game. The output method is intended to communicate
 * the current player's side and name
 *
 * This class serves as part of an abstraction layer, making it easier to change
 * or extend the way player information is presented without modifying other parts
 * of the system.
 */
abstract class PlayerOutputProvider {
    abstract fun output(player: Player);
}