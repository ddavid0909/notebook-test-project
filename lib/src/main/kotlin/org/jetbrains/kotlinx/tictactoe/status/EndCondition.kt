package org.jetbrains.kotlinx.tictactoe.status

abstract class EndCondition {
    abstract fun check(): Boolean
}