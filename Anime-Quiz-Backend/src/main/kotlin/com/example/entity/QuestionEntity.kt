package com.example.entity

import org.jetbrains.exposed.sql.*

object QuestionEntity : Table() {
    val id = integer("question_id").autoIncrement()
    val question = varchar("question", length = 255)
    val image = varchar("image", length = 255)
    val optionOne = varchar("option-one", length = 50)
    val optionTwo = varchar("option_two", length = 50)
    val optionThree = varchar("option_three", length = 50)
    val optionFour = varchar("option_four", length = 50)
    val correctAnswer = integer("correct_answer")

    override val primaryKey = PrimaryKey(id)
}