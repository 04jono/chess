package net.jonochen.chess.model

import net.jonochen.chess.game.Piece
import net.jonochen.chess.game.Player
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "games")
data class BoardModel(

    @Id
    val id: String = ObjectId().toString(),

    val pieces: Map<String, Piece> = emptyMap(),
    val player: Player = Player.White
)
