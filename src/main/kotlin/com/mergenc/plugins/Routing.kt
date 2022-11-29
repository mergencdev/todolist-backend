package com.mergenc.plugins

import com.mergenc.entities.ToDo
import com.mergenc.repository.InMemoryToDoRepository
import com.mergenc.repository.ToDoRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        val repository: ToDoRepository = InMemoryToDoRepository()

        get("/") {
            call.respondText("Hello World!")
        }

        get("/todos") {
            call.respond(repository.getAllToDos())
        }

        get("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respondText("Invalid or missing id", status = io.ktor.http.HttpStatusCode.BadRequest)
                return@get
            }

            var todo = repository.getSingleToDo(id)
            if (todo == null) {
                call.respondText("No todo with id $id", status = io.ktor.http.HttpStatusCode.NotFound)
                return@get
            } else {
                call.respond(todo)
            }
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
