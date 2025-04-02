package com.stremedlowska.composition.data

import com.stremedlowska.composition.domain.entity.GameSettings
import com.stremedlowska.composition.domain.entity.Level
import com.stremedlowska.composition.domain.entity.Question
import com.stremedlowska.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {
    
    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1
    
    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        require(countOfOptions > 0) { "countOfOptions must be greater than zero" }
        require(maxSumValue >= MIN_SUM_VALUE) { "maxSumValue must be at least $MIN_SUM_VALUE" }
        
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val rightAnswer = sum - visibleNumber
        
        val options = HashSet<Int>()
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }
    
    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    10
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    10,
                    60,
                    60
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }
        }
    }
}