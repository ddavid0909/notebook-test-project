package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.player.ComputerPlayer
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RowWinConditionTest {
    val player: Player = ComputerPlayer("X")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkRowWin0() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 0,1)
        board.occupy(player, 0,2)
        assertTrue(RowWinCondition().check(0,0), "Row 0 should be winning")
        assertTrue(RowWinCondition().check(0,1), "Row 0 should be winning")
        assertTrue(RowWinCondition().check(0,2), "Row 0 should be winning")
    }
    @Test
    fun checkRowWin1() {
        val board = Board
        board.occupy(player, 1,0)
        board.occupy(player, 1,1)
        board.occupy(player, 1,2)
        assertTrue(RowWinCondition().check(1,0), "Row 1 should be winning")
        assertTrue(RowWinCondition().check(1,1), "Row 1 should be winning")
        assertTrue(RowWinCondition().check(1,2), "Row 1 should be winning")
    }
    @Test
    fun checkRowWin2() {
        val board = Board
        board.occupy(player, 2,0)
        board.occupy(player, 2,1)
        board.occupy(player, 2,2)
        assertTrue(RowWinCondition().check(2,0), "Row 2 should be winning")
        assertTrue(RowWinCondition().check(2,1), "Row 2 should be winning")
        assertTrue(RowWinCondition().check(2,2), "Row 2 should be winning")
    }

    @Test
    fun checkNotRowWin() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 1,1)
        board.occupy(player, 2,2)
        assertFalse(RowWinCondition().check(0,0), "No row should be winning")
        assertFalse(RowWinCondition().check(1,1), "No row should be winning")
        assertFalse(RowWinCondition().check(2,2), "No row should be winning")
    }

}