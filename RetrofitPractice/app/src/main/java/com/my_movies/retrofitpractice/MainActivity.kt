package com.my_movies.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var  tvText: TextView
    private lateinit var  retService : AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.textView)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        getRequestPathParameters()
        getRequestWithQueryParameters()

    }

    private fun getRequestWithQueryParameters(){
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if(albumsList != null){
                while(albumsList.hasNext()){
                    val albumsItem = albumsList.next()
                    val result = " " + "Album id : ${albumsItem.id}" + "\n" +
                            " " + "Album User id : ${albumsItem.userId}" + "\n" +
                            " " + "Album title : ${albumsItem.title}" + "\n" + "\n"
                    tvText.append(result)
                }
            }
        })
    }

    private fun getRequestPathParameters(){
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(4)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }
}