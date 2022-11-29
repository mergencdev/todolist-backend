package com.mergenc.repository

import com.mergenc.entities.ToDo
import com.mergenc.entities.ToDoDraft

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>

    fun getSingleToDo(id: Int): ToDo?

    fun addTodo(draft: ToDoDraft): ToDo

    fun removeTodo(id: Int): Boolean

    fun updateTodo(id: Int, draft: ToDoDraft): Boolean
}