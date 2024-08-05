package com.example.repository

import com.example.entity.*
import com.example.models.*
import com.example.util.*
import org.jetbrains.exposed.sql.*

class AnimeQuizRepository {

    private fun resultToRowQuestion(row: ResultRow): Question {
        return Question(
            id = row[QuestionEntity.id],
            question = row[QuestionEntity.question],
            image = row[QuestionEntity.image],
            optionOne = row[QuestionEntity.optionOne],
            optionTwo = row[QuestionEntity.optionTwo],
            optionThree = row[QuestionEntity.optionThree],
            optionFour = row[QuestionEntity.optionFour],
            correctAnswer = row[QuestionEntity.correctAnswer]
        )
    }
    suspend fun getAllQuestions(): List<Question> = DatabaseFactory.databaseQuery {
        QuestionEntity.selectAll().map(::resultToRowQuestion)
    }
}