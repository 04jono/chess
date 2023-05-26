package net.jonochen.chess.model

/**
 * Converts a triple of integer coordinates to a triple of algebraic notation
 */
fun fromCoord(triple : Triple<Int, Int, Int>) : Triple<Char, Char, Int> {
    val (vert, x, y) = triple
    val greek = when(vert) {
        0 -> 'K'
        1 -> 'L'
        2 -> 'M'
        else -> throw RuntimeException()
    }

    if(x < 0 || x > 7) throw RuntimeException()
    if(y < 0 || y > 7) throw RuntimeException()
    val column = (x + 65).toChar()
    val row = y + 1
    return Triple(greek, column, row)
}

/**
 * Converts a triple in algebraic notation to a triple of integer coordinates
 */
fun fromAlgebraic(triple : Triple<Char, Char, Int>) : Triple<Int, Int, Int> {
    val (greek, col, row) = triple
    val vert = when(greek) {
        'K' -> 0
        'L' -> 1
        'M' -> 2
        else -> throw RuntimeException()
    }

    val x = col.code - 65
    val y = row + 1

    if(x < 0 || x > 7) throw RuntimeException()
    if(y < 0 || y > 7) throw RuntimeException()
    return Triple(vert, x, y)
}