package org.jetbrains.kotlinx.tictactoe.outputProvider

import org.jetbrains.kotlinx.tictactoe.Spot

abstract class SpotOutputProvider {
    abstract fun output(spot: Spot)
}