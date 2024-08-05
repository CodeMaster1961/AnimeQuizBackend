package com.example.routing


import com.example.repository.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.animeQuizRouting() {
    get("/getQuestions") {
        val allQuestions = AnimeQuizRepository().getAllQuestions()
        call.respond(HttpStatusCode.OK, allQuestions)
    }
}