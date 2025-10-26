package org.jetbrains.kotlinx.tictactoe.player

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.inputProvider.InputProvider
import org.jetbrains.kotlinx.tictactoe.inputProvider.SmartInputProvider
import game.cli.inputProvider.StandardInputProvider

class Player(val side:String, val name: String, val inputProvider: InputProvider = StandardInputProvider()) {
    fun makeMove(){
        val position = inputProvider.getInput()
        Board.occupy(this, position)
    };

}