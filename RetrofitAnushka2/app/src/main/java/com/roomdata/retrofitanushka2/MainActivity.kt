package com.roomdata.retrofitanushka2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.roomdata.retrofitanushka2.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(TodosInterface::class.java)

        val responseLiveData: LiveData<Response<MyTodos>> = liveData {
            val response = retrofitInstance.getTodos()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val listTodos = it.body()?.listIterator()
            if(listTodos != null){
                while (listTodos.hasNext()){
                    var itemTodos = listTodos.next()

                    val result = "id = ${itemTodos.id}" + "\n"+
                            "userId = ${itemTodos.userId}" + "\n"+
                            "title = ${itemTodos.title}" + "\n"+
                            "completed = ${itemTodos.completed}" + "\n"

                    binding.textView.append(result)
                }
            }
        })

        val responseLiveDataId: LiveData<Response<MyTodosItem>> = liveData {
            val response = retrofitInstance.getOneTodo(40)
            emit(response)
        }

        responseLiveDataId.observe(this, Observer {
            val itemId = it.body()?.title
            Toast.makeText(this, "Title number ${it.body()?.id} = $itemId", Toast.LENGTH_LONG)
                .show()
        })

    }
}