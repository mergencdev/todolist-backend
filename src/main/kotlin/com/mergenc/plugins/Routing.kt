package com.mergenc.plugins

import com.mergenc.entities.ToDo
import com.mergenc.entities.ToDoDraft
import com.mergenc.repository.InMemoryToDoRepository
import com.mergenc.repository.ToDoRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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
            val todoDraft = call.receive<ToDoDraft>()
            val todo = repository.addTodo(todoDraft)
            call.respond(todo)
        }

        put("/todos/{id}") {
            val todoDraft = call.receive<ToDoDraft>()
            val todoId = call.parameters["id"]?.toIntOrNull()

            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest, "id parameter has to be a number!"
                )
                return@put
            }

            val updated = repository.updateTodo(todoId, todoDraft)
            if (updated) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(
                    HttpStatusCode.NotFound, "found no todo with the id $todoId"
                )
            }
        }

        delete("/todos/{id}") {
            val todoId = call.parameters["id"]?.toIntOrNull()

            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest, "id parameter has to be a number!"
                )
                return@delete
            }

            val removed = repository.removeTodo(todoId)
            if (removed) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(
                    HttpStatusCode.NotFound, "found no todo with the id $todoId"
                )
            }
        }
    }
}
