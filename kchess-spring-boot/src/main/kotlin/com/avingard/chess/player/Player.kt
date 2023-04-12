package com.avingard.chess.player

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "players")
data class Player(
    @Id
    var id: Int? = null,

    val name: String,

    val mmr: Int = 1200
)

