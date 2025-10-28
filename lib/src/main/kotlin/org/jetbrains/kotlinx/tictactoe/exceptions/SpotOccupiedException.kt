package org.jetbrains.kotlinx.tictactoe.exceptions

/**
 * Thrown to indicate that an attempt was made to occupy a spot that is already occupied.
 *
 * The exception message provides additional context indicating that the spot is already occupied.
 * It is commonly used in conjunction with the `Spot` class operations like `occupy`.
 */
class SpotOccupiedException : RuntimeException("This spot is occupied!")