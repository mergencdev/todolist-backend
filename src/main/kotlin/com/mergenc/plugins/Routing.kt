package com.mergenc.plugins

import com.mergenc.entities.ToDo
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        val todos = listOf<ToDo>(
            ToDo(1, "Homework", true),
            ToDo(2, "Internet Programlama", false),
            ToDo(3, "Backend", true),
        )

        get("/") {
            call.respondText("Hello World!")
        }

        get("/todos") {
            call.respond(todos)
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
