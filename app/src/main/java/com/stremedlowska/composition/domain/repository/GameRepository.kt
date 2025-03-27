package com.stremedlowska.composition.domain.repository

import com.stremedlowska.composition.domain.entity.GameSettings
import com.stremedlowska.composition.domain.entity.Level
import com.stremedlowska.composition.domain.entity.Question

interface GameRepository {
    
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question
    
    fun getGameSettings(level: Level): GameSettings

}