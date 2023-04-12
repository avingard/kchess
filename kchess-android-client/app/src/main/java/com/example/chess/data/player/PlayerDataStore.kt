package com.example.chess.data.player

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "player")

@Singleton
class PlayerDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val dataStore = context.dataStore

    suspend fun save(player: Player) {
        dataStore.edit { store ->
            store[PLAYER_NAME] = player.name
        }
    }

    suspend fun clear() {
        dataStore.edit { store ->
            store.clear()
        }
    }

    suspend fun getSavedPlayerName(): String? {
        return dataStore.data.first()[PLAYER_NAME]
    }

    companion object {
        private val PLAYER_NAME = stringPreferencesKey("player_name")
    }
}