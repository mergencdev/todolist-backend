package com.mergenc.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/todos") {

        }

        get("/todos/{id}") {
            val id = call.parameters["id"]
            call.respondText("Todolist details: #$id")
        }

        post("/todos") {

        }

        put("/todos/{id}") {

        }

        delete("/todos/{id}") {

        }
    }
    routing {}
}
