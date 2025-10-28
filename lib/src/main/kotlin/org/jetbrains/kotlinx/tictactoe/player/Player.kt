package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position

abstract class Player(val side:String, val name: String) {
    fun makeMove(){
        val position = this.getInput()
        Board.occupy(this, position)
    }

    abstract fun getInput(): Position

}