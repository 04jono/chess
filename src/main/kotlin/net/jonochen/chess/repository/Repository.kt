package net.jonochen.chess.repository

import net.jonochen.chess.model.BoardModel
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface Repository : MongoRepository<BoardModel, String> {
}
