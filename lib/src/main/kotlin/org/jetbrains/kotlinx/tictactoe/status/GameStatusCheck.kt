package org.jetbrains.kotlinx.tictactoe.status

object GameStatusCheck {
    val winConditions = mutableListOf<WinCondition>()
    val endConditions = mutableListOf<EndCondition>()

    fun check(x:Int, y:Int): String {
        for (condition in winConditions) {
            if (condition.check(x,y)) {
                return "WIN"
            }
        }
        for (condition in endConditions) {
            if (condition.check()) {
                return "DRAW"
            }
        }
        return "PROGRESS"
    }

    fun addWinCondition(winCondition: WinCondition) {
        winConditions.add(winCondition)
    }

    fun addEndCondition(endCondition: EndCondition) {
        endConditions.add(endCondition)
    }

    fun reset() {
        winConditions.clear()
        endConditions.clear()
    }
}