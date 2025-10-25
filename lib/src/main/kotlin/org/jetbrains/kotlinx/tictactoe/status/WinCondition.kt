package org.jetbrains.kotlinx.tictactoe.status

abstract class WinCondition {
    abstract fun check(x:Int, y:Int): Boolean
}