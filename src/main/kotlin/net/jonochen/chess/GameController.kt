package net.jonochen.chess

import net.jonochen.chess.model.Board
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/game")
class GameController {

    @GetMapping("print")
    fun print() : String {
        val bd = Board()
        System.out.println(bd.toString())
        return bd.toString()
    }
}