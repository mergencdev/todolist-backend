package com.mergenc.repository

import com.mergenc.entities.ToDo

interface ToDoRepository {
    fun getAllToDos(): List<ToDo>
    fun getSingleToDo(id: Int): ToDo?
}