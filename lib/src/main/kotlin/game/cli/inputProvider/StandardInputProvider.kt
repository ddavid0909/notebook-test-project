package game.cli.inputProvider

import org.jetbrains.kotlinx.tictactoe.Position
import org.jetbrains.kotlinx.tictactoe.inputProvider.InputProvider

class StandardInputProvider : InputProvider() {
    override fun getInput(): Position {
        println("Enter the coordinates in the format <row> <column>:")
        val input = readln()
        val (x, y) = input.split(' ').map { it.toInt() }
        return Position(x, y)
    }
}