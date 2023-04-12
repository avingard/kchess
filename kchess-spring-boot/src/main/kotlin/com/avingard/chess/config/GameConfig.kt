package com.avingard.chess.config

import com.avingard.chess.controllers.AppliedPlayerMove
import com.avingard.chess.data.Games
import kotlinx.coroutines.flow.MutableSharedFlow
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@Configuration
class GameConfig {

    @Bean
    fun games(): Games {
        return Games(ConcurrentHashMap())
    }

    @Bean
    fun moves(): ConcurrentMap<String, MutableSharedFlow<AppliedPlayerMove>> {
        return ConcurrentHashMap()
    }
}