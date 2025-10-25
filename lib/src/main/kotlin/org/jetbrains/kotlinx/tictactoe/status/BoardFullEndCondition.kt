package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board

class BoardFullEndCondition: EndCondition() {
    override fun check(): Boolean {
        for (row in Board.spots) {
            for (spot in row) {
                if (spot.isFree()) return false
            }
        }
        return true
    }
}