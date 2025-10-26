package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.Position
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RowWinConditionTest {
    val player: Player = Player("X", "Player 1")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkRowWin0() {
        val board = Board
        board.occupy(player, Position(0, 0))
        board.occupy(player, Position(0,1))
        board.occupy(player, Position(0,2))
        assertTrue(RowWinCondition().check(), "Row 0 should be winning")
    }
    @Test
    fun checkRowWin1() {
        val board = Board
        board.occupy(player, Position(1,0))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(1,2))
        assertTrue(RowWinCondition().check(), "Row 1 should be winning")
    }
    @Test
    fun checkRowWin2() {
        val board = Board
        board.occupy(player, Position(2,0))
        board.occupy(player, Position(2,1))
        board.occupy(player, Position(2,2))
        assertTrue(RowWinCondition().check(), "Row 2 should be winning")
    }

    @Test
    fun checkNotRowWin() {
        val board = Board
        board.occupy(player, Position(0,0))
        board.occupy(player, Position(1,1))
        board.occupy(player, Position(2,2))
        assertFalse(RowWinCondition().check(), "No row should be winning")
    }

}