package com.mergenc.repository

import com.mergenc.database.DatabaseManager
import com.mergenc.entities.ToDo
import com.mergenc.entities.ToDoDraft

class MySqlTodoRepository : ToDoRepository {

    private val database = DatabaseManager()

    override fun getAllToDos(): List<ToDo> {
        return database.getAllTodos().map { ToDo(it.id, it.title, it.done) }
    }

    override fun getSingleToDo(id: Int): ToDo? {
        TODO("Not yet implemented")
    }

    override fun addTodo(draft: ToDoDraft): ToDo {
        TODO("Not yet implemented")
    }

    override fun removeTodo(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateTodo(id: Int, draft: ToDoDraft): Boolean {
        TODO("Not yet implemented")
    }
}