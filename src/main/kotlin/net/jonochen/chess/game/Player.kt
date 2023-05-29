package net.jonochen.chess.game

enum class Player {
    White,
    Black
}

fun nextPlayer(p : Player) : Player {
    return when(p){
        Player.White -> Player.Black
        Player.Black -> Player.White
    }
}