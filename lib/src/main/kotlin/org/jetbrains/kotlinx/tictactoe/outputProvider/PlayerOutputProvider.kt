package org.jetbrains.kotlinx.tictactoe.outputProvider

import org.jetbrains.kotlinx.tictactoe.player.Player

abstract class PlayerOutputProvider {
    abstract fun output(player: Player);
}