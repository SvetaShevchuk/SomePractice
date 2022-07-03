package com.roomdata.roomanushka3006.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1, exportSchema = false)
abstract class SubscriberDataBase: RoomDatabase() {
    abstract val subscriberDao: SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE: SubscriberDataBase? = null

        fun getInstance(context: Context): SubscriberDataBase{
            var instance = INSTANCE
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    SubscriberDataBase::class.java,
                    "subscriber_data_database"
                ).build()
            }
            return instance
        }

    }

}