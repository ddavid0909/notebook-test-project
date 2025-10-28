package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Position

class StandardPlayer(side:String, name:String) : Player(side, name) {
    override fun getInput(): Position {
        println("Enter the coordinates in the format <row> <column>:")
        val input = readln()
        val (x, y) = input.split(' ').map { it.toInt() }
        return Position(x, y)
    }

}