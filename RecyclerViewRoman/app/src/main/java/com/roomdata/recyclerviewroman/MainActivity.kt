package com.roomdata.recyclerviewroman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomdata.recyclerviewroman.databinding.ActivityMainBinding
import com.roomdata.recyclerviewroman.model.User
import com.roomdata.recyclerviewroman.model.UserService
import com.roomdata.recyclerviewroman.model.UsersListener

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var   adapter : UserAdapter
    private val userService: UserService
        get() = (applicationContext as App).userService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(object: UserActionListener{
            override fun onUserMove(user: User, moveBy: Int) {
                userService.moveUser(user, moveBy)
            }

            override fun onUserDelete(user: User) {
                userService.deleteUser(user)
            }

            override fun onUserDetails(user: User) {
                Toast.makeText(this@MainActivity, "${user.name} is clicked",Toast.LENGTH_SHORT).show()
            }

        })

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        userService.addListener(usersListener)
    }

    private val usersListener: UsersListener = {
        adapter.users = it
    }
}