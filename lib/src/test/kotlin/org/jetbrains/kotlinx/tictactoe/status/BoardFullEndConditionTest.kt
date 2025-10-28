package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.jetbrains.kotlinx.tictactoe.player.StandardPlayer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardFullEndConditionTest {
    val player: Player = StandardPlayer("X", "Player 1")
    @BeforeEach
    fun setUp() {
        Board.reset()
        GameStatusCheck.reset()
    }

    @Test
    fun checkEnd() {
        // Arrange & Act
        val board = Board
        for (row in board.spots) {
            for (spot in row) {
                spot.occupy(player)
            }
        }
        // Assert
        assertTrue(BoardFullEndCondition().check())
    }

    @Test
    fun checkNotEnd() {
        assertFalse(BoardFullEndCondition().check())
    }

}