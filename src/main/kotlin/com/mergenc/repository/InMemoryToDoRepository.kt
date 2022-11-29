package com.mergenc.repository

import com.mergenc.entities.ToDo

class InMemoryToDoRepository : ToDoRepository {
    private val todos = listOf<ToDo>(
        ToDo(1, "Homework", true),
        ToDo(2, "Internet Programlama", false),
        ToDo(3, "Backend", true),
    )

    override fun getAllToDos(): List<ToDo> {
        return todos
    }

    override fun getSingleToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }
}