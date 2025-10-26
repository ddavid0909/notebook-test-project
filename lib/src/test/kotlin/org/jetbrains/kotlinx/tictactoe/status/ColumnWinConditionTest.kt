package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ColumnWinConditionTest {
    val player: Player = Player("X", "Player 1")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkColumnWin0() {
        val board = Board
        board.occupy(player, Position(0, 0))
        board.occupy(player, Position(1,0))
        board.occupy(player, Position(2,0))
        assertTrue(ColumnWinCondition().check(), "Column 0 should be winning")
    }

    @Test
    fun checkColumnWin1() {
        val board = Board
        board.occupy(player, Position(0,1))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(2,1))
        assertTrue(ColumnWinCondition().check(), "Column 1 should be winning")
    }

    @Test
    fun checkColumnWin2() {
        val board = Board
        board.occupy(player, Position(0,2))
        board.occupy(player, Position(1,2))
        board.occupy(player, Position(2,2))
        assertTrue(ColumnWinCondition().check(), "Column 2 should be winning")
    }

    @Test
    fun checkNotColumnWin() {
        val board = Board
        board.occupy(player, Position(0,0))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(2,2))
        assertFalse(ColumnWinCondition().check(), "No column should be winning")
    }
}