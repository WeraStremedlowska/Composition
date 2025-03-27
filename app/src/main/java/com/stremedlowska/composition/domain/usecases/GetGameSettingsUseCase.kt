package com.stremedlowska.composition.domain.usecases

import com.stremedlowska.composition.domain.entity.GameSettings
import com.stremedlowska.composition.domain.entity.Level
import com.stremedlowska.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}