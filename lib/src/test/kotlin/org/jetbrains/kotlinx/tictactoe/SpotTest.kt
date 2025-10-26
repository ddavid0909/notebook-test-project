package org.jetbrains.kotlinx.tictactoe

import org.jetbrains.kotlinx.tictactoe.exceptions.SpotOccupiedException
import org.jetbrains.kotlinx.tictactoe.player.Player
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpotTest {
    val player: Player = Player("X", "Player 1")

    @Test
    fun isFree() {
        val spot = Spot()
        assertTrue(spot.isFree(), "Spot should be free at the beginning")
        spot.occupy(player)
        assertFalse(spot.isFree(), "Spot should be occupied after occupying")
    }

    @Test
    fun getPlayer() {
        val spot = Spot()
        assertNull(spot.player, "Player should be null at the beginning")

        spot.occupy(player)
        assertEquals(player, spot.player, "Player should be set after occupying")
    }

    @Test
    fun occupyFreeSpot() {
        val spot = Spot()
        spot.occupy(player)
        assertEquals(player, spot.player, "Player should be set after occupying")
        assertFalse(spot.isFree(), "Spot should be occupied after occupying")
    }

    @Test
    fun occupyOccupiedSpot() {
        assertThrows(
            SpotOccupiedException::class.java,
            {
                val spot = Spot()
                spot.occupy(player)
                spot.occupy(player)
            },
            "Should throw SpotOccupiedException when occupying occupied spot"
        )
    }
}