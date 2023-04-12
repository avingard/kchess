package com.example.chess

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.sink(): Flow<List<T>> = flow {
    val elements = mutableListOf<T>()

    collect {
        elements += it
        emit(elements.toList())
    }
}
