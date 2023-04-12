package com.avingard.chess.player

import com.avingard.chess.data.MatchFound
import com.avingard.chess.data.Games
import com.avingard.chess.data.Opponent
import com.avingard.chess.game.PlayerSet
import com.avingard.chess.game.piece.PieceColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.springframework.stereotype.Component
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.abs
import kotlin.random.Random

@Component
class PlayerQueue(private val games: Games) {
    private val waitingPlayers = MutableStateFlow(emptyMap<Player, Continuation<MatchFound>>())

    suspend fun enqueue(player: Player) = suspendCoroutine { playerContinuation ->
        waitingPlayers.update { players ->
            val waitingPlayer = findClosestMmrLevelPlayer(player, players.keys.toList())
            val waitingPlayerContinuation = players[waitingPlayer]

            updatePlayers(player, waitingPlayer, playerContinuation, waitingPlayerContinuation, players)
        }
    }

    fun dequeue(player: Player) {
        waitingPlayers.update { players ->
            players.minus(player)
        }
    }

    private fun findClosestMmrLevelPlayer(player: Player, waitingPlayers: List<Player>): Player? {
        return waitingPlayers.minByOrNull { waitingPlayer -> abs(waitingPlayer.mmr!! - player.mmr!!) }
    }

    private fun updatePlayers(
        player: Player,
        waitingPlayer: Player?,
        playerContinuation: Continuation<MatchFound>,
        waitingPlayerContinuation: Continuation<MatchFound>?,
        players: Map<Player, Continuation<MatchFound>>
    ): Map<Player, Continuation<MatchFound>> {
        return if (waitingPlayer != null) {
            val (matchFoundForPlayer, matchFoundForWaitingPlayer) = createNewGame(player, waitingPlayer)
            playerContinuation.resume(matchFoundForPlayer)
            waitingPlayerContinuation?.resume(matchFoundForWaitingPlayer)

            players.minus(waitingPlayer)
        } else {
            players.plus(player to playerContinuation)
        }
    }

    private fun createNewGame(player: Player, waitingPlayer: Player): Pair<MatchFound, MatchFound> {
        val playerPieceColor = if (Random.nextBoolean()) PieceColor.LIGHT else PieceColor.DARK
        val waitingPlayerColor = playerPieceColor.opposite()

        val players = PlayerSet()
        players[playerPieceColor] = player
        players[waitingPlayerColor] = waitingPlayer

        val gameId = games.create(players)

        return buildMatchFound(gameId, waitingPlayer, waitingPlayerColor) to buildMatchFound(gameId, player, playerPieceColor)
    }

    private fun buildMatchFound(gameId: String, player: Player, pieceColor: PieceColor): MatchFound {
        return MatchFound(gameId, Opponent(pieceColor, player.name!!))
    }
}