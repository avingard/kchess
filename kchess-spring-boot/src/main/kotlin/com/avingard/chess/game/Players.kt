package com.avingard.chess.game

import com.avingard.chess.game.piece.PieceColor
import com.avingard.chess.game.piece.PieceColor.*
import com.avingard.chess.player.Player

class PlayerSet {
    private lateinit var lightPlayerHolder: Pair<PieceColor, Player>
    private lateinit var darkPlayerHolder: Pair<PieceColor, Player>

    operator fun get(color: PieceColor): Player {
        if (lightPlayerHolder.first == color) {
            return lightPlayerHolder.second
        }
        return darkPlayerHolder.second
    }

    operator fun set(color: PieceColor, player: Player) {
        if (color == LIGHT) {
            lightPlayerHolder = color to player
            return
        }
        darkPlayerHolder = color to player
    }

    fun findById(id: Int): Pair<PieceColor, Player>? {
        if (lightPlayerHolder.second.id == id) {
            return lightPlayerHolder
        }
        if (darkPlayerHolder.second.id == id) {
            return darkPlayerHolder
        }
        return null
    }
}
