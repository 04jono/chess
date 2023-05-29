package net.jonochen.chess.game

/**
 * Converts a triple of integer coordinates to a triple of algebraic notation
 */
fun fromCoord(triple : Triple<Int, Int, Int>) : Triple<Int, Char, Int> {
    val (vert, x, y) = triple

    if(x < 0 || x > 7) throw RuntimeException()
    if(y < 0 || y > 7) throw RuntimeException()
    val column = (x + 65).toChar()
    val row = y + 1
    return Triple(vert, column, row)
}

/**
 * Converts a triple in algebraic notation to a triple of integer coordinates
 */
fun fromAlgebraic(triple : Triple<Int, Char, Int>) : Triple<Int, Int, Int> {
    val (vert, col, row) = triple

    val x = col.code - 65
    val y = row + 1

    if(x < 0 || x > 7) throw RuntimeException()
    if(y < 0 || y > 7) throw RuntimeException()
    return Triple(vert, x, y)
}