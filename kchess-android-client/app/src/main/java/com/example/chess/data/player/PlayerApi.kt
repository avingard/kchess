package com.example.chess.data.player

import com.avingard.echo.client.GrpcClient
import javax.inject.Inject


class PlayerApi @Inject constructor(
    private val grpcClient: GrpcClient
) {
    suspend fun getPlayer(name: String): Player? {
        return try {
            grpcClient.requestResponse("/chess/players/$name")!!
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}