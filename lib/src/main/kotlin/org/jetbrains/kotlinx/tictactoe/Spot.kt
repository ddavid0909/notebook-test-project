package org.jetbrains.kotlinx.tictactoe

import org.jetbrains.kotlinx.tictactoe.exceptions.SpotOccupiedException
import org.jetbrains.kotlinx.tictactoe.player.Player

class Spot {
    private var player: Player? = null
    fun occupy(player: Player) {
        if (!this.isFree()) throw SpotOccupiedException()
        this.player = player
    }

    fun isFree(): Boolean {
        return this.player == null
    }

    fun getPlayer(): Player? {
        return this.player
    }

    fun clear() {
        this.player = null
    }
}