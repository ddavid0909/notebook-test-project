package org.jetbrains.kotlinx.tictactoe.status

import org.jetbrains.kotlinx.tictactoe.Board
import org.jetbrains.kotlinx.tictactoe.player.ComputerPlayer
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DiagonalWinConditionTest {
    val player: Player = ComputerPlayer("X")

    @BeforeEach
    fun setUp() {
        Board.reset()
    }

    @Test
    fun checkDiagonalWin0() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 1,1)
        board.occupy(player, 2,2)
        assertTrue(DiagonalWinCondition().check(0,0), "Main diagonal should be winning")
        assertTrue(DiagonalWinCondition().check(1,1), "Main diagonal should be winning")
        assertTrue(DiagonalWinCondition().check(2,2), "Main diagonal should be winning")
    }

    @Test
    fun checkDiagonalWin1() {
        val board = Board
        board.occupy(player, 0,2)
        board.occupy(player, 1,1)
        board.occupy(player, 2,0)
        assertTrue(DiagonalWinCondition().check(0,2), "Secondary diagonal should be winning")
        assertTrue(DiagonalWinCondition().check(1,1), "Secondary diagonal should be winning")
        assertTrue(DiagonalWinCondition().check(2,0), "Secondary diagonal should be winning")
    }

    @Test
    fun checkNotDiagonalWin() {
        val board = Board
        board.occupy(player, 0,0)
        board.occupy(player, 1,1)
        board.occupy(player, 0,2)
        assertFalse(DiagonalWinCondition().check(0,0), "No diagonal should be winning")
        assertFalse(DiagonalWinCondition().check(1,1), "No diagonal should be winning")
        assertFalse(DiagonalWinCondition().check(0,2), "No diagonal should be winning")
    }

}