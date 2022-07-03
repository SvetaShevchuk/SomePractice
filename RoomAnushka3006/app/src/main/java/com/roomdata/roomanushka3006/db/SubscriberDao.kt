package com.roomdata.roomanushka3006.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriber: Subscriber)

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber): Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getSubscribers(): LiveData<List<Subscriber>>

}