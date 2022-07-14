package com.roomdata.recyclerviewroman

import android.app.Application
import com.roomdata.recyclerviewroman.model.UserService

class App: Application() {
    val userService = UserService()
}