package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.player.ComputerPlayer
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ColumnWinConditionTest {
    val player: Player = ComputerPlayer("X")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkColumnWin0() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 1,0)
        board.occupy(player, 2,0)
        assertTrue(ColumnWinCondition().check(0,0), "Column 0 should be winning")
        assertTrue(ColumnWinCondition().check(1,0), "Column 0 should be winning")
        assertTrue(ColumnWinCondition().check(2,0), "Column 0 should be winning")
    }

    @Test
    fun checkColumnWin1() {
        val board = Board
        board.occupy(player, 0,1)
        board.occupy(player, 1,1)
        board.occupy(player, 2,1)
        assertTrue(ColumnWinCondition().check(0,1), "Column 1 should be winning")
        assertTrue(ColumnWinCondition().check(1,1), "Column 1 should be winning")
        assertTrue(ColumnWinCondition().check(2,1), "Column 1 should be winning")
    }

    @Test
    fun checkColumnWin2() {
        val board = Board
        board.occupy(player, 0,2)
        board.occupy(player, 1,2)
        board.occupy(player, 2,2)
        assertTrue(ColumnWinCondition().check(0,2), "Column 2 should be winning")
        assertTrue(ColumnWinCondition().check(1,2), "Column 2 should be winning")
        assertTrue(ColumnWinCondition().check(2,2), "Column 2 should be winning")
    }

    @Test
    fun checkNotColumnWin() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 1,1)
        board.occupy(player, 2,2)
        assertFalse(ColumnWinCondition().check(0,0), "No column should be winning")
        assertFalse(ColumnWinCondition().check(1,1), "No column should be winning")
        assertFalse(ColumnWinCondition().check(2,2), "No column should be winning")
    }
}