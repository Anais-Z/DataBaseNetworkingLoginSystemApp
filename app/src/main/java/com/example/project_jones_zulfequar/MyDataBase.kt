package com.example.project_jones_zulfequar

import android.content.Context
import androidx.room.*


    @Database(entities = [Records::class], version = 1)
    abstract class MyDatabase : RoomDatabase() {

        abstract fun  recordsDao() : RecordsDao
        companion object {
            private var instance: MyDatabase? = null
            fun getDatabase(context: Context): MyDatabase? {
                if (instance == null) {
                    synchronized(MyDatabase::class){
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            MyDatabase::class.java,
                            "MyDB"
                        ).allowMainThreadQueries().build()

                    }

                }

                return instance
            }
        }
    }
