package com.roomdata.retrofitanushka2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TodosInterface {

    @GET("/todos")
    suspend fun getTodos(): Response<MyTodos>

    @GET("/todos")
    suspend fun getSortedTodos(@Query("userId") userId:Int): Response<MyTodos>

    @GET("/todos/{id}")
    suspend fun getOneTodo(@Path("id") id: Int):Response<MyTodosItem>
}