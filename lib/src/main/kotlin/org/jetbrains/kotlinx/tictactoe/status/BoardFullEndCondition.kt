package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class BoardFullEndCondition: EndCondition() {
    override fun check(): Boolean =
        Board.spots.all { row -> row.all { spot -> !spot.isFree() } }

}