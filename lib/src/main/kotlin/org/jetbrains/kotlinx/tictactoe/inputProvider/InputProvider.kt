package org.jetbrains.kotlinx.tictactoe.inputProvider

import org.jetbrains.kotlinx.tictactoe.Position

abstract class InputProvider {
    abstract fun getInput(): Position
}